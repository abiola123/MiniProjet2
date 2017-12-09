package ch.epfl.cs107.play.game.actor.bike;


import java.awt.Color;

import com.sun.glass.events.KeyEvent;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.game.actor.general.Wheel;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Contact;
import ch.epfl.cs107.play.math.ContactListener;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Shape;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Bike extends GameEntity implements Actor {



	private Entity body = getEntity();
	private Polyline arm, back, rightTLeg, leftTLeg, leftBLeg, rightBLeg;
	private ShapeGraphics headGraphics;
	private ShapeGraphics shapeGraphics;
	private Wheel leftWheel;
	private Wheel rightWheel;
	// plus propre, recevoir dans constructeur la direction
	private Boolean directionR = true;
	private Float MAX_WHEEL_SPEED = 15.0f;
	private Vector position;
	private Vector getRightFootLocation;
	private Vector getLeftFootLocation;
	private Vector getRightKneeLocation;
	private Vector getLeftKneeLocation;

//	private ContactListener listener;
	private boolean gotHit;
	


	ContactListener listener = new ContactListener () {
		@Override
		public void beginContact(Contact contact) {
			if (contact.getOther().isGhost ()) {
				return;
			} else if (contactBikeWithPolyline(contact,leftWheel,rightWheel)) {
				gotHit = false;
				return;
			} else {
				gotHit = true ;
				return;
			}
		}
		
	

	@Override
	public void endContact(Contact contact) {}

	};

		



	public Bike(ActorGame game, boolean fixed , Vector position, Float radius) {
		super(game, fixed,position);
		this.position = position;
		PartBuilder partBuilder = body.createPartBuilder();
		Polygon polygon = new Polygon (
				new Vector	(0.0f, 0.5f),
				new Vector 	(0.5f, 1.0f),
				new Vector	(0.0f, 2.0f),
				new Vector	(-0.5f, 1.0f)
				);





		body.addContactListener(listener);

		partBuilder.setShape(polygon);
		partBuilder.build();
		partBuilder.setGhost(true);

		Vector leftWheelPos = position.add(-1.0f, 0.f);
		Vector rightWheelPos = position.add(1.0f,0.f);

		// Building the wheels and attaching them to the bike
		leftWheel = new Wheel(this.getOwner(), false,leftWheelPos, radius);
		rightWheel = new Wheel(this.getOwner(), false,rightWheelPos, radius);
		//added boolean for internal collision between parts that have been linked by constraint
		//																		\./
		leftWheel.attach(body, new Vector (-1.0f, 0.0f), new Vector(-0.5f,-1.0f), false);
		rightWheel.attach(body, new Vector (1.0f, 0.0f), new Vector(0.5f,-1.0f) , false);


		Circle head = new Circle(0.2f, getHeadLocation());

		headGraphics = new ShapeGraphics(head,Color.WHITE,Color.WHITE,.1f,1.f,0);
		headGraphics.setParent(body);

	}


	// All main body parts locations, in local coordinates
	private Vector getLeftKneeLocation() {
		return new Vector(0.1f,0.6f);
	}

	private Vector getRightKneeLocation() {
		return new Vector(0.05f,0.55f);
	}

	private Vector getLeftFootLocation() {
		return new Vector(-0.2f,-0.1f);
		
	}

	private Vector getRightFootLocation() {
		return new Vector(0.25f,-0.12f);
	}

	// Body centre location, in local coordinates
	private Vector getBodyCentreLocation() {
		return new Vector(-0.45f,0.9f);
	}

	// Shoulder location, in local coordinates
	private Vector getShoulderLocation() {
		return new Vector(-0.1f, 1.45f);
	}

	// Hand location, in local coordinates
	private Vector getHandLocation() {
		return new Vector(0.5f, 1.0f);
	}

	// Head location, in local coordinates
	private Vector getHeadLocation() {
		return new Vector(0.0f, 1.75f);
	}


	@Override
	public void draw(Canvas canvas) {
		headGraphics.draw(canvas);
		rightWheel.draw(canvas);
		leftWheel.draw(canvas);

		if(directionR) {
			drawChar(arm, getShoulderLocation(), getHandLocation(), canvas);
			drawChar(back, getShoulderLocation(), getBodyCentreLocation(), canvas);
			drawChar(leftTLeg, getBodyCentreLocation(), getLeftKneeLocation(), canvas);
			drawChar(rightTLeg, getBodyCentreLocation(), getRightKneeLocation(), canvas);
			drawChar(leftBLeg, getLeftKneeLocation(), getLeftFootLocation(), canvas);
			drawChar(rightBLeg, getRightKneeLocation(), getRightFootLocation(), canvas);
	
		} else if (!directionR) {
			drawChar(arm, getShoulderLocation().mul(-1, 1), getHandLocation().mul(-1,1), canvas);
			drawChar(back, getShoulderLocation().mul(-1, 1), getBodyCentreLocation().mul(-1, 1), canvas);
			drawChar(leftTLeg, getBodyCentreLocation().mul(-1, 1), getLeftKneeLocation().mul(-1, 1),canvas);
			drawChar(rightTLeg, getBodyCentreLocation().mul(-1, 1), getRightKneeLocation().mul(-1, 1), canvas);
			drawChar(leftBLeg,getLeftKneeLocation().mul(-1, 1), getLeftFootLocation().mul(-1, 1), canvas);
			drawChar(rightBLeg, getRightKneeLocation().mul(-1, 1), getRightFootLocation().mul(-1, 1), canvas);
		}
		
	
	
	
	
	}
	
	

	public void drawChar(Shape shape, Vector location1, Vector location2, Canvas canvas) {
		shape = new Polyline(location1, location2);
		shapeGraphics = new ShapeGraphics(shape, null, Color.WHITE,.1f,1.f,0);
		shapeGraphics.setParent(body);
		shapeGraphics.draw(canvas);
	}

	@Override
	public Vector getVelocity() {
		// TODO Auto-generated method stub
		return body.getVelocity();

	}

	@Override
	public Transform getTransform() {
		return body.getTransform();
	}
	
	
	
	public void destroy() {
		this.destroy();
		leftWheel.destroy();
		rightWheel.destroy();
		
		
		
		
		
	}
	
	
	
	public void update(float deltaTime) {
		//ContactListener

		if(gotHit) {
			this.destroy();
			
		}
		


		if (getOwner().getKeyboard().get(KeyEvent.VK_SPACE).isPressed ()) {
			directionR = !directionR;
		}


		//TODO switch visual orientation;

		// 2. Deactivates by default the movement of the wheels
		leftWheel.relax();
		rightWheel.relax();


		// 3. Blocks the wheels if the downKey is pressed
		if (getOwner().getKeyboard ().get(KeyEvent.VK_DOWN).isDown ()) {
			leftWheel.power(0);
			rightWheel.power(0);
		}

		// 4. Makes the bike move forward if the upKey is pressed
		if (getOwner().getKeyboard ().get(KeyEvent.VK_UP).isDown ()) {

			//TODO getSpeed() -> 5.2.3 faire bien mais faut vitesse du velo
			if (directionR) {
				leftWheel.power(-MAX_WHEEL_SPEED);
			}

			if (!directionR) {
				rightWheel.power(MAX_WHEEL_SPEED);
			}

		}

		// 5. Apply angular forces with right and left Arrows
		if (getOwner().getKeyboard ().get(KeyEvent.VK_RIGHT).isDown ()) {
			body.applyAngularForce(-15.0f);
		}

		if (getOwner().getKeyboard ().get(KeyEvent.VK_LEFT).isDown ()) {
			body.applyAngularForce(15.0f);
		}





	}


}















