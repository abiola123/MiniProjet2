package ch.epfl.cs107.play.game.actor.general;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

//creates all the polylines forming the terrain
public class Terrain extends GameEntity implements Actor {

	private Entity line1 = getEntity();
	private Entity line2 = getEntity();
	private Entity line3 = getEntity();
	private Entity line4 = getEntity();
	private Entity line5 = getEntity();
	private Entity line6 = getEntity();
	private Entity line7 = getEntity();
	private Entity line8 = getEntity();
	private Entity line9 = getEntity();
	private Entity line10 = getEntity();
	private Entity line11 = getEntity();
	private Entity line12 = getEntity();
	private Entity line13 = getEntity();
	private Entity line14 = getEntity();


	private Entity poly2 = getEntity();
	private Entity poly3 = getEntity();
	private Entity poly4 = getEntity();
	private Entity poly5 = getEntity();
	private Entity poly6 = getEntity();
	private Entity poly7 = getEntity();
	private Entity poly8 = getEntity();
	private Entity poly9 = getEntity();
	private Entity poly10 = getEntity();
	private Entity poly1 = getEntity(); 
	private Entity poly11 = getEntity();
	
	private ShapeGraphics line1Graphics;
	private ShapeGraphics line2Graphics;
	private ShapeGraphics line3Graphics;
	private ShapeGraphics line4Graphics;
	private ShapeGraphics line5Graphics;
	private ShapeGraphics line6Graphics;
	private ShapeGraphics line7Graphics;
	private ShapeGraphics line8Graphics;
	private ShapeGraphics line9Graphics;
	private ShapeGraphics line10Graphics;
	private ShapeGraphics line11Graphics;
	private ShapeGraphics line12Graphics;

	private ShapeGraphics polygon1Graphics;
	private ShapeGraphics polygon2Graphics;
	private ShapeGraphics polygon3Graphics;
	private ShapeGraphics polygon4Graphics;
	private ShapeGraphics polygon5Graphics;
	private ShapeGraphics polygon6Graphics;
	private ShapeGraphics polygon7Graphics;
	private ShapeGraphics polygon8Graphics;

	//	----------------------------------------------------------------------

	public Terrain(ActorGame game, boolean fixed, Vector position) {

		super(game,fixed,position);


		PartBuilder partBuilder1 = poly1.createPartBuilder();
		Polyline polyline1 = new Polyline (
				0f , 50f,	
				0f , 0f,
				20.0f,			 0f,
				25f     , 	 	 1.5f,
				38.0f     ,  	 7.0f,
				42.0f    , 	 	 9.0f,
				48.0f    , 	 	 13.0f,
				50f      ,   	 13.0f,
				65f      ,   	 6.5f,
				80f   	,    	 0.0f
				);


		createPolyline(polyline1,line1,1.0f,partBuilder1 );
		line1Graphics = new ShapeGraphics(polyline1,null,Color.WHITE,.1f,1.f,0);
		line1Graphics.setParent(line1);




		PartBuilder partBuilder2 = poly1.createPartBuilder();
		Polygon polygon1 = new Polygon (
				90f, -10f,
				90f, -12f,
				110f,  -12f,
				110f, -10f
				);

		createPolygon(polygon1,poly1,2.0f,partBuilder2 );
		polygon1Graphics = new ShapeGraphics(polygon1,Color.GRAY,Color.WHITE,.1f,1.f,0);
		polygon1Graphics.setParent(poly1);



		PartBuilder partBuilder3 = poly2.createPartBuilder();
		Polygon polygon2 = new Polygon (
				115f, -15f,
				115f, -17f,
				135f, -17f,
				135f,  -15f
				);

		createPolygon(polygon2,poly2,1.0f,partBuilder3 );
		polygon2Graphics = new ShapeGraphics(polygon2,Color.GRAY,Color.WHITE,.1f,1.f,0);
		polygon2Graphics.setParent(poly2);


		PartBuilder partBuilder4 = poly3.createPartBuilder();
		Polygon polygon3 = new Polygon (
				140f, -20f,
				140f, -22f,
				170f, -22f,
				170f,  -20f	
				);

		createPolygon(polygon3,poly3,1.0f,partBuilder4 );
		polygon3Graphics = new ShapeGraphics(polygon3,Color.GRAY,Color.WHITE,.1f,1.f,0);
		polygon3Graphics.setParent(poly3);


		PartBuilder partBuilder5 = poly2.createPartBuilder();
		Polyline polyline2 = new Polyline (
				170f, -20f,
				172f, -19f,
				173f, -18.5f
				);

		createPolyline(polyline2,line2,1.0f,partBuilder5 );
		line2Graphics = new ShapeGraphics(polyline2,null,Color.WHITE,.1f,1.f,0);
		line2Graphics.setParent(line2);


		PartBuilder partBuilder6 = poly3.createPartBuilder();
		Polyline polyline3 = new Polyline (
				180f, -18f,
				192f, -10f,
				200f,  0f					
				);

		createPolyline(polyline3,line3,0.7f,partBuilder6 );
		line3Graphics = new ShapeGraphics(polyline3,null,Color.CYAN,.1f,1.f,0);
		line3Graphics.setParent(line3);


		PartBuilder partBuilder7 = poly4.createPartBuilder();
		Polyline polyline4 = new Polyline (
				200f , 0f,	
				230f, 0f,
				230f, -7f,
				250f, -7f,
				250f, 0f
				);


		createPolyline(polyline4,line4,1.0f,partBuilder7 );
		line4Graphics = new ShapeGraphics(polyline4,null,Color.WHITE,.1f,1.f,0);
		line4Graphics.setParent(line4);


		PartBuilder partBuilder8 = poly5.createPartBuilder();
		Polyline polyline5 = new Polyline (
				230f , 0f,	
				231f, 1f,
				232f, 2f,
				232.5f, 2.5f
				);


		createPolyline(polyline5,line5,1.0f,partBuilder8 );
		line5Graphics = new ShapeGraphics(polyline5,null,Color.WHITE,.1f,1.f,0);
		line5Graphics.setParent(line5);

		PartBuilder partBuilder9 = poly6.createPartBuilder();
		Polyline polyline6 = new Polyline (
				247f , 0f,	
				250f, 0f,
				270f, -5f,
				280f, -5f
				);


		createPolyline(polyline6,line6,1.0f,partBuilder9 );
		line6Graphics = new ShapeGraphics(polyline6,null,Color.WHITE,.1f,1.f,0);


		PartBuilder partBuilder10 = poly7.createPartBuilder();
		Polyline polyline7 = new Polyline (
				290f, -7f,
				295f,  -8f,
				296f,  -9f,
				297f,  -10f,
				298f,  -11f,
				299f,  -12f, 
				300f,   -13f,
				301f,   -14f,
				302f,   -15f,
				303f,   -16f,
				304f,   -17f,
				305f,   -18f,
				306f,   -19f,
				307f,   -19.5f,
				308f,    -19.6f,
				309f,    -19.8f,
				310f,    -19.7f,
				311f,     -19.6f,
				312f,     -19.5f,
				313f,     -19f,
				345f,      -11f	
				);


		createPolyline(polyline7,line7,1.0f,partBuilder9 );
		line7Graphics = new ShapeGraphics(polyline7,null,Color.WHITE,.1f,1.f,0);
		line7Graphics.setParent(line7);



		PartBuilder partBuilder11 = poly8.createPartBuilder();
		Polyline polyline8 = new Polyline (
				297f,  -8f+8f,
				297f,  -9f+5f,
				297f,  -10f+5f,
				298f,  -11f+5f,
				299f,  -12f+5f,
				300f,   -13f +5f,
				301f,   -14f  +5f,
				302f,   -15f  +5f,
				303f,   -16f  +5f,
				304f,   -17f  +5f,
				305f,   -18f   +5f,
				306f,   -19f   +5f,
				307f,   -19.5f  +5f,
				308f,    -19.6f  +5f,
				309f,    -19.8f +5f,
				310f,    -19.7f +5f,
				311f,     -19.6f +5f,
				312f,     -19.5f +5f,
				313f,     -19f +5f,
				345f,      -11f +5f				
				);


		createPolyline(polyline8,line8,1.0f,partBuilder11 );
		line8Graphics = new ShapeGraphics(polyline8,null,Color.WHITE,.1f,1.f,0);
		line8Graphics.setParent(line8);


		PartBuilder partBuilder12 = poly9.createPartBuilder();
		Polyline polyline9 = new Polyline (
				395f,30f,
				400f,30f,
				460f,30f,
				480f,35f,
				500f,35f,
				500f,40f
				);


		createPolyline(polyline9,line9,1.0f,partBuilder12 );
		line9Graphics = new ShapeGraphics(polyline9,null,Color.WHITE,.1f,1.f,0);
		line9Graphics.setParent(line9);

		PartBuilder partBuilder13 = poly10.createPartBuilder();
		Polyline polyline10 = new Polyline(

				15, -45,
				20, -50,
				25, -45,
				30, -50,
				35, -45,
				40, -50,
				45, -45,
				50, -50,
				55, -45,
				60, -50,
				65, -45,
				70, -50,
				75, -45,
				80, -50,
				85, -45,
				90, -50,
				95, -45,
				100, -50,
				105, -45,
				110, -50,
				115, -45,
				120, -50,
				125, -45,
				130, -50,
				135, -45,
				140, -50,
				145, -45,
				150, -50,
				155, -45,
				160, -50,
				165, -45,
				170, -50,
				175, -45,
				180, -50,
				185, -45,
				190, -50,
				195, -45,
				200, -50,
				205, -45,
				210, -50,
				215, -45,
				220, -50,
				225, -45,
				230, -50,
				235, -45,
				240, -50,
				245, -45,
				250, -50,
				255, -45,
				260, -50,
				265, -45,
				270, -50,
				275, -45,
				280, -50,
				285, -45,
				290, -50,
				295, -45,
				300, -50,
				305, -45,
				310, -50,
				315, -45,
				320, -50,
				325, -45,
				330, -50,
				335, -45,
				340, -50,
				345, -45,
				350, -50,
				355, -45,
				360, -50,
				365, -45,
				370, -50,
				375, -45,
				380, -50,
				385, -45,
				390, -50,
				395, -45,
				400, -50,
				405, -45,
				410, -50,
				415, -45,
				420, -50,
				425, -45,
				430, -50,
				435, -45,
				440, -50,
				445, -45,
				450, -50,
				455, -45,
				460, -50,
				465, -45,
				470, -50,
				475, -45,
				480, -50,
				485, -45,
				490, -50,
				495, -45,
				500, -50
				);
		createPolyline(polyline10,line10,1.0f,partBuilder13 );
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
		line1Graphics.draw(canvas);
		line2Graphics.draw(canvas);
		line3Graphics.draw(canvas);
		line4Graphics.draw(canvas);
		line5Graphics.draw(canvas);
		line6Graphics.draw(canvas);
		line7Graphics.draw(canvas);
		line8Graphics.draw(canvas);
		line9Graphics.draw(canvas);
		polygon1Graphics.draw(canvas);
		polygon2Graphics.draw(canvas);
		polygon3Graphics.draw(canvas);
	}

}



