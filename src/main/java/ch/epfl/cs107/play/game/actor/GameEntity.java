package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.game.actor.general.Wheel;
import ch.epfl.cs107.play.math.Contact;
import ch.epfl.cs107.play.math.ContactListener;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.Vector;



public abstract class GameEntity {

	private ActorGame game;
	private Entity body;
	private ContactListener contactListener;

	// protected allow a better protection and prevent the modification outside of the package
	// protected still allows whole access in the same package, just like "public" would do normally and this is not always wanted


	//creates the basis for a  GameEntity
	public GameEntity(ActorGame game, boolean fixed , Vector position) {
		this.game = game;

		EntityBuilder entityBuilder = game.CreateEntityBuilder();
		entityBuilder.setFixed(fixed);
		entityBuilder.setPosition(position);
		body = entityBuilder.build();

	}


	public GameEntity(ActorGame game, boolean fixed) {
		this.game = game;

		EntityBuilder entityBuilder = game.CreateEntityBuilder();
		entityBuilder.setFixed(fixed);
		body = entityBuilder.build();	
	}

	//destroys body of the GameEntity
	public void destroy() {
		body.destroy();
	}

	//returns entity of the GameEntity
	protected Entity getEntity() {
		return body;
	}

	//returns angular position of wheels (used for cycling animation extension)
	public float getWheelAngle(Wheel wheel) {
		return wheel.getEntity().getAngularPosition();
	}

	//checks if any of the wheels of the bike are in contact with any object
	public boolean contactBikeWithPolyline(Contact contact ,  Wheel leftWheel , Wheel rightWheel) {
		return (contact.getOther().getEntity() == leftWheel.getEntity() || contact.getOther().getEntity() == rightWheel.getEntity());



	}

	//adds a contactListener
	public void addContactListener(ContactListener listener) {
		body.addContactListener(listener);
		contactListener = listener;

	}



	//returns an entity's velocity
	public Vector getVelocity() {
		Vector velocity = body.getVelocity();
		return velocity;

	}


	protected ActorGame getOwner() {
		return game;
	}
}