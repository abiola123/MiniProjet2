package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.math.Positionable;
import ch.epfl.cs107.play.window.Window;


public interface Actor extends Positionable,Graphics {

//	private Entity entity;
//	private Grapics graphics;
//	private Body body = GameEntity.entity;
//	private String name;
//	private float width;
//	private float height;
//	


	public default void update(float deltaTime) {
		
		

	}
	// By default , actors have nothing to update

	public default void destroy (){
		
		
		// By default , actors have nothing to destroy


	}
	
//	public void ImageGraphics(String picture, float width, float height) {
//	this.body = new ImageGraphics(String,Height,Length);
//		
//		}
//	}
	
	
	// vraiment à ajouter ou pas ? 
	

}