package ch.epfl.cs107.play.game.actor;



import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.Positionable;
import ch.epfl.cs107.play.math.RevoluteConstraintBuilder;
import ch.epfl.cs107.play.math.RopeConstraintBuilder;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.WheelConstraint;
import ch.epfl.cs107.play.math.WheelConstraintBuilder;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Keyboard;
import ch.epfl.cs107.play.window.Window;
import java.util.ArrayList;

import com.sun.glass.events.KeyEvent;


public abstract class ActorGame implements Game {
	private Window window;
	private World world;
	private Actor actor;
	private FileSystem fileSystem;
	private Vector viewCenter ;
	private Vector viewTarget ;
	private Positionable viewCandidate ;

	//camera attributs
	private static final float VIEW_TARGET_VELOCITY_COMPENSATION = 0.2f ;
	private static final float VIEW_INTERPOLATION_RATIO_PER_SECOND = 0.1f ;
	private static final float VIEW_SCALE = 30.0f ;

	//contains all the actors of the game
	private ArrayList<Actor> operatingActor = new ArrayList<Actor>();



	public Keyboard getKeyboard(){
		return window.getKeyboard();

	}

	public Canvas getCanvas() {
		return window;

	}

	//-------------------------------------------------------------

	//adds actor to operatingActorList
	public void actorListAddActor(Actor actor) {
		getOperatingActor().add(actor);

	}


	//select the the line that you want to remove from your actorArray
	public void actorListRemoveActor(int indexOfLine) {
		getOperatingActor().remove(indexOfLine);
	}

	//-------------------------------------------------------------

	public boolean begin(Window window,FileSystem fileSystem) {
		this.window = window;
		this.fileSystem = fileSystem;
		world = new World();
		viewCenter = Vector.ZERO;
		viewTarget = Vector.ZERO;
		world.setGravity(new Vector(0.0f, -9.81f));

		return true;
	}

	//-------------------------------------------------------------



	//ends game, destroys all the actors and removes them from the operatingActorList
	public void end() {
		for(int i = 0; i <operatingActor.size(); i++ ) {
			operatingActor.get(i).destroy();
		}
		getOperatingActor().clear();
	}

	//-------------------------------------------------------------

	/**
	 * Simulates a single time step.
	 * @param deltaTime elapsed time since last update , in
	seconds , non -negative
	 */

	//-------------------------------------------------------------

	public void update(float deltaTime) {
		world.update(deltaTime);
		//controls for restarting the game
		if (window.getKeyboard().get(KeyEvent.VK_R).isPressed()) {
			end();
			begin(window, fileSystem);
		}

		// Update expected viewport center
		if (viewCandidate != null) {
			viewTarget =
					viewCandidate.getPosition ().add(viewCandidate.getVelocity ()
							.mul(VIEW_TARGET_VELOCITY_COMPENSATION)) ;
		}
		// Interpolate with previous location
		float ratio = (float)Math.pow(VIEW_INTERPOLATION_RATIO_PER_SECOND ,
				deltaTime) ;
		viewCenter = viewCenter.mixed(viewTarget , ratio) ;
		// Compute new viewport
		Transform viewTransform =
				Transform.I.scaled(VIEW_SCALE).translated(viewCenter) ;
		window.setRelativeTransform(viewTransform) ;

		for (Actor actor : this.getOperatingActor()) {
			actor.update(deltaTime);

		}

		for (Actor actor : this.getOperatingActor()) {
			actor.draw(window);
		}
	}


	public ArrayList<Actor> getOperatingActor() {
		return operatingActor;
	}

	//-------------------------------------------------------------

	public void setViewCandidate(Positionable viewCandidate) {
		this.viewCandidate = viewCandidate;

	}

	//-------------------------------------------------------------

	//----------------------CONSTRAINTS----------------------------	

	//Creates entity builder without giving access to world
	public EntityBuilder CreateEntityBuilder() {
		return world.createEntityBuilder();
	}


	//Creates constraints to attach wheels to the bike
	public WheelConstraintBuilder CreateWheelConstraintBuilder() {
		return world.createWheelConstraintBuilder(); }


	//Creates constraint to attach the plank and circle of the seasaw
	public RevoluteConstraintBuilder CreateRevoluteConstraintBuilder() {
		return world.createRevoluteConstraintBuilder();
	}

	//Creates constraint to attach the circle and the crate of the "pendule"
	public RopeConstraintBuilder CreateRopeConstraintBuilder() {
		return world.createRopeConstraintBuilder();
	}

	//--------------------------------------------------------------


	//Used for GravityWell extension , keeps world private
	public void setWellGravity(Vector gravity) {
		world.setGravity(gravity);
	}
}


