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

public class Finish extends GameEntity implements Actor {
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

//test
private BasicContactListener contactListener ;


	public Finish(ActorGame game, boolean fixed , Vector position , String graphics ) {
		super(game,fixed,position);
		partBuilder = body.createPartBuilder();
		//we do not need a modifiable radius for the cirlce beacause we do not want to modify it later ?
		Circle circle = new Circle (0.1f);
		partBuilder.setShape(circle);
		partBuilder.build();
		partBuilder.setGhost(true);
		finishGraphics = new ImageGraphics(graphics,1,1);
		finishGraphics.setParent(body);
		
		contactListener = new BasicContactListener () ;
		body.addContactListener(contactListener) ;
		
		
		
		//this is for the flag in the beggining of the game
		partBuilder2 = body2.createPartBuilder();
		Circle circle2 = new Circle (0.1f);
		partBuilder2.setShape(circle2);
		partBuilder2.build();
		partBuilder.setGhost(true);
		flagGraphics = new ImageGraphics("flag.yellow.png",1,1);
		flagGraphics.setParent(body2);
	}
	
	public void setFinishGraphics(String graphics) {
		finishGraphics = new ImageGraphics(graphics,1,1);
		finishGraphics.setParent(body);
	}
	
	


	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Canvas canvas) {
		finishGraphics.draw(canvas);
		flagGraphics.draw(canvas);
		
	}
	
	public void update(float deltaTime) {
		int numberOfCollisions = contactListener. getEntities ().size() ;
		if (numberOfCollisions > 0){
		setFinishGraphics("flag.green.png") ;
		}

	}
}



