package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.window.Window;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;

public class CrateGame extends ActorGame {
private Window window;
private FileSystem fileSystem;
private float blockWidth;
private float blockHeight;
private Vector v1 = (new Vector(0.0f, 5.0f));
private Vector v2 = (new Vector(0.2f, 7.0f));
private Vector v3 = (new Vector(2.0f, 6.0f));
private ActorGame game;
private Crate firstCrate;
private Crate secondCrate;
private Crate thirdCrate;
	public boolean begin(Window window, FileSystem fileSytem) {
		super.begin(window, fileSystem);
		this.window = window;
		this.fileSystem = fileSystem;

	
		
		firstCrate = new Crate(this,false,v1,1.0f,1.0f, "wood.4.png");
	    secondCrate = new Crate(this,false,v2,1.0f,1.0f, "wood.4.png");
		thirdCrate = new Crate(this,false,v3,1.0f,1.0f, "wood.4.png");
		
		actorListAddActor((Actor)firstCrate);
		actorListAddActor((Actor)secondCrate);
		actorListAddActor((Actor)thirdCrate);
		return true;
		
	}
}	
	
	

