package ch.epfl.cs107.play.game.actor;

import java.awt.Color;

import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Pendule  extends GameEntity implements Actor  {
	private Crate crate;
	private Ball ball;
	private Entity bodyBlock;
	private Vector position;
	
	
	public Pendule(ActorGame game, boolean fixed, Vector position, float radius, Color innerColor, Color outerColor ) {
		super(game,fixed,position);
		this.position = position;
		
		Vector ballPos = position.add(-20f,-10.f);
		
		crate = new Crate(game,fixed,position,1f,1,"wood.2.png");
		bodyBlock = crate.getEntity();
		ball = new Ball(game,false,position,radius,innerColor,outerColor);
		ball.attach(bodyBlock, 1f, 1f , 3.0f);
		
		
	}

	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Canvas canvas) {
	ball.draw(canvas);
	crate.draw(canvas);		
	}
}
