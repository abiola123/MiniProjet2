package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;

import org.jbox2d.dynamics.contacts.Velocity;

import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Shape;


public abstract class GameEntity {

	private ActorGame game;
	private Entity body;
	
	// protected allow a better protection and prevent the modification outside of the package
	// protected still allows whole access in the same package, just like "public" would do normally and this is not always wanted
	
	
	
	 public GameEntity(ActorGame game, boolean fixed , Vector position) {
		this.game = game;
	
		
		//we chose a boolean to let the user choose between a ShapeBuilder and a EntityBuilder , if the boolean is true the game chooses a EntityBuilder, if it is false we get a ShapeBuilder
		
		EntityBuilder entityBuilder = game.CreateEntityBuilder();
		entityBuilder.setFixed(fixed);
		entityBuilder.setPosition(position);
		body = entityBuilder.build();
		
//		PartBuilder partBuilder = body.createPartBuilder();
//		partBuilder.setShape(shape);
//		body.setParent()
//		
		
		
		
		 
	

}
	 
	
	public GameEntity(ActorGame game, boolean fixed) {
		this.game = game;
		
		EntityBuilder entityBuilder = game.CreateEntityBuilder();
		entityBuilder.setFixed(fixed);
		body = entityBuilder.build();
		
		
	
	}
	
	public void destroy() {
		body.destroy();
	}
	
	protected Entity getEntity() {
		return body;
	}
	
	
	public Vector getVelocity() {
		Vector velocity = body.getVelocity();
		return velocity;
		
	}
	
	protected ActorGame getOwner() {
		return game;
	}
}