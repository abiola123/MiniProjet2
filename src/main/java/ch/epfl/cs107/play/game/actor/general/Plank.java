package ch.epfl.cs107.play.game.actor.general;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.RevoluteConstraint;
import ch.epfl.cs107.play.math.RevoluteConstraintBuilder;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

//2.Plank		
public class Plank extends GameEntity implements Actor {
	private float plankWidth;
	private float plankHeight;
	private ActorGame game;
	private ShapeGraphics plankGraphics;
	private String graphics = "";
	private Entity plank = getEntity();
	private RevoluteConstraint constraint;
	private BasicContactListener contactListener;
	private Color innerColor;
	private Color outerColor;
	private Polygon polygon;
	
	public Plank(ActorGame game, boolean fixed , Vector position , float plankWidth ,float plankHeight, Color innerColor, Color outerColor) {
			super(game,fixed,position);
		this.game = game;
		this.plankWidth = plankWidth;
		this.plankHeight = plankHeight;
		this.innerColor = innerColor;
		this.outerColor = outerColor;

		PartBuilder partBuilder = plank.createPartBuilder();
		polygon = new Polygon(
				 new Vector (0.0f, 0.0f),
				 new Vector (plankWidth, 0.0f),
				 new Vector (plankWidth, plankHeight),
				 new Vector (0.0f, plankHeight)
				 );
		
		partBuilder.setShape(polygon);
		partBuilder.build();
		plankGraphics = new ShapeGraphics(polygon,innerColor,outerColor,.1f,1f,0);
		plankGraphics.setParent(plank);
		
		contactListener = new BasicContactListener();
		plank.addContactListener(contactListener);
		
	}
	//simplified version,because normally you want to use constraintBuilder for seasaw like this
	//there is a complete version of attach after this method

	 
//		//comment radius et circle ?
//		//vu que jai fait un circle au lieu de faire un block 
//		faut-il legerement changer les vecteurs ?
	
	public void setPlankGraphics(Color innerColor , Color outerColor) {
		plankGraphics = new ShapeGraphics(polygon,innerColor,outerColor,.1f,1f,0);
		plankGraphics.setParent(plank);
	}
	
	

	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Canvas canvas) {
		plankGraphics.draw(canvas);
		
	}
	public void attach(Entity bodyBlock, float blockWidth, float blockHeight) {
		RevoluteConstraintBuilder revoluteConstraintBuilder  =	game.CreateRevoluteConstraintBuilder();
		 revoluteConstraintBuilder.setFirstEntity(bodyBlock) ;
		 revoluteConstraintBuilder.setFirstAnchor(new Vector(blockWidth /2,
		 (blockHeight *7) /4)) ;
		 revoluteConstraintBuilder.setSecondEntity(plank) ;
		 revoluteConstraintBuilder.setSecondAnchor(new Vector(plankWidth /2,
		 plankHeight /2)) ;
		 revoluteConstraintBuilder.setInternalCollision(true) ;
		 revoluteConstraintBuilder.build () ;
		 constraint = revoluteConstraintBuilder.build();
		}
	
	public void update(float deltaTime) {
		int numberOfCollisions = contactListener.getEntities().size();
		if (numberOfCollisions > 0){
		setPlankGraphics(Color.RED, Color.RED) ;
		System.out.println("haha");
	}
		
	}
}

