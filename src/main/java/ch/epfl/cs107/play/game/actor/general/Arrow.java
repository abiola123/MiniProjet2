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


public class Arrow extends GameEntity implements Actor {
private ImageGraphics arrowGraphics;
private Entity body = getEntity();
private PartBuilder partBuilder;
private Vector position;

	public Arrow(ActorGame game, boolean fixed, Vector position, String graphics, float graphicsWidth, float graphicsHeight)  {
		super(game, fixed,position);
		
		PartBuilder partBuilder = body.createPartBuilder();
		Polygon polygon = new Polygon(
				0f,0f,
				1.0f,0f,
				1.0f,1f,
				0f,1f
				
				
				
				);
		partBuilder.setShape(polygon);
		partBuilder.setGhost(true);
		partBuilder.build();
		arrowGraphics = new ImageGraphics(graphics,graphicsWidth,graphicsHeight);
		arrowGraphics.setParent(body);
		
	}
	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void draw(Canvas canvas) {
	arrowGraphics.draw(canvas);
	
	}

}
