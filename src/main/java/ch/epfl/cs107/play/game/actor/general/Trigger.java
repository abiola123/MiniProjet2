package ch.epfl.cs107.play.game.actor.general;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Contact;
import ch.epfl.cs107.play.math.ContactListener;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Trigger extends GameEntity implements Actor{
	private Entity body = getEntity();
	private ImageGraphics triggerGraphics;
	private PartBuilder partBuilder;
	private boolean gotHit;
	private BasicContactListener contactListener;
	//creates an entity that react to a conctact with the bike
	public Trigger(ActorGame game, boolean fixed, Vector position, String graphics, float graphicsWidth, float graphicsHeight) {
		super(game,fixed,position);

		partBuilder = body.createPartBuilder();
		Circle circle = new Circle(1.5f);
		partBuilder.setShape(circle);
		partBuilder.setGhost(true);
		partBuilder.build();
		triggerGraphics = new ImageGraphics(graphics,graphicsWidth,graphicsHeight);
		triggerGraphics.setParent(body);


		//makes the trigger receptive to contact with other objects
		contactListener = new BasicContactListener () ;
		body.addContactListener(contactListener) ;


	}

	//gives the posssibility to change the graphics of the trigger
	public void setTriggerGraphics(String graphics) {
		triggerGraphics = new ImageGraphics(graphics,1,1);
		triggerGraphics.setParent(body);
	}


	@Override
	public void update(float deltaTime) {
		int numberOfCollisions = contactListener.getEntities().size();
		if(numberOfCollisions>1) {
			gotHit = true;
		}
	}

	@Override
	public Transform getTransform() {
		return getTransform();
	}


	@Override
	public void draw(Canvas canvas) {
		triggerGraphics.draw(canvas);

	}
	//checks if the trigger got hit, returns a boolean
	public boolean gotHit() {

		return gotHit;  
	}

	//setter for gotHit, prevents an infinite loop of collectedKeys in bikeGame 
	public void setGotHit(boolean gothit) {
		gotHit = gothit;
	}
	//lets you destroy the trigger
	public void destroy() {
		body.destroy();
	}

}
