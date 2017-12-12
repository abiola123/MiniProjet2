package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.math.Positionable;
import ch.epfl.cs107.play.window.Window;


public interface Actor extends Positionable,Graphics {


	public default void update(float deltaTime) {
		
		

	}
	// By default , actors have nothing to update

	public default void destroy (){
		
		
		// By default , actors have nothing to destroy


	}
	


}