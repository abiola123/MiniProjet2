package ch.epfl.cs107.play.game.actor;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.bike.Bike;
import ch.epfl.cs107.play.game.actor.general.CrateField;
import ch.epfl.cs107.play.game.actor.general.Finish;
import ch.epfl.cs107.play.game.actor.general.Plank;
import ch.epfl.cs107.play.game.actor.general.Seasaw;
import ch.epfl.cs107.play.game.actor.general.Terrain;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.Contact;
import ch.epfl.cs107.play.math.ContactListener;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Window;

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
private boolean contactBikeFinish;
private CrateField crateField;
private TextGraphics message;
private BasicContactListener contactListener;

//vecteur finish line a changer 
private Vector finishLinePosition = new Vector(10.0f, 0f);
private Vector terrainPosition = new Vector(0.0f,0.0f);
private Vector v1 = (new Vector(0.0f, 5.0f));
private Vector v2 = (new Vector(0.2f, 7.0f));
private Vector v3 = (new Vector(2.0f, 6.0f));
private Vector bikePosition =  (new Vector(40.0f,5.0f));
private Vector seasawPosition = (new Vector(40.0f, -5.80f));
private Vector pendulePosition = (new Vector(49.0f    ,25.0f));
private Vector crateFieldPosition = (new Vector(220f,-5f));

	public boolean begin(Window window, FileSystem fileSystem) {
		super.begin(window, fileSystem);
		this.window = window;
		this.fileSystem = fileSystem;
		
		
		
		
		
		
		setPosition(new Vector(4.0f,6.0f));
		terrain = new Terrain(this,true,terrainPosition);
		firstCrate = new Crate(this,false,v1,1.0f,1.0f,"crate.3.png");
	    secondCrate = new Crate(this,false,v2,1.0f,1.0f,"crate.3.png");
		thirdCrate = new Crate(this,false,v3,1.0f,1.0f,"crate.3.png");
		bike = new Bike(this , false , bikePosition, 0.5f);
		finishLine = new Finish(this,true,finishLinePosition,"flag.red.png");
		finishLine2 = new Finish(this,true, new Vector(4f,0f),"flag.yellow.png");
		pendule = new Pendule(this,true,pendulePosition,1f,"saw.png.png",9.8f);
		crateField = new CrateField(this,true,crateFieldPosition);
		seasaw = new Seasaw(this,true,seasawPosition,10.0f,1.0f,5.0f,0.1f,Color.WHITE, Color.WHITE);
		
//		message = new TextGraphics("wassup", 2f, Color.RED, Color.WHITE, 0.02f, true,
//									false, new Vector(0.5f,0.5f),1.0f, 100.0f);
//		message.setParent(getCanvas());
		
		
		contactListener = new BasicContactListener();
		finishLine.addContactListener(contactListener);
		
		
		actorListAddActor((Actor)terrain);
		actorListAddActor((Actor)firstCrate);
		actorListAddActor((Actor)secondCrate);
		actorListAddActor((Actor)thirdCrate);
		actorListAddActor((Actor)bike);
		actorListAddActor((Actor)finishLine);
		actorListAddActor((Actor)finishLine2);
		actorListAddActor((Actor)seasaw);
		actorListAddActor((Actor)pendule);
		actorListAddActor((Actor)crateField);
		
		
		
		this.setViewCandidate(bike);
		
		return true;
		
	}
	
	public boolean contactBikeFinish() {
		return contactListener.hasContactWith(bike.getEntity());
	}
	
	public void update(Float deltaTime ) {
		setViewCandidate(bike);
		super.update(deltaTime);
		
		
		if(contactBikeFinish()) {
			finishLine.setFinishGraphics("flag.green.png");
		}

	}
		
	
	
	public void setPosition(Vector vector) {
		bikePosition = vector;
	}
	
	public Vector getPosition() {
		return bikePosition;
	}
	
	
	
}
