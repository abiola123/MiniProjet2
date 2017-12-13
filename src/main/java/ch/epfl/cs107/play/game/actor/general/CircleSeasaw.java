package ch.epfl.cs107.play.game.actor.general;



import java.awt.Color;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

		
		
//1.Circle		
public class CircleSeasaw extends GameEntity implements Actor {
//the user can choose if the circle that supports the plank is invisible or not
private boolean invisible;
private ShapeGraphics circleGraphics;
private Entity circle = getEntity();

//maybe add a function to let the user choose colour of graphical representation

	public CircleSeasaw(ActorGame game, boolean fixed , Vector position,boolean invisible, float radius) {
		super(game,fixed,position);
		
		if(radius <= 0) {
			throw new IllegalArgumentException("Parametre invalide");
		}
		
		PartBuilder partBuilder1 = circle.createPartBuilder();
		Circle circle1 = new Circle(radius);
		partBuilder1.setShape(circle1);
		partBuilder1.build();
		
		if(!invisible) {
			circleGraphics = new ShapeGraphics(circle1,Color.WHITE,Color.WHITE,.1f,1.f,0);
			circleGraphics.setParent(circle);
		}
		
		
	}

	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Canvas canvas) {
		
		if(!invisible)  
			circleGraphics.draw(canvas);
			
	}
	

	
	public Entity getCircleSeasawEntity() {
		return circle;
	}
}
		
		
		
		
		

