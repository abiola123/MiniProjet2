package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.window.Window;
import ch.epfl.cs107.play.game.actor.bike.Bike;
import ch.epfl.cs107.play.game.actor.general.Crate;
import ch.epfl.cs107.play.game.actor.general.Terrain;
import ch.epfl.cs107.play.game.actor.general.Wheel;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;


public class BikeGame extends ActorGame{
private FileSystem fileSystem;
private Window window;
//private ActorGame game;
//private Wheel firstWheel;
//private Wheel secondeWheel;
private Crate firstCrate;
private Crate secondCrate;
private Crate thirdCrate;
private Terrain terrain;
private Bike bike;
private Wheel leftWheel;
private Wheel rightWheel;
private Vector leftWheelPosition = new Vector(3.0f,6.0f);
private Vector rightWheelPosition = new Vector(5.0f,6.0f);
//?????????? declaration du vecteur
private Vector terrainPosition = new Vector(0.0f,0.0f);
private Vector v1 = (new Vector(0.0f, 5.0f));
private Vector v2 = (new Vector(0.2f, 7.0f));
private Vector v3 = (new Vector(2.0f, 6.0f));
private Vector bikePosition; 

	public boolean begin(Window window, FileSystem fileSystem) {
		super.begin(window, fileSystem);
		this.window = window;
		this.fileSystem = fileSystem;
		
		
		
//		ActorGame.setViewCandidate(viewCandidate);
		
		
		
		
		setBikePositon(new Vector(4.0f,6.0f));
		terrain = new Terrain(this,true,terrainPosition);
		firstCrate = new Crate(this,false,"box.4.png",v1,1.0f,1.0f);
	    secondCrate = new Crate(this,false,"box.4.png",v2,1.0f,1.0f);
		thirdCrate = new Crate(this,false,"box.4.png",v3,1.0f,1.0f);
//		bike = new Bike(this , false , bikePosition);
		leftWheel = new Wheel(this,false,leftWheelPosition,0.5f);
		rightWheel = new Wheel(this,false,rightWheelPosition,0.5f);
//		
		actorListAddActor((Actor)terrain);
		actorListAddActor((Actor)firstCrate);
		actorListAddActor((Actor)secondCrate);
		actorListAddActor((Actor)thirdCrate);
//		actorListAddActor((Actor)bike);
//		actorListAddActor((Actor)leftWheel);
//		actorListAddActor((Actor)rightWheel);
//			
		//créer tableau de actors ou pas ??
		
		return true;
		
		
		
	}
	
	public void setBikePositon(Vector vector) {
		bikePosition =vector;
	}
	
	public Vector getBikePositon() {
		return bikePosition;
	}
}
