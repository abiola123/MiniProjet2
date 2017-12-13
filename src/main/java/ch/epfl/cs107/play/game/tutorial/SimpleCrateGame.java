package ch.epfl.cs107.play.game.tutorial;

import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Window;


public class SimpleCrateGame implements Game {
	private Window window;
	private World world;
	private Entity body;
	private Entity body2;
	private ImageGraphics block;
	private ImageGraphics crate;


@Override
public boolean begin(Window window, FileSystem filesSystem) {
	
	this.window = window;
	world = new World();
	
	world.setGravity(new Vector(0.0f, -9.81f));
	

	EntityBuilder entityBuilder1 = world.createEntityBuilder();
	entityBuilder1.setFixed(true);
	entityBuilder1.setPosition(new Vector(1.0f, 0.5f));
	body = entityBuilder1.build();
	
	
	PartBuilder partBuilder = body.createPartBuilder();
	Polygon polygon = new Polygon(
	new Vector (0.0f, 0.0f),
	new Vector (1.0f, 0.0f),
	new Vector (1.0f, 1.0f),
	new Vector (0.0f, 1.0f)
	) ;
	partBuilder.setShape(polygon) ;
	
	partBuilder.build () ;
	 
	
 	block = new ImageGraphics("box.4.png" , 1 , 1);
   	block.setParent(body);
   	block.setAlpha(1.0f);
   	block.setDepth(0.0f);
	
	EntityBuilder entityBuilder2 = world.createEntityBuilder();
	entityBuilder2.setFixed(false);
   	entityBuilder2.setPosition(new Vector(0.2f, 4.0f));
   	body2 = entityBuilder2.build();

   	PartBuilder partBuilder2 = body2.createPartBuilder();
	partBuilder2.setShape(polygon);
	partBuilder2.build();
   	
	crate = new ImageGraphics("box.4.png" , 1 , 1);
   	crate.setParent(body2);
   	crate.setAlpha(1.0f);
   	crate.setDepth(0.0f);
	
	return true;
	
}
	@Override
	public void update(float deltaTime) {
		world.update(deltaTime);
		window.setRelativeTransform(Transform.I.scaled(10.0f));
		
		block.draw(window);
		crate.draw(window);
	}
	
	 @Override
	 public void end() {
	 }
	
 }
		 
	 