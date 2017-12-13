package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Crate extends GameEntity implements Actor {

	private Entity body = getEntity();
	private ImageGraphics blockGraphics;


	public Crate(ActorGame game, boolean fixed, Vector position , float blockWidth, float blockHeight, String graphics) {

		super(game, fixed,position);
		
		if(position == null || blockWidth <= 0 || blockHeight <= 0) {
			throw new IllegalArgumentException("Parametre invalide");
		}

		//creates body
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
		blockGraphics = new ImageGraphics(graphics,blockWidth,blockHeight);
		blockGraphics.setParent(body);

	}
	public void draw(Canvas canvas) {
		blockGraphics.draw(canvas);	


	}


	@Override
	public Transform getTransform() {
		return getTransform();
	}
	@Override
	public Vector getVelocity() {
		return getVelocity();
	}



}
