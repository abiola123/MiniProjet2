package ch.epfl.cs107.play.game.actor;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.bike.Bike;
import ch.epfl.cs107.play.game.actor.general.Finish;
import ch.epfl.cs107.play.game.actor.general.Plank;
import ch.epfl.cs107.play.game.actor.general.Seasaw;
import ch.epfl.cs107.play.game.actor.general.Terrain;
import ch.epfl.cs107.play.game.actor.general.Wheel;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Contact;
import ch.epfl.cs107.play.math.ContactListener;
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
private Wheel leftWheel;
private Wheel rightWheel;
private Finish finishLine;
private Seasaw seasaw;
private Plank plankSeasaw;
private Pendule pendule;
private boolean contactBikeFinish;

//test
private Crate fourthCrate;
//?????????? declaration du vecteur

//vecteur finish line a changer 
private Vector finishLinePosition = new Vector(55.0f, -4.0f);
private Vector terrainPosition = new Vector(0.0f,0.0f);
private Vector v1 = (new Vector(0.0f, 5.0f));
private Vector v2 = (new Vector(0.2f, 7.0f));
private Vector v3 = (new Vector(2.0f, 6.0f));
private Vector bikePosition =  (new Vector(4.0f,5.0f));
private Vector seasawPosition = (new Vector(40.0f, -5.80f));
private Vector pendulePosition = (new Vector(15.f,7.0f));
// test
private Vector v4 = (new Vector(57.0f, -4.0f));





	


	public boolean begin(Window window, FileSystem fileSystem) {
		super.begin(window, fileSystem);
		this.window = window;
		this.fileSystem = fileSystem;
		
		ContactListener listener = new ContactListener() {
			@Override
			public void beginContact(Contact contact) {
				if(contact.getOther().getEntity() == bike.getEntity()) {
					contactBikeFinish = true;
				
				}
			}
			
			@Override
			public void endContact(Contact contact) {}
				};
		
		
		setPositon(new Vector(4.0f,6.0f));
		terrain = new Terrain(this,true,terrainPosition);
		firstCrate = new Crate(this,false,v1,1.0f,1.0f,"wood.3.png");
	    secondCrate = new Crate(this,false,v2,1.0f,1.0f,"wood.4.png");
		thirdCrate = new Crate(this,false,v3,1.0f,1.0f,"wood.4.png");
		bike = new Bike(this , false , bikePosition, 0.5f);
		finishLine = new Finish(this,true,finishLinePosition,"flag.red.png");
		pendule = new Pendule(this,true,pendulePosition,0.5f,Color.WHITE,Color.WHITE);
		
		//test
		if(contactBikeFinish)
		fourthCrate = new Crate(this,false,v4,1.0f,1.0f,"wood.3.png");
		
		seasaw = new Seasaw(this,true,seasawPosition,10.0f,1.0f,5.0f,0.1f,Color.WHITE, Color.WHITE);


		finishLine.getEntity().addContactListener(listener);
		
		
		
		actorListAddActor((Actor)terrain);
		actorListAddActor((Actor)firstCrate);
		actorListAddActor((Actor)secondCrate);
		actorListAddActor((Actor)thirdCrate);
		actorListAddActor((Actor)bike);
		actorListAddActor((Actor)finishLine);
		actorListAddActor((Actor)seasaw);
		actorListAddActor((Actor)pendule);
		//test
		if(contactBikeFinish)
		actorListAddActor((Actor)fourthCrate);	
		this.setViewCandidate(bike);
		
		return true;
		
	}
	public void update(Float deltaTime ) {
		setViewCandidate(bike);
		super.update(deltaTime);
		
		
		if (contactBikeFinish) {
			System.out.println("WON");
			finishLine.setFinishGraphics("flag.green.png");
		}
		
		
	}
		
	
	
	public void setPositon(Vector vector) {
		bikePosition =vector;
	}
	
	public Vector getPositon() {
		return bikePosition;
	}
}
