package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Window;

public class Crate extends GameEntity implements Actor {
//private ActorGame game;
//private boolean fixed;
private Entity body = getEntity();
private ImageGraphics blockGraphics;
//private Vector position;
//private float blockWidth;
//private float blockHeight;
private String graphics;
private Vector position;


	public Crate(ActorGame game, boolean fixed, Vector position , float blockWidth, float blockHeight, String graphics) {
		
		super(game, fixed,position);
//		this.fixed = fixed;
//		this.game = game;
//		this.position = position;
//		this.blockHeight = blockHeight;
//		this.blockWidth = blockWidth;
		this.graphics = graphics;
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
	
	//mettte methode pour les dimensions ?
	blockGraphics = new ImageGraphics(graphics,blockWidth,blockHeight);
	blockGraphics.setParent(body);
	
	}
public void draw(Canvas canvas) {
	blockGraphics.draw(canvas);	
		
		
	}

// les returns sont correctes ???
@Override
public Transform getTransform() {
	// TODO Auto-generated method stub
	return getTransform();
}
@Override
public Vector getVelocity() {
	// TODO Auto-generated method stub
	return getVelocity();
}

 @Override 
 public Vector getPosition() {
	 return position;
 }

////allowed to do this ??
//public Entity getBody() {
//	// TODO Auto-generated method stub
//	return body;
//}

}
