package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.window.Window;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;


public class BikeGame extends ActorGame{
private FileSystem fileSystem;
private Window window;
private float blockWidth;
private float blockHeight;
private ActorGame game;
private Wheel firstWheel;
private Wheel secondeWheel;
private Crate firstCrate;
private Crate secondCrate;

	public boolean begin(Window window, FileSystem fileSystem) {
		super.begin(window, fileSystem);
		this.window = window;
		this.fileSystem = fileSystem;
		
		
		
		
		
		
	}
}
