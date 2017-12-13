package ch.epfl.cs107.play.game.actor.general;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.RevoluteConstraint;
import ch.epfl.cs107.play.math.RopeConstraint;
import ch.epfl.cs107.play.math.RopeConstraintBuilder;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Ball extends GameEntity implements Actor{
	private float radius;
	private ActorGame game;
	private ShapeGraphics ballGraphics;
	private ImageGraphics ballGraphics1;
	private Entity ball = getEntity();
	private RopeConstraint constraint;
	private Color innerColor;
	private Color outerColor;
	private boolean shapeGraphics = false;
	private boolean imageGraphics = false ;
	private Vector position;

	
	//--------------------------------------------------------------	
	
	
	//creates an entity that is attached to the "pendule"
	public Ball(ActorGame game,boolean fixed, Vector position, float radius, Color innerColor, Color outerColor) {
		super(game,fixed,position);
		this.game = game;
		//		this.outerColor = outerColor;
		//		this.innerColor = innerColor;
		//		this.radius = radius;
		this.position = position;
		this.ball = ball;
		PartBuilder partBuilder = ball.createPartBuilder();
		Circle circle = new Circle(radius);
		partBuilder.setShape(circle);
		partBuilder.build();

		ballGraphics = new ShapeGraphics(circle,innerColor,outerColor,.1f,1f,0 );
		ballGraphics.setParent(ball);


		//boolean used to draw the correct graphics
		shapeGraphics = true;



	}

	
	//--------------------------------------------------------------	
	
	
	
	public Ball(ActorGame game,boolean fixed, Vector position, float radius, String graphics) {
		super(game,fixed,position);
		this.game = game;
		this.radius = radius;
		this.position = position;
		PartBuilder partBuilder = ball.createPartBuilder();
		Circle circle = new Circle(radius);
		partBuilder.setShape(circle);
		partBuilder.build();

		ballGraphics1 = new ImageGraphics(graphics,radius*2,radius*2 );
		ballGraphics1.setParent(ball);

		//boolean used to draw the correct graphics
		imageGraphics = true;
	}

	//creates a constraint between ball and crate
	public void attach(Entity bodyBlock , float blockWidth, float blockHeight, float maxConstraintLength) {
		RopeConstraintBuilder ropeConstraintBuilder  =	game.CreateRopeConstraintBuilder();
		ropeConstraintBuilder.setFirstEntity(bodyBlock) ;
		ropeConstraintBuilder.setFirstAnchor(new Vector(blockWidth /2,
				(blockHeight *7) /4)) ;
		ropeConstraintBuilder.setSecondEntity(ball) ;
		ropeConstraintBuilder.setSecondAnchor(Vector.ZERO) ;
		ropeConstraintBuilder.setMaxLength (maxConstraintLength) ;
		ropeConstraintBuilder.setInternalCollision(true) ;
		ropeConstraintBuilder.build () ;
		constraint = ropeConstraintBuilder.build();

	}
	
	//--------------------------------------------------------------	
	@Override
	public Transform getTransform() {
		return getTransform();
	}

	@Override
	public Vector getPosition() {
		return position;
	}

	@Override
	public void draw(Canvas canvas) {
		if(shapeGraphics)
			ballGraphics.draw(canvas);
		if(imageGraphics)
			ballGraphics1.draw(canvas);

	}
	
	public Entity returnEntity() {
		return ball;
	}
}
