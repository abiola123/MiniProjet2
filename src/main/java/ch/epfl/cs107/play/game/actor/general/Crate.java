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

	//private ActorGame game;
	//private boolean fixed;
	private Entity body = getEntity();
	private ImageGraphics blockGraphics;
	//private Vector position;
	private float blockWidth;
	private float blockHeight;


	//----------------------------------------------------------------
	
	
		public Crate(ActorGame game, boolean fixed , Vector position , float blockWidth, float blockHeight) {
			
			super(game, fixed,position);
//			this.fixed = fixed;
//			this.game = game;
//			this.position = position;
//			this.blockHeight = blockHeight;
//			this.blockWidth = blockWidth;
		PartBuilder partBuilder = body.createPartBuilder();
		Polygon polygon = new Polygon (
				new Vector (0.0f, 0.0f),
				new Vector (blockWidth, 0.0f),
				new Vector (blockWidth,blockHeight),
				new Vector (0.0f, blockHeight)
				) ;
		
		partBuilder.setShape(polygon);
		partBuilder.build();
		blockGraphics = new ImageGraphics("stone.broken.4.png",1,1);
		blockGraphics.setParent(body);
	//--------------------------------------------------------------
		
		
		}
		public void draw(Canvas canvas) {
		blockGraphics.draw(canvas);	
			
	
	//--------------------------------------------------------------	
		
		}
		
		
		//the user might want to change the size of the crates
		
		//is this actually a good idea? or is it better to not let the user change the size of the blocks ?
		
		
		public void setblockWidth(float blockWidth) {
			this.blockWidth = blockWidth;
		}
		
		public void setblockHeight(float blockHeight) {
			this.blockHeight = blockHeight;
		}
	
	//---------------------------------------------------------------
		
		
		
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
	
		}
