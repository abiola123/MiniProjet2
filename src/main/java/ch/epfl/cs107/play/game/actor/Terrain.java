package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Terrain extends GameEntity implements Actor {

private GameEntity gameEntity;
private Actor actor;
private boolean fixed;
private Vector position;
private Entity body = getEntity();
private ImageGraphics terrainGraphics;

	public Terrain(ActorGame game, boolean fixed, Vector position) {
		
		super(game,fixed,position);
		
		PartBuilder partBuilder = body.createPartBuilder();
		Polyline polyline = new Polyline(
				-1000.0f, -1000.0f,
				-1000.0f, 0.0f,
				0.0f, 0.0f,
				3.0f, 1.0f,
				8.0f, 1.0f,
				15.0f, 3.0f,
				16.0f, 3.0f,
				25.0f, 0.0f,
				35.0f, -5.0f,
				50.0f, -5.0f,
				55.0f, -4.0f,
				65.0f, 0.0f,
				6500.0f, -1000.0f
				);
		partBuilder.setShape(polyline);
		partBuilder.build();
		
		//Faut-il une resprésentation graphique ?
		
		
	}

	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}
}
