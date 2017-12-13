package ch.epfl.cs107.play.game.actor;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.bike.Bike;
import ch.epfl.cs107.play.game.actor.general.Arrow;
import ch.epfl.cs107.play.game.actor.general.CrateField;
import ch.epfl.cs107.play.game.actor.TextGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.general.Finish;
import ch.epfl.cs107.play.game.actor.general.GravityWell;
import ch.epfl.cs107.play.game.actor.general.Pendule;
import ch.epfl.cs107.play.game.actor.general.Plank;
import ch.epfl.cs107.play.game.actor.general.Seasaw;
import ch.epfl.cs107.play.game.actor.general.Terrain;
import ch.epfl.cs107.play.game.actor.general.Terrain2;
import ch.epfl.cs107.play.game.actor.general.Trigger;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.Contact;
import ch.epfl.cs107.play.math.ContactListener;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Window;

public class BikeGame2 extends ActorGame {
	private FileSystem fileSystem;
	private Window window;
	private ActorGame game;
	private Terrain2 terrain2;
	private GravityWell gravityWell;
	private GravityWell gravityWell2;
	private Bike bike;
	private Finish finishLine;
	private Finish finishLine2;
	private Trigger checkPoint;
	private Seasaw seasaw;
	private Seasaw seasaw2;
	private Arrow arrow;
	private Arrow arrow2;
	private Arrow arrow3;
	private TextGraphics message;
	private TextGraphics message2;
	private BasicContactListener contactListener;
	private BasicContactListener contactListenerWell;
	private BasicContactListener contactListenerWell2;
	private float timeSinceStart = 0;
	private float timeSinceEnd = 0;

	//vecteur finish line a changer 
	private Vector startingPosition = new Vector(4.0f,7.0f);
	private Vector finishLinePosition = new Vector(10.0f, 0f);
	private Vector terrainPosition = new Vector(0.0f,0.0f);
	private Vector v1 = (new Vector(0.0f, 5.0f));
	private Vector v2 = (new Vector(0.2f, 7.0f));
	private Vector v3 = (new Vector(2.0f, 6.0f));
	private Vector checkPointPosition = new Vector(65f,-70f) ;

	private Vector bikePosition =  (new Vector(40.0f,5.0f));

	private boolean hasHit = false;

	public boolean begin(Window window, FileSystem fileSystem) {
		super.begin(window, fileSystem);
		this.window = window;
		this.fileSystem = fileSystem;

		setPosition(startingPosition);
		terrain2 = new Terrain2(this,true,terrainPosition);
		bike = new Bike(this , false , bikePosition, 0.5f);
		gravityWell = new GravityWell(this,true,new Vector(45,-20), 17, 30,Color.BLUE,Color.WHITE);
		gravityWell2 = new GravityWell(this,true,new Vector(-50,-80), 40, 55,Color.BLUE,Color.WHITE );
		seasaw = new Seasaw(this,true,new Vector(-28f,-88f),1,1,14,.3f,Color.WHITE, Color.CYAN);
		seasaw2 = new Seasaw(this,true,new Vector(-20f,-92f),1,1,14,.3f,Color.WHITE, Color.CYAN);
		finishLine = new Finish(this, true, new Vector(-4f,-88f),"flag.red.png",1,1);
		checkPoint = new Trigger(this,true,checkPointPosition,"flag.red.png",1f,1f);
		arrow = new Arrow(this, true, new Vector(47,-17), "arrow.white.png", 1f,1f);
		arrow2 = new Arrow(this, true, new Vector(52,-10), "arrow.white.png", 1f,1f);
		arrow3 = new Arrow(this, true, new Vector(57,-3), "arrow.white.png", 1f,1f);


		message = new TextGraphics("", .4f, Color.WHITE, Color.GRAY, 0.02f, true,
				false, new Vector(0.5f,-1.5f), 1.0f, 2.0f);
		message2 = new TextGraphics("", .4f, Color.WHITE, Color.GRAY, 0.02f, true,
				false, new Vector(0.5f,-1.5f), 1.0f, 2.0f);

		message.setText("START!");
		message.setParent(getCanvas());
		message.draw(getCanvas());
		message2.setText("");
		message2.setParent(getCanvas());
		message2.draw(getCanvas());

		contactListener = new BasicContactListener();
		finishLine.addContactListener(contactListener);

		contactListenerWell = new BasicContactListener();
		gravityWell.addContactListener(contactListenerWell);

		contactListenerWell2 = new BasicContactListener();
		gravityWell2.addContactListener(contactListenerWell2);


		actorListAddActor((Actor)terrain2);
		actorListAddActor((Actor)gravityWell);
		actorListAddActor((Actor)gravityWell2);
		actorListAddActor((Actor)bike);
		actorListAddActor((Actor)seasaw);
		actorListAddActor((Actor)seasaw2);
		actorListAddActor((Actor)finishLine);
		actorListAddActor((Actor)checkPoint);
		actorListAddActor((Actor)arrow);
		actorListAddActor((Actor)arrow2);
		actorListAddActor((Actor)arrow3);

		this.setViewCandidate(bike);

		return true;
	}


	public void update(float deltaTime) {

		setViewCandidate(bike);
		super.update(deltaTime);

		setHit();

		// delayer
		timeSinceStart += deltaTime;
		if(timeSinceStart < 1f) {
			message.setText("START");
			message.setParent(getCanvas());
			message.draw(getCanvas());
		} else {
			message.setText("");
			message.draw(getCanvas());
		}

		if (bike.wasHit()) {
			endingMessage("YOU LOSE", "PRESS R TO TRY AGAIN");
			if(timeSinceEnd < 5f) {
				timeSinceEnd += deltaTime;
			} else {
				endingMessage("","");
				end();
			}
		}

		if (hasHit) {
			bike.setHandLocation();
			finishLine.setFinishGraphics("flag.green.png");
			endingMessage("YOU WIN", "THANK YOU FOR PLAYING");
			if(timeSinceEnd < 3f) {
				timeSinceEnd += deltaTime;
			} else {
				end();
			}
		}

		if(contactListenerWell.hasContactWith(bike.getEntity())) {
			setWellGravity(new Vector(0,4f));
		} else if (contactListenerWell2.hasContactWith(bike.getEntity())) {
			setWellGravity(new Vector(-4f,0f));
		} else {
			setWellGravity(new Vector(0,-9.81f));
		}

		if(checkPoint.gotHit()) {
			checkPoint.setGotHit(true);
			checkPoint.setTriggerGraphics("flag.green.png");
			startingPosition = checkPointPosition;
		}

	}

	public boolean contactBikeFinish() {
		return contactListener.hasContactWith(bike.getEntity());
	}

	public void setHit() {
		if (contactBikeFinish()) {
			hasHit = true;
		}
	}

	public void endingMessage(String text1, String text2) {
		message.setText(text1);
		message2.setText(text2);
		message.setFontSize(.18f);
		message2.setFontSize(.12f);
		message.setAnchor(new Vector(0.5f,-3.5f));
		message2.setAnchor(new Vector(0.5f, -7f));
		message.setParent(getCanvas());
		message2.setParent(getCanvas());
		message.draw(window);
		message2.draw(window);	
	}

	public void setPosition(Vector vector) {
		bikePosition = vector;
	}

	public Vector getPosition() {
		return bikePosition;
	}
}