package ch.epfl.cs107.play.game.actor.general;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;


public class Terrain2 extends GameEntity implements Actor {

	private Entity line1 = getEntity();
	private Entity line2 = getEntity();
	private Entity line3 = getEntity();
	private Entity line4 = getEntity();
	private Entity line5 = getEntity();
	private Entity line6 = getEntity();
	private Entity line7 = getEntity();
	
	private Entity polySpikes = getEntity();
	private Entity poly1 = getEntity();
	private Entity poly2 = getEntity();
	private Entity poly3 = getEntity();
	private Entity poly4 = getEntity();
	private Entity poly5 = getEntity();
	private Entity poly6 = getEntity();
	private Entity poly7 = getEntity();
 
	private Entity circle1 = getEntity();
	private Entity circle2 = getEntity();
	private Entity circle3 = getEntity();
	private Entity circle4 = getEntity();

	private ShapeGraphics line1Graphics;
	private ShapeGraphics lineSpGraphics;
	private ShapeGraphics line2Graphics;
	private ShapeGraphics line3Graphics;
	private ShapeGraphics line4Graphics;
	private ShapeGraphics line5Graphics;
	private ShapeGraphics line6Graphics;
	private ShapeGraphics line7Graphics;
	
	private ShapeGraphics circle1Graphics;
	private ShapeGraphics circle2Graphics;
	private ShapeGraphics circle3Graphics;
	private ShapeGraphics circle4Graphics;

	//		//----------------------------------------------------------------------

	public Terrain2(ActorGame game, boolean fixed, Vector position) {

		super(game,fixed,position);

		PartBuilder partBuilder1 = poly1.createPartBuilder();
		Polyline polyline1 = new Polyline (
				0f , -10f,	
				10f , -10f,
				40.0f, -20f,
				55f,-20f,
				55f,-50f,
				57f,-45f,
				59f,-50f,
				61f,-45f,
				63f,-50f,
				65f,-45f,
				67f,-50f,
				69f,-45f,
				71f,-50f,
				73f,-45f
				);


		createPolyline(polyline1,line1,1.0f,partBuilder1 );
		line1Graphics = new ShapeGraphics(polyline1,null,Color.WHITE,.1f,1.f,0);
		line1Graphics.setParent(line1);
		
		PartBuilder partBuilderSpikes = polySpikes.createPartBuilder();
		Polyline polylineSp = new Polyline (
				0f,-10f,
				-2f,-20f,
				-4f,-15f,
				-6f,-20f,
				-8f,-15f,
				-10f,-20f,
				-12f,-15f,
				-14f,-20f,
				-16f,-15f,
				-18f,-20f,
				-20f,-15f,
				-22f,-20f,
				-26f,-25f
				);


		createPolyline(polylineSp,polySpikes,1.0f,partBuilderSpikes );
		lineSpGraphics = new ShapeGraphics(polylineSp,null,Color.WHITE,.1f,1.f,0);
		lineSpGraphics.setParent(polySpikes);
		
		

		PartBuilder partBuilder2 = poly2.createPartBuilder();
		Polyline polyline2 = new Polyline (
				45f , 10f,	
				70f , 10f,
				75f, 5f
				);

		createPolyline(polyline2,line2,1.0f,partBuilder2 );
		line2Graphics = new ShapeGraphics(polyline2,null,Color.WHITE,.1f,1.f,0);
		line2Graphics.setParent(line2);


		PartBuilder partBuilder3 = poly3.createPartBuilder();
		Polyline polyline3 = new Polyline (
				65f , -13f,	
				80f , -13f,
				95f, -20f
				);

		createPolyline(polyline3,line3,1.0f,partBuilder3 );
		line3Graphics = new ShapeGraphics(polyline3,null,Color.WHITE,.1f,1.f,0);
		line3Graphics.setParent(line3);


		PartBuilder partBuilder4 = poly4.createPartBuilder();
		Polyline polyline4 = new Polyline (
				97f , -30f,	
				120f , -30f
				);

		createPolyline(polyline4,line4,1.0f,partBuilder4 );
		line4Graphics = new ShapeGraphics(polyline4,null,Color.WHITE,.1f,1.f,0);
		line4Graphics.setParent(line4);


		PartBuilder partBuilder5 = circle1.createPartBuilder();
		Circle circle1Shape = new Circle(3f, new Vector(88f,-37f));

		createCircle(circle1Shape, circle1, 1.0f, partBuilder5);

		circle1Graphics = new ShapeGraphics(circle1Shape,Color.WHITE,Color.WHITE,.1f,1.f,0);
		circle1Graphics.setParent(circle1);


		PartBuilder partBuilder6 = circle2.createPartBuilder();
		Circle circle2Shape = new Circle(3f, new Vector(76f,-45f));

		createCircle(circle2Shape, circle2, 1.0f, partBuilder6);

		circle2Graphics = new ShapeGraphics(circle2Shape,Color.WHITE,Color.WHITE,.2f,1.f,0);
		circle2Graphics.setParent(circle2);


		PartBuilder partBuilder7 = circle3.createPartBuilder();
		Circle circle3Shape = new Circle(4f, new Vector(87f,-53f));

		createCircle(circle3Shape, circle3, 1.0f, partBuilder7);

		circle3Graphics = new ShapeGraphics(circle3Shape,Color.WHITE,Color.WHITE,.4f,1.f,0);
		circle3Graphics.setParent(circle3);


		PartBuilder partBuilder8 = circle4.createPartBuilder();
		Circle circle4Shape = new Circle(9f, new Vector(81f,-70f));

		createCircle(circle4Shape, circle4, 1.0f, partBuilder8);

		circle4Graphics = new ShapeGraphics(circle4Shape,Color.WHITE,Color.WHITE,.5f,1.f,0);
		circle4Graphics.setParent(circle4);


		PartBuilder partBuilder9 = poly5.createPartBuilder();
		Polyline polyline5 = new Polyline (
				72f , -70f,	
				50f , -70f,
				0f, -60f
				);

		createPolyline(polyline5,line5,1.0f,partBuilder9 );
		line5Graphics = new ShapeGraphics(polyline5,null,Color.WHITE,.3f,1.f,0);
		line5Graphics.setParent(line5);
		
		
		PartBuilder partBuilder10 = poly6.createPartBuilder();
		Polyline polyline6 = new Polyline (
				-26f , -25f,	
				-50f , -25f,
				-50f, -80f,
				-45f, -85f,
				-35f,-85f				
				);

		createPolyline(polyline6,line6,1.0f,partBuilder10 );
		line6Graphics = new ShapeGraphics(polyline6,null,Color.WHITE,.1f,1.f,0);
		line6Graphics.setParent(line6);
		
		
		PartBuilder partBuilder11 = poly7.createPartBuilder();
		Polyline polyline7 = new Polyline (
				-12f , -88f,
				0f, -88f,
				0f, -82f
				);

		createPolyline(polyline7,line7,1.0f,partBuilder11 );
		line7Graphics = new ShapeGraphics(polyline7,null,Color.WHITE,.1f,1.f,0);
		line7Graphics.setParent(line7);

	}

	public void createCircle(Circle circle, Entity entity, float friction, PartBuilder partBuilder) {
		partBuilder.setShape(circle);
		partBuilder.setFriction(friction);
		partBuilder.build();	
	}

	public void createPolygon(Polygon polygon, Entity entity, float friction, PartBuilder partBuilder ) {
		partBuilder.setShape(polygon);
		partBuilder.setFriction(friction);
		partBuilder.build();

	}

	public void createPolyline(Polyline polyline, Entity entity, float friction, PartBuilder partBuilder ) {
		partBuilder.setShape(polyline);
		partBuilder.setFriction(friction);
		partBuilder.build();
	}
	
	//---------------------------------------------------------------------------

	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return getTransform();
	}

	//------------------------------------------------------------------

	@Override
	public void draw(Canvas canvas) {
		lineSpGraphics.draw(canvas);
		line1Graphics.draw(canvas);
		line2Graphics.draw(canvas);
		line3Graphics.draw(canvas);
		line4Graphics.draw(canvas);
		line5Graphics.draw(canvas);
		line6Graphics.draw(canvas);
		line7Graphics.draw(canvas);
		circle1Graphics.draw(canvas);
		circle2Graphics.draw(canvas);
		circle3Graphics.draw(canvas);
		circle4Graphics.draw(canvas);

	}
}