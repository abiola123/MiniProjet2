package ch.epfl.cs107.play.game.actor;

import java.awt.Color;

import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Pendule  extends GameEntity implements Actor  {
	private Crate crate;
	private Ball ball;
	private Entity bodyBlock;
	private Vector position;
	private Entity corde = getEntity();
	
	public Pendule(ActorGame game, boolean fixed, Vector position, float radius, Color innerColor, Color outerColor, float penduleLength ) {
		super(game,fixed,position);
		this.position = position;
		
		Vector ballPos = position.add(-50000f,-100000.f);
		
		crate = new Crate(game,fixed,position,2f,2f,"metal.broken.hollow.1.png");
		bodyBlock = crate.getEntity();
		ball = new Ball(game,false,position,radius,innerColor,outerColor);
		ball.attach(bodyBlock, 1f, 1f , penduleLength);
		this.corde = corde;
		
	}
	
	public Pendule(ActorGame game, boolean fixed, Vector position, float radius, String graphics, float penduleLength ) {
		super(game,fixed,position);
		this.position = position;
		
		Vector ballPos = position.add(-50000f,-100000.f);
		
		crate = new Crate(game,fixed,position,2f,2f,"metal.broken.hollow.1.png");
		bodyBlock = crate.getEntity();
		ball = new Ball(game,false,position,radius,graphics);
		ball.attach(bodyBlock, 1f, 1f , penduleLength);
		
		
		//cord between pendule and object
		PartBuilder partBuilder = corde.createPartBuilder();
//		Polyline polyline = new Polyline(
//				ball.getPosition() ,
//				ball.getTransform() ,
//				0,0
//				);
//		ball.getPosition() getTransform.
	}
	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return ball.getTransform();
	}

	@Override
	public void draw(Canvas canvas) {
	ball.draw(canvas);
	crate.draw(canvas);		
	}
}
