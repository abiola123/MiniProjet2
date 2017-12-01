package ch.epfl.cs107.play.game.tutorial;

import java.awt.Color;
import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.RopeConstraintBuilder;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Window;

//Fallait il mettre la methode implements
public class RopeGame implements Game {

private Window window;
private World world;
private Entity bodyOfBlock;
private Entity bodyOfCircle;
private ImageGraphics block;
private ShapeGraphics ball;
private float blockWidth;
private float blockHeight;


	



public boolean begin(Window window,FileSystem filesSystem) {
	this.window = window;
	world = new World();
	world.setGravity(new Vector(0.0f, -9.81f));
	
	EntityBuilder entityBuilder1 = world.createEntityBuilder();
	entityBuilder1.setFixed(true);
	entityBuilder1.setPosition(new Vector(1.0f, 0.5f));
	bodyOfBlock = entityBuilder1.build();
	PartBuilder partBuilder1 = bodyOfBlock.createPartBuilder();
	blockWidth = 1.0f;
	blockHeight =1.0f;
	Polygon polygon = new Polygon(
			new Vector (0.0f, 0.0f),
			new Vector (blockWidth, 0.0f),
			new Vector (blockWidth, blockHeight),
			new Vector (0.0f, blockHeight)
			) ;
	partBuilder1.setShape(polygon);
	partBuilder1.build();
	block = new ImageGraphics("box.5.png",1,1);
	block.setParent(bodyOfBlock);
	block.setAlpha(1.0f);
	block.setDepth(0.0f);
	
	
	
	//---------------------------------------------
	
	EntityBuilder entityBuilder2 = world.createEntityBuilder();
	entityBuilder2.setFixed(false);
	entityBuilder2.setPosition(new Vector(0.6f, 4.0f));
	bodyOfCircle= entityBuilder2.build();
	PartBuilder partBuilder2 = bodyOfCircle.createPartBuilder();
	Circle circle = new Circle(0.6f);
	partBuilder2.setShape(circle);
	partBuilder2.build();
	ball = new ShapeGraphics(circle , Color.BLUE , Color.RED , .1f, 1.f , 0);
    ball.setParent(bodyOfCircle);
	
	
	

	RopeConstraintBuilder ropeConstraintBuilder =
			world.createRopeConstraintBuilder () ;
			ropeConstraintBuilder.setFirstEntity(bodyOfBlock) ;
			ropeConstraintBuilder.setFirstAnchor(new Vector(blockWidth/2,
			blockHeight/2)) ;
			ropeConstraintBuilder.setSecondEntity(bodyOfCircle) ;
			ropeConstraintBuilder.setSecondAnchor(Vector.ZERO) ;
			ropeConstraintBuilder.setMaxLength (6.0f) ;
			ropeConstraintBuilder.setInternalCollision(true) ;
			ropeConstraintBuilder.build () ;
			
	return true;
	
}
	
	public void update(float deltaTime) {
		world.update(deltaTime);
		window.setRelativeTransform(Transform.I.scaled(10.0f));
		
		block.draw(window);
		ball.draw(window);
		
	}
	

	public void end() {
	}
}
	