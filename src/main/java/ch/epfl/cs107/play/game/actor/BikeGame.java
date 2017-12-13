package ch.epfl.cs107.play.game.actor;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.bike.Bike;
import ch.epfl.cs107.play.game.actor.general.CrateField;
import ch.epfl.cs107.play.game.actor.general.Finish;
import ch.epfl.cs107.play.game.actor.general.GravityWell;
import ch.epfl.cs107.play.game.actor.general.Pendule;
import ch.epfl.cs107.play.game.actor.general.Plank;
import ch.epfl.cs107.play.game.actor.general.Seasaw;
import ch.epfl.cs107.play.game.actor.general.Terrain;
import ch.epfl.cs107.play.game.actor.general.Trigger;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.Contact;
import ch.epfl.cs107.play.math.ContactListener;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Window;
import java.util.ArrayList;

public class BikeGame extends ActorGame{
	private FileSystem fileSystem;
	private Window window;
	private ActorGame game;
	private Crate firstCrate;
	private Crate secondCrate;
	private Crate thirdCrate;
	private Terrain terrain;
	private Bike bike;
	private Finish finishLine;
	private Finish finishLine2;
	private Seasaw seasaw;
	private Plank plankSeasaw;
	private Pendule pendule;
	private Pendule pendule2;
	private boolean contactBikeFinish;
	private CrateField crateField;
	private TextGraphics message;
	private TextGraphics message_up;
	private TextGraphics message_down;
	private BasicContactListener contactListener;
	private BasicContactListener contactListenerWell;
	private Trigger key1;
	private Trigger key2;
	private Trigger key3;
	private Trigger key4;
	private Trigger key5;
	private Trigger key6;
	private Trigger key7;
	private Trigger key8;
	private Trigger key9;
	private Trigger key10;
	private Trigger checkPoint1;
	private Trigger checkPoint2;
	private GravityWell gravityWell;
//	private int collectedKeys = 0;
	private TextGraphics keysCounter;
	private float timeSinceStart = 0;
	private float timeSinceEnd = 0;
	private ArrayList<Integer> collectedKeys = new ArrayList<Integer>();


	//vecteur finish line a changer 
	private Vector startingPosition = (new Vector(5f,1.0f));
	private Vector finishLinePosition = new Vector(345.0f, -11f);
	private Vector terrainPosition = new Vector(0.0f,0.0f);
	private Vector v1 = (new Vector(0.0f, 5.0f));
	private Vector v2 = (new Vector(0.2f, 7.0f));
	private Vector v3 = (new Vector(2.0f, 6.0f));
	private Vector bikePosition =  (new Vector(40.0f,5.0f));
	private Vector seasawPosition = (new Vector(40.0f, -5.80f));
	private Vector pendulePosition = (new Vector(49.0f    ,30.0f));
	private Vector pendule2Position = (new Vector(285f   , 5f ));
	private Vector crateFieldPosition = (new Vector(240f,-5f));
	private Vector checkPointPosition = (new Vector(219f, 0f));
	private Vector checkPoint2Position = (new Vector(270,0f));
	private Vector key1Position =  (new Vector(49.0f, 13.0f));
	private Vector key2Position =  (new Vector(92.0f, -10.0f));
	private Vector key3Position =  (new Vector(200.0f, 0f));
	private Vector key4Position =  (new Vector(238f, 6.0f));
	private Vector key5Position =  (new Vector(250.0f, 0.0f));
	private Vector key6Position =  (new Vector(307.0f, -19.5f));
	private Vector key7Position =  (new Vector(345.0f, -11f));
	private Vector key8Position =  (new Vector(9.0f, 0.0f));
	private Vector key9Position =  (new Vector(8.0f, 0.0f));
	private Vector key10Position=  (new Vector(7.0f, 0.0f));
	private Vector keysCounterPosition = (new Vector(-8.5f, -23.5f));
	private Vector gravityWellPosition = (new Vector(345f,-60f));
	private boolean hasHit = false;


	public boolean begin(Window window, FileSystem fileSystem) {
		super.begin(window, fileSystem);
		this.window = window;
		this.fileSystem = fileSystem;

		//keys counter
		keysCounter = new TextGraphics("",0.05f,Color.YELLOW,Color.GRAY,0.01f,false,false,keysCounterPosition,0.8f,2.0f);

		setBikePosition(startingPosition);
		terrain = new Terrain(null,true,terrainPosition);
		key1 = new Trigger(this,true,key1Position,"key.yellow.png", 1, 1);
		key2 = new Trigger(this,true,key2Position,"key.yellow.png", 1, 1);
		key3 = new Trigger(this,true,key3Position,"key.yellow.png", 1, 1);
		key4 = new Trigger(this,true,key4Position,"key.yellow.png", 1, 1);
		key5 = new Trigger(this,true,key5Position,"key.yellow.png", 1, 1);
		key6 = new Trigger(this,true,key6Position,"key.yellow.png", 1, 1);
		key7 = new Trigger(this,true,key7Position,"key.yellow.png", 1, 1);
		key8 = new Trigger(this,true,key8Position,"key.yellow.png", 1, 1);
		key9 = new Trigger(this,true,key9Position,"key.yellow.png", 1, 1);
		key10 = new Trigger(this,true,key10Position,"key.yellow.png", 1, 1);
		firstCrate = new Crate(this,false,v1,1.0f,1.0f,"crate.3.png");
		secondCrate = new Crate(this,false,v2,1.0f,1.0f,"crate.3.png");
		thirdCrate = new Crate(this,false,v3,1.0f,1.0f,"crate.3.png");
		bike = new Bike(this , false , bikePosition, 0.5f);
		finishLine = new Finish(this,true,finishLinePosition,"door.closed.png",3f,3f);
		finishLine2 = new Finish(this,true, new Vector(4f,0f),"flag.green.png",1f,1f);
		pendule = new Pendule(this,true,pendulePosition,1f,"saw.png.png",10.5f);
		pendule2 = new Pendule(this,true,pendule2Position,2.5f,Color.WHITE,Color.WHITE,14.5f);
		crateField = new CrateField(this,true,crateFieldPosition);
		seasaw = new Seasaw(this,true,seasawPosition,10.0f,1.0f,5.0f,0.1f,Color.WHITE, Color.WHITE);
		gravityWell = new GravityWell(this,true,gravityWellPosition,40f,120f,Color.WHITE,Color.CYAN);
		checkPoint1 = new Trigger(this,true,checkPointPosition,"flag.red.png",1f,1f);
		//		checkPoint2 = new Trigger
		contactListener = new BasicContactListener();
		finishLine.addContactListener(contactListener);

		message_up = new TextGraphics("", .4f, Color.WHITE, Color.GRAY, 0.02f, true,
				false, new Vector(0.5f,-1.5f), 1.0f, 2.0f);
		message_down = new TextGraphics("", .4f, Color.WHITE, Color.GRAY, 0.02f, true,
				false, new Vector(0.5f,-1.5f), 1.0f, 2.0f);

		message_up.setText("START!");
		message_up.setParent(getCanvas());
		message_up.draw(getCanvas());
		message_down.setText("");
		message_down.setParent(getCanvas());
		message_down.draw(getCanvas());

		//--------------CONTACT LISTENERS------------------------------

		//for gravity well
		contactListenerWell = new BasicContactListener();
		gravityWell.addContactListener(contactListenerWell);


		actorListAddActor((Actor)terrain);
		actorListAddActor((Actor)firstCrate);
		actorListAddActor((Actor)secondCrate);
		actorListAddActor((Actor)thirdCrate);
		actorListAddActor((Actor)bike);
		actorListAddActor((Actor)finishLine);
		actorListAddActor((Actor)finishLine2);
		actorListAddActor((Actor)seasaw);
		actorListAddActor((Actor)pendule);
		actorListAddActor((Actor)pendule2);
		actorListAddActor((Actor)crateField);
		actorListAddActor((Actor)key1);
		actorListAddActor((Actor)key2);
		actorListAddActor((Actor)key3);
		actorListAddActor((Actor)key4);
		actorListAddActor((Actor)key5);
		actorListAddActor((Actor)key6);
		actorListAddActor((Actor)key7);
		actorListAddActor((Actor)key8);
		actorListAddActor((Actor)key9);
		actorListAddActor((Actor)key10);
		actorListAddActor((Actor)checkPoint1);
		actorListAddActor((Actor)gravityWell);


		this.setViewCandidate(bike);


		return true;

	}


	@Override
	public void update(float deltaTime ) {
		setViewCandidate(bike);
		super.update(deltaTime);

		
		setHit();

		// delayer
		timeSinceStart += deltaTime;
		if(timeSinceStart < 1f) {
			message_up.setText("START");
			message_up.setParent(getCanvas());
			message_up.draw(getCanvas());
		} else {
			message_up.setText("");
			message_up.draw(getCanvas());
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
		if (hasHit && collectedKeys.size() >= 10) {
//		if (hasHit && collectedKeys >= 10) {
			bike.setHandLocation();
			finishLine.setFinishGraphics("flag.green.png");
			endingMessage("YOU WIN", "PRESS R TO TRY AGAIN");
			if(timeSinceEnd < 5f) {
				timeSinceEnd += deltaTime;
			} else {
				end();
			}
		} else if (hasHit && collectedKeys.size() < 10) {
//		} else if (hasHit && collectedKeys < 10) {
			endingMessage("OH NO", "You didn't collect all 10 keys");
			if(timeSinceEnd < 3f) {
				timeSinceEnd += deltaTime;
			} else {
				hasHit = false;
				endingMessage("","");
			}
		}


		if(collectedKeys.size()==10) {
//		if(collectedKeys==10) {
			finishLine.setFinishGraphics("door.open.png");
		}



		//--------------ContactListeners----------------------

		if(contactListenerWell.hasContactWith(bike.getEntity())) {
			//			bike.getEntity().applyForce(new Vector(362.5f,11f), new Vector(362.5f,-0f));

			setWellGravity(new Vector(0,4f));
		}else {
			setWellGravity(new Vector(0,-9.81f));
		}


		//----------------KEYS---------------------------------

		if(key1.gotHit()) {
			this.getOperatingActor().remove(key1);
			key1.destroy();
			addKeyToList();
//			collectedKeys++;
			key1.setGotHit(false);

		}

		if(key2.gotHit()) {
			this.getOperatingActor().remove(key2);
			key2.destroy();
			addKeyToList();
//			collectedKeys++;
			key2.setGotHit(false);

		}

		if(key3.gotHit()) {
			this.getOperatingActor().remove(key3);
			key3.destroy();
			addKeyToList();
//			collectedKeys++;
			key3.setGotHit(false);

		}

		if(key4.gotHit()) {
			this.getOperatingActor().remove(key4);
			key4.destroy();
			addKeyToList();
//			collectedKeys++;
			key4.setGotHit(false);

		}

		if(key5.gotHit()) {
			this.getOperatingActor().remove(key5);
			key5.destroy();
			addKeyToList();
//			collectedKeys++;
			key5.setGotHit(false);
		}

		if(key6.gotHit()) {
			this.getOperatingActor().remove(key6);
			key6.destroy();
			addKeyToList();
//			collectedKeys++;
			key6.setGotHit(false);
		}

		if(key7.gotHit()) {
			this.getOperatingActor().remove(key7);
			key7.destroy();
			addKeyToList();
//			collectedKeys++;
			key7.setGotHit(false);

		}

		if(key8.gotHit()) {
			this.getOperatingActor().remove(key8);
			key8.destroy();
			addKeyToList();
//			collectedKeys++;
			key8.setGotHit(false);
		}

		if(key9.gotHit()) {
			this.getOperatingActor().remove(key9);
			key9.destroy();
			addKeyToList();
//			collectedKeys++;
			key9.setGotHit(false);
		}

		if(key10.gotHit()) {
			this.getOperatingActor().remove(key10);
			key10.destroy();
			addKeyToList();
//			collectedKeys++;
			key10.setGotHit(false);
		}
		
		 while(collectedKeys.size()>10) {
			collectedKeys.remove(1);
			
//		if(collectedKeys >10) {
//			collectedKeys = 10;
		}
		keysCounter.setText(collectedKeys.size() + "/10");
		keysCounter.setParent(getCanvas());
		keysCounter.draw(getCanvas());



		//checkpoint
		if(checkPoint1.gotHit()) {
			checkPoint1.setGotHit(true);
			checkPoint1.setTriggerGraphics("flag.green.png");
			startingPosition = checkPointPosition;
		}

	}
	
	
	public void addKeyToList() {
		collectedKeys.add(1);
	}


	public boolean contactBikeFinish() {
		return contactListener.hasContactWith(bike.getEntity());
	}

	public void setBikePosition(Vector vector) {
		bikePosition = vector;
	}
	//	
	//	public void setStartingPosition(Vector vector) {
	//		startingPosition = vector;
	//	}
	//	


	public Vector getPosition() {
		return bikePosition;

	}

	public void endingMessage(String text_up, String text_down) {
		message_up.setText(text_up);
		message_down.setText(text_down);
		message_up.setFontSize(.18f);
		message_down.setFontSize(.12f);
		message_up.setAnchor(new Vector(0.5f,-3.5f));
		message_down.setAnchor(new Vector(.5f,-7f));
		message_up.setParent(getCanvas());
		message_down.setParent(getCanvas());
		message_up.draw(window);
		message_down.draw(window);
	}


	public void setHit() {
		if(contactBikeFinish())
			hasHit = true;
	}

}
