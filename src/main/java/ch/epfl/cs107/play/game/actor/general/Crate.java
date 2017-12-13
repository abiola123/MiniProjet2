package ch.epfl.cs107.play.game.actor.general;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Crate extends GameEntity implements Actor {

	private Entity body = getEntity();
	private ImageGraphics blockGraphics;
	private float blockWidth;
	private float blockHeight;
	private Vector position;


	//----------------------------------------------------------------

	//creates a new crate
	public Crate(ActorGame game, boolean fixed , Vector position , float blockWidth, float blockHeight, String graphics) {

		super(game, fixed,position);
		this.body = body;
		this.position = position;
		PartBuilder partBuilder = body.createPartBuilder();
		Polygon polygon = new Polygon (
				new Vector (0.0f, 0.0f),
				new Vector (blockWidth, 0.0f),
				new Vector (blockWidth,blockHeight),
				new Vector (0.0f, blockHeight)
				) ;

		partBuilder.setShape(polygon);
		partBuilder.build();
		
		//graphics of crate
		blockGraphics = new ImageGraphics(graphics,1,1);
		blockGraphics.setParent(body);
	}
	//--------------------------------------------------------------



	public void draw(Canvas canvas) {
		blockGraphics.draw(canvas);	

	}


	//--------------------------------------------------------------	



	//the user might want to change the size of the crates



	public void setblockWidth(float blockWidth) {
		this.blockWidth = blockWidth;
	}

	public void setblockHeight(float blockHeight) {
		this.blockHeight = blockHeight;
	}

	//---------------------------------------------------------------

	@Override
	public Vector getPosition() {
		return position;
	}
	public Entity returnEntity() {
		return body;
	}


	@Override
	public Transform getTransform() {
		return null;
	}
	@Override
	public Vector getVelocity() {
		return getVelocity();
	}

}
