package ch.epfl.cs107.play.game.actor;



import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.Positionable;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.WheelConstraint;
import ch.epfl.cs107.play.math.WheelConstraintBuilder;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Keyboard;
import ch.epfl.cs107.play.window.Window;
import java.util.ArrayList;


public abstract class ActorGame implements Game {
	private Window window;
	//should this really be a static ? how can we improve this ?
	private World world;
	private Actor actor;
	private FileSystem fileSystem;
	private Vector viewCenter ;
	private Vector viewTarget ;
	private Positionable viewCandidate ; //l’on re-centre la caméra directement sur 
										 //viewCandidate à chaque update
	private static final float VIEW_TARGET_VELOCITY_COMPENSATION = 0.2f ;
	private static final float VIEW_INTERPOLATION_RATIO_PER_SECOND = 0.1f ;
	private static final float VIEW_SCALE = 10.0f ;
	private ArrayList<Actor> operatingActor = new ArrayList<Actor>();
	private Entity vehicle;
	private Entity body;
	private Vector anchor; 
	private Vector axis;
	
	
	public Keyboard getKeyboard(){
		return window.getKeyboard();
		
	}
	
	public Canvas getCanvas() {
		return window;
		
	}
	
	//--------------------------------------------
	
	public void actorListAddActor(Actor actor) {
		operatingActor.add(actor);
		
	}
	
	
	//select the the line that you want to remove from your actorArray
	public void actorListRemoveActor(int indexOfLine) {
		operatingActor.remove(indexOfLine);
	}
	
	//-----------------------------------------------
	
	public boolean begin(Window window,FileSystem fileSystem) {
		this.window = window;
		this.fileSystem = fileSystem;
		world = new World();
		viewCenter = Vector.ZERO;
		viewTarget = Vector.ZERO;
		world.setGravity(new Vector(0.0f, -9.81f));
		
		
		return true;
		
	}
	
	//----------------------------------------------
	
	
	
	
	public void end() {
	}

	
	public void update(float deltaTime) {
		world.update(deltaTime);
		
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
		
		for (Actor actor : this.operatingActor) {
			actor.update(deltaTime);
			
		}
		
		for (Actor actor : this.operatingActor) {
			actor.draw(window);
		}
	}
		
		
	//------------------------------------------------------------
	
	public void setViewCandidate(Positionable viewCandidate) {
			this.viewCandidate = viewCandidate;
			
		}
		
	//------------------------------------------------------------
	
	
	//To answer Q2 creates entity builder without access to world
	public EntityBuilder CreateEntityBuilder() {
		return world.createEntityBuilder();
	}



	public WheelConstraint CreateWheelConstraintBuilder(Entity vehicle,Entity body, Vector anchor, Vector axis ) {
		this.vehicle = vehicle;
		this.body = body;
		this.anchor = anchor;
		
		WheelConstraintBuilder constraintBuilder = world.createWheelConstraintBuilder() ;
		constraintBuilder.setFirstEntity(vehicle) ;
		// point d'ancrage du véhicule :
		constraintBuilder.setFirstAnchor(anchor) ;
		// Entity associée à la roue :
		constraintBuilder.setSecondEntity(body) ;
		// point d'ancrage de la roue (son centre) :
		constraintBuilder.setSecondAnchor(Vector.ZERO) ;
		// axe le long duquel la roue peut se déplacer :
		constraintBuilder.setAxis(axis) ;
		// fréquence du ressort associé
		constraintBuilder.setFrequency (3.0f) ;
		constraintBuilder.setDamping (0.5f) ;
		// force angulaire maximale pouvant être appliquée
		//à la roue pour la faire tourner :
		constraintBuilder.setMotorMaxTorque (10.0f) ;
		return constraintBuilder.build () ;
	}
	
}
	
	/**
	* Simulates a single time step.
	* @param deltaTime elapsed time since last update , in
	seconds , non -negative
	*/
	
