package ch.epfl.cs107.play.game.actor.general;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Contact;
import ch.epfl.cs107.play.math.ContactListener;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.Node;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class GravityWell extends GameEntity implements Actor{

	private Entity poly = getEntity(); 
	private ShapeGraphics polygonGraphics;


	public GravityWell(ActorGame game, boolean fixed, Vector position, float width, float height, Color fillColor, Color outlineColor) {

		super(game,fixed,position);

		PartBuilder partBuilder = poly.createPartBuilder();
		Polygon polygon = new Polygon (
				0f, 0f,
				0f, height,
				width,  height,
				width, 0f
				);
		
		partBuilder.setGhost(true);
		createPolygon(polygon,poly,partBuilder);
		polygonGraphics = new ShapeGraphics(polygon,fillColor,outlineColor,.1f,.2f,0);
		polygonGraphics.setParent(poly);
		poly.applyForce(new Vector(43f,52f),new Vector(55f,43f));
		
	}



	public void createPolygon(Polygon polygon, Entity entity, PartBuilder partBuilder ) {
		partBuilder.setShape(polygon);
		partBuilder.build();
	}


	@Override
	public Transform getTransform() {
		return getTransform();
	}

	@Override
	public void draw(Canvas canvas) {
		polygonGraphics.draw(canvas);
	}
}