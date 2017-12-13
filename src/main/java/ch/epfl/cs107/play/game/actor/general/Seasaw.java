package ch.epfl.cs107.play.game.actor.general;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Seasaw extends GameEntity implements Actor {
private Plank plank;
private Vector position;
private float blockHeight;
private float blockWidth;
private float plankWidth;
private float plankHeight;
private String plankGraphics;
private Entity body = getEntity();
private Polygon polygon;
private BasicContactListener contactListener;
private Color plankInnerColor;
private Color plankOuterColor;

	public Seasaw (ActorGame game, boolean fixed , Vector position , float blockWidth, float blockHeight, 
					float plankWidth, float plankHeight , Color plankInnerColor ,Color plankOuterColor) {
		super(game,fixed,position);
		this.position = position;
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
		this.plankWidth = plankWidth;
		this.plankHeight = plankHeight;
		this.plankGraphics = plankGraphics;
		this.plankOuterColor = plankOuterColor;
		this.plankInnerColor = plankInnerColor;
		
		if(blockWidth <= 0 || blockHeight <= 0 || plankWidth <= 0 || plankHeight <= 0) {
			throw new IllegalArgumentException("Parametre invalide");
		}
		
		PartBuilder partBuilder = body.createPartBuilder();
		Polygon polygon = new Polygon (
				new Vector (0.0f, 0.0f),
				new Vector (blockWidth, 0.0f),
				new Vector (blockWidth,blockHeight),
				new Vector (0.0f, blockHeight)
				) ;
		
			partBuilder.setShape(polygon);
			partBuilder.build();
			
			
			
			
			//finetuning
			
			Vector plankPos = position.add(2.5f,1.8f);
			
			plank = new Plank(this.getOwner(),false,plankPos,plankWidth,plankHeight,plankInnerColor,plankOuterColor);
			
			plank.attach(body,blockWidth,blockHeight);
			
			
		
			
	}
	
		
	

		@Override
		public Transform getTransform() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void draw(Canvas canvas) {
			
			plank.draw(canvas);
			
			
		}
		
}
