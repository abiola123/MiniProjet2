package ch.epfl.cs107.play.game.tutorial;

import java.awt.Color;
import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Window;


public class ContactGame implements Game {
	private Window window;
	private World world;
	private Entity block;
	private Entity ball;
	private ImageGraphics blockGraphics;
	private ShapeGraphics ballGraphics;
	private float blockWidth;
	private float blockHeight;
	private BasicContactListener contactListener;



	public boolean begin(Window window, FileSystem fileSystem) {
		this.window = window;
		world = new World();
		world.setGravity(new Vector(0.0f, -9.81f));
		
		
	
//1.---------------------------------------------------------------

	EntityBuilder entityBuilder1 = world.createEntityBuilder();
	entityBuilder1.setFixed(true);
	entityBuilder1.setPosition(new Vector(-5.0f, -1.0f));
	block = entityBuilder1.build();
	PartBuilder partBuilder1 = block.createPartBuilder();
	blockWidth = 10.0f;
	blockHeight = 1.0f;
	
	Polygon polygon1  = new Polygon(
			 new Vector (0.0f, 0.0f),
			 new Vector (blockWidth, 0.0f),
			 new Vector (blockWidth, blockHeight),
			 new Vector (0.0f, blockHeight)
			 );
	partBuilder1.setShape(polygon1);
	partBuilder1.build();
	//Question mark, do i have to change the dimensions of the imagegraphics ?
	blockGraphics = new ImageGraphics("stone.broken.4.png" , 10 ,1 );
	blockGraphics.setParent(block);
	blockGraphics.setAlpha(1.0f);
	
	//2.----------------------------------------------------------------
	
	EntityBuilder entityBuilder2 = world.createEntityBuilder();
	entityBuilder2.setFixed(false);
	entityBuilder2.setPosition(new Vector(0.0f, 2.0f));
	ball = entityBuilder2.build();
	PartBuilder partBuilder2 = ball.createPartBuilder();
	Circle circle = new Circle(0.5f);
	partBuilder2.setShape(circle);
	partBuilder2.build();
	//On est censé faire correspondre une image au graphique du cercle ,mais la mehtode ne permet pas ca
	ballGraphics = new ShapeGraphics(circle, Color.BLUE, Color.BLUE , .1f , 1, 0);
	ballGraphics.setParent(ball);
	
	contactListener = new BasicContactListener();
	ball.addContactListener(contactListener);
	  
	
	return true;
	}
	
	public void update(float deltaTime) {
		
		world.update(deltaTime);
		window.setRelativeTransform(Transform.I.scaled(10.0f));
		
		// contactListener is associated to ball
		// contactListener.getEntities () returns the list of entities in collision with ball
		int numberOfCollisions = contactListener.getEntities ().size() ;
		if (numberOfCollisions > 0){
		ballGraphics.setFillColor(Color.RED) ;
		}
		
		blockGraphics.draw(window);
		ballGraphics.draw(window);
		
	}
	public void end() {
	}
}
	
