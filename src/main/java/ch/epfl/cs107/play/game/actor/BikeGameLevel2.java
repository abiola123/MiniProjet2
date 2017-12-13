package ch.epfl.cs107.play.game.actor;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.bike.Bike;
import ch.epfl.cs107.play.game.actor.general.Arrow;
import ch.epfl.cs107.play.game.actor.general.Finish;
import ch.epfl.cs107.play.game.actor.general.GravityWell;
import ch.epfl.cs107.play.game.actor.general.Seasaw;
import ch.epfl.cs107.play.game.actor.general.Terrain2;
import ch.epfl.cs107.play.game.actor.general.Trigger;
import ch.epfl.cs107.play.math.Vector;

public class BikeGameLevel2 extends Level {

	private int LEVEL = 1;
	
	//declaration
	private BikeGame game;
	
	public BikeGameLevel2(GameLauncher game) {
		setGame(game);
		this.game = game;
	}
	public void createAllActors() {
		
		//vecteur finish line a changer 
		private Vector finishLinePosition = new Vector(10.0f, 0f);
		private Vector terrainPosition = new Vector(0.0f,0.0f);
		private Vector v1 = (new Vector(0.0f, 5.0f));
		private Vector v2 = (new Vector(0.2f, 7.0f));
		private Vector v3 = (new Vector(2.0f, 6.0f));
		private Vector bikePosition =  (new Vector(40.0f,5.0f));
		
		
		public BikeGameLevel2(BikeGame2 game) {
			setGame(game);
		}
		
		public void createAllActros() {
		Terrain2 terrain2 = new Terrain2(game,true,terrainPosition);
		Bike bike = new Bike(game , false , bikePosition, 0.5f);
		GravityWell gravityWell = new GravityWell(game,true,new Vector(45,-20), 17, 30,Color.BLUE,Color.WHITE);
		GravityWell gravityWell2 = new GravityWell(game,true,new Vector(-50,-80), 40, 55,Color.BLUE,Color.WHITE );
		Seasaw seasaw = new Seasaw(game,true,new Vector(-28f,-88f),1,1,14,.3f,Color.WHITE, Color.CYAN);
		Seasaw seasaw2 = new Seasaw(game,true,new Vector(-20f,-92f),1,1,14,.3f,Color.WHITE, Color.CYAN);
		triggerList.add(new Finish(game, true, new Vector(-4f,-88f),"flag.red.png",1,1));
		triggerList.add(new Trigger(game,true,checkPointPosition,"flag.red.png",1f,1f));
		Arrow arrow = new Arrow(game, true, new Vector(47,-17), "arrow.white.png", 1f,1f);
		Arrow arrow2 = new Arrow(game, true, new Vector(52,-10), "arrow.white.png", 1f,1f);
		Arrow arrow3 = new Arrow(game, true, new Vector(57,-3), "arrow.white.png", 1f,1f);
		
		AddActors(terrain2);
		AddActors(bike);
		AddActors(gravityWell);
		AddActors(gravityWell2);
		AddActors(seasaw);
		AddActors(seasaw2);
		AddActors(arrow);
		AddActors(arrow2);
		AddActors(arrow3);
		for(Trigger trigger : triggerList) {
			AddActors(trigger);
			
		
		
	}
}
}