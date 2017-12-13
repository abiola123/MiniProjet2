package ch.epfl.cs107.play.game.actor.general;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Constraint;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.WheelConstraint;
import ch.epfl.cs107.play.math.WheelConstraintBuilder;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;

public class Wheel extends GameEntity implements Actor {
	private Entity body = getEntity();
	private ShapeGraphics wheelGraphics;
	private PartBuilder partBuilder;
	private ActorGame game;
	private WheelConstraint constraint;
	private Entity vehicle;
	private boolean collide = false;
	private ShapeGraphics wheelGraphicsRad;
	private boolean enabled;
	
	public Wheel(ActorGame game, boolean fixed, Vector position, float radius) {
		super(game, fixed, position);
		this.game = game;
		
		if(radius <= 0) {
			throw new IllegalArgumentException("Parametre invalide");
		}
		
		partBuilder = body.createPartBuilder();
		Circle circle = new Circle (radius);
		partBuilder.setShape(circle);
		partBuilder.setFriction(1);
		partBuilder.build();
		wheelGraphics = new ShapeGraphics(circle,Color.GRAY,Color.WHITE,.1f,1.f,0);
		wheelGraphics.setParent(body);
		Polyline rad = new Polyline(new Vector(0.0f,0.0f), new Vector(0.0f,0.5f));
		wheelGraphicsRad = new ShapeGraphics(rad,Color.WHITE,Color.WHITE,.1f,1.f,0);
		wheelGraphicsRad.setParent(body);

		}
	
	public void attach(Entity vehicle , Vector anchor , Vector axis , boolean collide) {
		
		WheelConstraintBuilder constraintBuilder = game.CreateWheelConstraintBuilder(); 
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
		constraintBuilder.setMotorMaxTorque (1000.0f) ;
		//do you want the objects to be able to colide between themeselves ?
		constraintBuilder.setInternalCollision(collide);
		constraint = constraintBuilder.build () ;
	}
		
		public void power(float speed) {
		if (speed == 0 ) {
			enabled = false;
		}
		enabled = true;
		constraint.setMotorEnabled(enabled);
		constraint.setMotorSpeed(speed);
		
		}
	

		//TODO Getting the motor speed
		public float getSpeed() {
			// the following is false
			return constraint.getMotorSpeed();
		}

		public void relax() {
			constraint.setMotorEnabled(false);
		}

		public void detach() {
			constraint.destroy();
		}

		@Override
		public Transform getTransform() {
			// TODO Auto-generated method stub
			return getTransform();
		}

		public void draw(Canvas canvas) {
		wheelGraphics.draw(canvas);
		wheelGraphicsRad.draw(canvas);
		
	}

}
