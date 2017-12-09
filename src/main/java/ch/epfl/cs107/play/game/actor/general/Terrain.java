package ch.epfl.cs107.play.game.actor.general;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;


public class Terrain extends GameEntity implements Actor {

	//private GameEntity gameEntity;
	//private Actor actor;
	//private boolean fixed;
	private Entity line1 = getEntity();
	private Entity line2 = getEntity();
	private Entity line3 = getEntity();
	
	private ShapeGraphics lineGraphics1;
	private ShapeGraphics lineGraphics2;
	private ShapeGraphics lineGraphics3;
	private Float[][] coordinatesLine;
	//----------------------------------------------------------------------

		public Terrain(ActorGame game, boolean fixed, Vector position) {
			
			super(game,fixed,position);
			
			
			//Ya t-il un moyen plus facile de declarer les polylines ? assez chiant comme ca a chaque fois 
			PartBuilder partBuilder = line1.createPartBuilder();
			Polyline polyline1 = new Polyline(
//					for ( int i = 0 ; i<coordinatesLine.length; i++) {
//						for ( int j = 0 ; j<coordinatesLine[0].length; i++) {
//							
//						}
//						vectorList[i];
//					}
					-1000.0f ,  -1000.0f,
					-1000.0f ,   0.0f,
					0.0f     , 	 0.0f,
					3.0f     , 	 1.0f,
					8.0f     , 	 1.0f,
					15.0f    , 	 3.0f,
					16.0f    , 	 3.0f,
					25.0f    , 	 0.0f,
					35.0f    , 	-5.0f
					);
			
			PartBuilder partBuilder2 = line2.createPartBuilder();
			Polyline polyline2 = new Polyline(
					35.0f    , 	-5.0f,
					55.0f    , 	-4.0f,
					65.0f    ,	 0.0f,
					80.0f    ,   5.0f,
					85.0f	 ,	 4.0f,
					87.5f    ,   6f
					);
			
					
			PartBuilder partBuilder3 = line3.createPartBuilder();
			Polyline polyline3 = new Polyline(
					90.0f    ,   5.0f,
					102.5f    ,   3.0f,
					124.0f    ,   0.0f,
					145.0f   ,  -10.0f,
					170.0f   ,  -30.0f,
					210.0f   ,   -10.f,
					6500.0f  , 	-1000.0f
					);
			partBuilder.setShape(polyline1);
			partBuilder.setFriction(1);
			partBuilder.build();
			
			partBuilder.setShape(polyline2);
			partBuilder.setFriction(0.7f);
			partBuilder.build();
			
			partBuilder.setShape(polyline3);
			partBuilder.setFriction(1);
			partBuilder.build();
			
			lineGraphics1 = new ShapeGraphics(polyline1,null,Color.WHITE,.1f,1.f,0);
			lineGraphics1.setParent(line1);
			
			lineGraphics2 = new ShapeGraphics(polyline2,null,Color.GREEN,.1f,1.f,0);
			lineGraphics2.setParent(line2);
			
			lineGraphics3 = new ShapeGraphics(polyline3,null,Color.WHITE,.1f,1.f,0);
			lineGraphics3.setParent(line3);
		}
		
	
	//---------------------------------------------------------------------------
		
		// les returns sont correctes ???
		@Override
		public Transform getTransform() {
			// TODO Auto-generated method stub
			return getTransform();
		}
		
		//------------------------------------------------------------------

		@Override
		public void draw(Canvas canvas) {
		lineGraphics1.draw(canvas);
		lineGraphics2.draw(canvas);
		lineGraphics3.draw(canvas);
		}
		
		//vu que c'est une ligne fixe on ne devrait pas avoir besoin du velocity ?
		
//		public Vector getVelocity() {
//			
//			return null;
			
	}



