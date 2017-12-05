package ch.epfl.cs107.play.game.actor.bike;


import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.general.Wheel;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Bike extends GameEntity implements Actor {

	
	private Wheel leftWheel;
	private Wheel rightWheel;
	private Entity body = getEntity();
//	private Vector leftWheelPositon = (new Vector(getBikePosition() + (-1.0f, 0.f)));
//	private Vector rightWheelPosition = (new Vector(getBikePosition()+ (1.0f , 0.f)));

	public Bike(ActorGame game, boolean fixed , Vector position) {
		super(game, fixed,position);
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
		
	
		
		

	/TODO find a way to add vectors, could separate values etc... but its long
	Vector leftWheelPos = position.add(-1.0f, 0.f);
	Vector rightWheelPos = position.add(1.0f,0.f);

	// Building the wheels and attaching them to the bike
	leftWheel = new Wheel(game, false,"explosive.11.png",leftWheelPos, 0.5f);
	rightWheel = new Wheel(game, false,"explosive.11.png",rightWheelPos,0.5f);

	leftWheel.attach(body, new Vector (-1.0f, 0.0f), new Vector(-0.5f,-1.0f));
	rightWheel.attach(body, new Vector (1.0f, 0.0f), new Vector(0.5f,-1.0f));

//----------------------------------------------------------------------

	// Graphical representation of the bike and the rider

	// Draw head
	Circle head = new Circle(0.2f, getHeadLocation());
	// Draw arm
	Polyline arm =  new Polyline(getShoulderLocation(), getHandLocation());
	// Draw back
	Polyline back = new Polyline(getShoulderLocation(), getBodyCentreLocation());
	// Draw top legs
	Polyline leftTLeg = new Polyline(getBodyCentreLocation(), getLeftKneeLocation());
	Polyline rightTLeg = new Polyline(getBodyCentreLocation(), getRightKneeLocation());
	// Draw bottom legs
	Polyline leftBLeg = new Polyline(getLeftKneeLocation(), getLeftFootLocation());
	Polyline rightBLeg = new Polyline(getRightKneeLocation(), getRightFootLocation());
	
}

//----------------------------------------------------------------------

// All main body parts locations, in local coordinates
private Vector getLeftKneeLocation() {
	return new Vector(0.1f,0.6f);
}

private Vector getRightKneeLocation() {
	return new Vector(0.05f,0.55f);
}

private Vector getLeftFootLocation() {
	return new Vector(0.25f,-0.5f);
}

private Vector getRightFootLocation() {
	return new Vector(-0.2f,-0.52f);
}

// Body centre location, in local coordinates
private Vector getBodyCentreLocation() {
	return new Vector(-0.5f,1.0f);
}

// Shoulder location, in local coordinates
private Vector getShoulderLocation() {
	return new Vector(-0.1f, 1.6f);
}

// Hand location, in local coordinates
private Vector getHandLocation() {
	return new Vector(0.5f, 1.0f);
}

// Head location, in local coordinates
private Vector getHeadLocation() {
	return new Vector(0.0f, 1.75f);
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
