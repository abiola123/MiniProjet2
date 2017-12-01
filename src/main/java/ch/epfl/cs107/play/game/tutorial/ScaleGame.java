package ch.epfl.cs107.play.game.tutorial;

import java.awt.Color;

import com.sun.glass.events.KeyEvent;

import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.RevoluteConstraintBuilder;
import ch.epfl.cs107.play.math.Shape;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Window;

public class ScaleGame implements Game {
	private Window window;
	private World world;
	private Entity bodyOfPlank;
	private Entity bodyOfBlock;
	private Entity bodyOfCircle;
	private ImageGraphics plank;
	private ImageGraphics block;
	private ImageGraphics ball;
	private float blockWidth;
	private float blockHeight;
	private float plankWidth;
	private float plankHeight;

 public boolean begin(Window window,FileSystem filesSystem) {
	 this.window = window;
	 world = new World();
	 world.setGravity(new Vector(0.0f, -9.81f));
	 
	 //1.---------------------------------------------------------------
	 EntityBuilder entityBuilder1 = world.createEntityBuilder();
	 entityBuilder1.setFixed(false);
	 entityBuilder1.setPosition(new Vector(-2.5f, 0.8f));
	 bodyOfPlank = entityBuilder1.build();
	 PartBuilder partBuilder1 = bodyOfPlank.createPartBuilder();
	 plankWidth = 5.0f;
	 plankHeight = 0.2f;
	 Polygon polygon1 = new Polygon(
			 new Vector (0.0f, 0.0f),
			 new Vector (plankWidth, 0.0f),
			 new Vector (plankWidth, plankHeight),
			 new Vector (0.0f, plankHeight)
			 );
	 partBuilder1.setShape(polygon1);
	 partBuilder1.build();
	 plank = new ImageGraphics("wood.3.png", 5.0f , 0.2f);
	 plank.setParent(bodyOfPlank);
	 plank.setAlpha(1.0f);
	 
	 
	 //2.---------------------------------------------------------------
	 EntityBuilder entityBuilder2 = world.createEntityBuilder();
	 entityBuilder2.setFixed(true);
	 entityBuilder2.setPosition(new Vector(-5.0f, -1.0f));
	 bodyOfBlock = entityBuilder2.build();
	 PartBuilder partBuilder2 = bodyOfBlock.createPartBuilder();
	 blockWidth = 10.0f;
	 blockHeight = 1.0f;
	 
	 Polygon polygon2  = new Polygon(
			 new Vector (0.0f, 0.0f),
			 new Vector (blockWidth, 0.0f),
			 new Vector (blockWidth, blockHeight),
			 new Vector (0.0f, blockHeight)
			 );
	 partBuilder2.setShape(polygon2);
	 partBuilder2.build();
	 block = new ImageGraphics("stone.broken.4.png" , 10.0f ,1.0f );
	 block.setParent(bodyOfBlock);
	 block.setAlpha(1.0f);
	 
	 //3.---------------------------------------------------------------
	 EntityBuilder entityBuilder3 = world.createEntityBuilder();
	 entityBuilder3.setFixed(false);
	 entityBuilder3.setPosition(new Vector(0.5f, 4.f));
	 bodyOfCircle = entityBuilder3.build();
	 PartBuilder partBuilder3 = bodyOfCircle.createPartBuilder();
	 Circle circle = new Circle(0.5f);
	 partBuilder3.setShape(circle);
	 partBuilder3.build();
	 ball = new ImageGraphics("explosive.11.png" , 1.0f , 1.0f ,new Vector(0.5f , 0.5f));
	 ball.setParent(bodyOfCircle);
	   
	RevoluteConstraintBuilder revoluteConstraintBuilder =
	world.createRevoluteConstraintBuilder();
	 revoluteConstraintBuilder.setFirstEntity(bodyOfBlock) ;
	 revoluteConstraintBuilder.setFirstAnchor(new Vector(blockWidth /2,
	 (blockHeight *7) /4)) ;
	 revoluteConstraintBuilder.setSecondEntity(bodyOfPlank) ;
	 revoluteConstraintBuilder.setSecondAnchor(new Vector(plankWidth /2,
	 plankHeight /2)) ;
	 revoluteConstraintBuilder.setInternalCollision(true) ;
	 revoluteConstraintBuilder.build () ;
	 
	 
	 
	 return true;
 }
 	public void update(float deltaTime) {
 		if (window.getKeyboard ().get(KeyEvent.VK_LEFT).isDown ()) {
 			bodyOfCircle.applyAngularForce (10.0f) ;
 		} else if (window.getKeyboard ().get(KeyEvent.VK_RIGHT).isDown ()) {
 			bodyOfCircle.applyAngularForce ( -10.0f) ;
 			}
 		world.update(deltaTime);
 		window.setRelativeTransform(Transform.I.scaled(10.0f));
 		
 		block.draw(window);
 		ball.draw(window);
 		plank.draw(window);
 	
 	}
 	public void end() {
 	}
}
 