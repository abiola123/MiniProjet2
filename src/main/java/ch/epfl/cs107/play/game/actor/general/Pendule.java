package ch.epfl.cs107.play.game.actor.general;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;
import jdk.nashorn.internal.ir.Block;

public class Pendule  extends GameEntity implements Actor  {
	private Crate crate;
	private Ball ball;
	private Entity bodyBlock;
	private Vector position;
	private Entity corde = getEntity();
	private ShapeGraphics cordeGraphics;

	public Pendule(ActorGame game, boolean fixed, Vector position, float radius, Color innerColor, Color outerColor, float penduleLength ) {
		super(game,fixed,position);
		this.position = position;

		Vector ballPos = position.add(-50000f,-100000.f);

		crate = new Crate(game,fixed,position,2f,2f,"metal.broken.hollow.1.png");
		
		bodyBlock = crate.returnEntity();
		ball = new Ball(game,false,position,radius,innerColor,outerColor);
		ball.attach(bodyBlock, 1f, 1f , penduleLength);
		this.corde = corde;

//		PartBuilder partBuilder1 = corde.createPartBuilder();
//		Polyline polyline = new Polyline(
//
//				crate.getPosition(),
//				ball.getPosition()
//				);
//		cordeGraphics = new ShapeGraphics(polyline,Color.WHITE,Color.WHITE,.1f,1.f,0);
//		cordeGraphics.setParent(corde);
	}

	public Pendule(ActorGame game, boolean fixed, Vector position, float radius, String graphics, float penduleLength ) {
		super(game,fixed,position);
		this.position = position;

//		Vector ballPos = position.add(-50000f,-100000.f);

		crate = new Crate(game,fixed,position,2f,2f,"metal.broken.hollow.1.png");
		bodyBlock = crate.returnEntity();
		ball = new Ball(game,false,position,radius,graphics);
		ball.attach(bodyBlock, 1f, 1f , penduleLength);
////		if(crate.getPosition()!= (ball.getPosition() )) {
//			PartBuilder partBuilder1 = corde.createPartBuilder();
//			Polyline polyline = new Polyline(

				System.out.println(	crate.getPosition());
				System.out.println( 	ball.getPosition());
				System.out.println(	ball.getPosition().add(new Vector(0.00001f,0f)));
//					);
//			cordeGraphics = new ShapeGraphics(polyline,Color.WHITE,Color.WHITE,.1f,1.f,0);
//			cordeGraphics.setParent(corde);
//		}else {
//			System.out.println("fuck you");
//			System.out.println(ball.getPosition());
//			System.out.println(crate.getPosition().add(0f,-penduleLength));
//		}
	}
	@Override
	public Transform getTransform() {
		return ball.getTransform();
	}

	@Override
	public void draw(Canvas canvas) {
		ball.draw(canvas);
		crate.draw(canvas);		
//		cordeGraphics.draw(canvas);
	}
}
