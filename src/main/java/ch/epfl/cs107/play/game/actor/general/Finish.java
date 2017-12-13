package ch.epfl.cs107.play.game.actor.general;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.bike.Bike;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Contact;
import ch.epfl.cs107.play.math.ContactListener;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Finish extends Trigger {
	private Entity body = getEntity();
	private Entity body2 = getEntity();
	private ImageGraphics flagGraphics;
	private ImageGraphics finishGraphics;
	private PartBuilder partBuilder;
	private PartBuilder partBuilder2;
	private ActorGame game;
	private String graphics = "flag.red.png";
	private Vector position;
	private Contact contact;
	private boolean gotHit;

	//creates a circle shaped trigger that reacts when the player hits it
	//private BasicContactListener contactListener ;


	public Finish(ActorGame game, boolean fixed , Vector position , String graphics , float graphicsWidth, float graphicsHeight) {
		super(game,fixed,position,graphics,graphicsWidth,graphicsHeight);
		partBuilder = body.createPartBuilder();
		Circle circle = new Circle (1f);
		partBuilder.setShape(circle);
		partBuilder.setGhost(true);
		partBuilder.build();
		finishGraphics = new ImageGraphics(graphics,graphicsWidth,graphicsHeight);
		finishGraphics.setParent(body);

		//		contactListener = new BasicContactListener () ;
		//		body.addContactListener(contactListener) ;
		//		


	}

	public void setFinishGraphics(String graphics) {
		finishGraphics = new ImageGraphics(graphics,1,1);
		finishGraphics.setParent(body);
	}

	//	public boolean contact(Entity entity) {
	//		return contactListener.hasContactWith(entity);
	//	}
	
	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Canvas canvas) {
		finishGraphics.draw(canvas);
	}


}



