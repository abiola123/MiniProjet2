package ch.epfl.cs107.play.game.actor.general;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Constraint;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.WheelConstraintBuilder;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;

public class Wheel extends GameEntity implements Actor {
	private Entity body = getEntity();
	//??
	private Wheel wheel;
	private ShapeGraphics wheelGraphics;
	private PartBuilder partBuilder;
	
	public Wheel(ActorGame game, boolean fixed, Vector position, float radius) {
		super(game, fixed, position);
		
		partBuilder = body.createPartBuilder();
		Circle circle = new Circle (radius);
		partBuilder.setShape(circle);
		partBuilder.build();
		
		wheelGraphics = new ShapeGraphics(circle,Color.WHITE,Color.WHITE,.1f,1.f,0);
		wheelGraphics.setParent(body);
		
		}
		
	//????????????
		public void power(float speed) {
		
		
		 wheel.power(speed);
		}
	//??????????????????	
		public void relax() {
	
		}
	//???????????????????
		public void detach() {
			constraint.destroy();
		}
		
	
	

	//les returns sont correctes ?
	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return getTransform();
	}

	@Override
	public void draw(Canvas canvas) {
		wheelGraphics.draw(canvas);
		
	}

}
