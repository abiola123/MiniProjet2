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
	private boolean attached;
	private Constraint constraint;
	//is this world empty ?
	private World world;
	private float diameter;
	public Wheel(ActorGame game, boolean fixed, Vector position, float diameter) {
		super(game, fixed, position);
		this.diameter = diameter;
		partBuilder = body.createPartBuilder();
		Circle circle = new Circle (diameter);
		partBuilder.setShape(circle);
		partBuilder.build();
		
		wheelGraphics = new ShapeGraphics(circle,Color.WHITE,Color.WHITE,.1f,1.f,0);
		
		}
		
		
		public void attach(Entity vehicle,Vector anchor,Vector axis) {
	
			
			
			
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
			constraint = constraintBuilder.build () ;
		}
	//????????????
		public void power(float speed) {
		
		
		 wheel.power(speed);
		}
	//??????????????????	
		public void relax() {
			wheel.relax();;
		}
	//???????????????????
		public void detach() {
			wheel.detach();
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
