package ch.epfl.cs107.play.game.actor.bike;

//package ch.epfl.cs107.play.game.actor.bike;

import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.general.Wheel;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.Part;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Bike extends GameEntity implements Actor {

	
	//aurai-je encore un null pointer exception a cause de ca ?
	private Game game;
	private Wheel leftWheel;
	private Wheel rightWheel;
	private Entity body = getEntity();
//	private Vector leftWheelPositon = (new Vector(getBikePosition() + (-1.0f, 0.f)));
//	private Vector rightWheelPosition = (new Vector(getBikePosition()+ (1.0f , 0.f)));

	public Bike(ActorGame game, boolean fixed , Vector position) {
		super(game, fixed,position);
		this.game = game;
		
		PartBuilder partBuilder = body.createPartBuilder();
		Polygon polygon = new Polygon (
			new Vector	(0.0f, 0.5f),
			new Vector 	(0.5f, 1.0f),
			new Vector	(0.0f, 2.0f),
			new Vector	(-0.5f, 1.0f)
			);
		
		partBuilder.setShape(polygon);
		partBuilder.build();
		partBuilder.setGhost(true);
		
		
		
		
		

	
		
	}

	
	
	
	
	public void attach() {
		leftWheel.attach(body , new Vector (-1.0f, 0.0f), new
				Vector (-0.5f, -1.0f)) ;
		rightWheel.attach(body , new Vector (1.0f, 0.0f), new
				Vector (0.5f, -1.0f)) ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Vector getVelocity() {
		// TODO Auto-generated method stub
		return getVelocity();
	}


			

}
