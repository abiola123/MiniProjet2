package ch.epfl.cs107.play.game.actor.general;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.Crate;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class CrateField extends GameEntity implements Actor {
	private Crate crate1 ,crate2 ,crate3 ,crate4 ,crate5 ,crate6 ,crate7 ,crate8 ,crate9 ,crate10 ,crate11 ,crate12 ,crate13 ,crate14 ,crate15 ,crate16 ,crate17 ,crate18 ,crate19 ,crate20 ,crate21 ,crate22 ,crate23 ,crate24 ,crate25 ,crate26 ,crate27,
	crate28 ,crate29 ,crate30 ,crate31 ,crate32 ,crate33 ,crate34 ,crate35 ,crate36 ,crate37 ,crate38 ,crate39 ,crate40 ,crate41 ,crate42 ,crate43 ,crate44 ,crate45 ,crate46 ,crate47 ,crate48 ,crate49 ,crate50 ;
	






	public CrateField(ActorGame game, boolean fixed, Vector position) {
		super(game,fixed,position);







		//the only solution was to create all the crates separately :(
		
		crate1 = new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate2 = new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate3 = new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate4 = new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate5 = new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate6 = new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate7 = new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate8 = new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate9 = new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate10= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate11= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate12= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate13= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate14= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate15= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate16= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate17= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate18= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate19= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate20= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate21= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate22= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate23= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate24= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate25= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate26= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate27= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate28= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate29= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate30= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate31= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate32= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate33= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate34= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate35= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate36= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate37= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate38= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate39= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate40= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate41= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate42= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate43= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate44= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate45= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate46= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate47= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate48= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate49= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");
		crate50= new Crate(game,false,position,1.5f,1.5f,"crate.3.png");



	}


	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return getTransform();
	}

	@Override
	public void draw(Canvas canvas) {
		crate1.draw(canvas);
		crate2.draw(canvas);
		crate3.draw(canvas);
		crate4.draw(canvas);
		crate5.draw(canvas);
		crate6.draw(canvas);
		crate7.draw(canvas);
		crate8.draw(canvas);
		crate9.draw(canvas);
		crate10.draw(canvas);
		crate11.draw(canvas);
		crate12.draw(canvas);
		crate13.draw(canvas);
		crate14.draw(canvas);
		crate15.draw(canvas);
		crate16.draw(canvas);
		crate17.draw(canvas);
		crate18.draw(canvas);
		crate19.draw(canvas);
		crate19.draw(canvas);
		crate20.draw(canvas);
		crate21.draw(canvas);
		crate22.draw(canvas);
		crate23.draw(canvas);
		crate24.draw(canvas);
		crate25.draw(canvas);
		crate26.draw(canvas);
		crate27.draw(canvas);
		crate28.draw(canvas);
		crate29.draw(canvas);
		crate30.draw(canvas);
		crate31.draw(canvas);
		crate32.draw(canvas);
		crate33.draw(canvas);
		crate34.draw(canvas);
		crate35.draw(canvas);
		crate36.draw(canvas);
		crate37.draw(canvas);
		crate38.draw(canvas);
		crate39.draw(canvas);
		crate40.draw(canvas);
		crate41.draw(canvas);
		crate42.draw(canvas);
		crate43.draw(canvas);
		crate44.draw(canvas);
		crate45.draw(canvas);
		crate46.draw(canvas);
		crate47.draw(canvas);
		crate47.draw(canvas);
		crate48.draw(canvas);
		crate49.draw(canvas);
		crate50.draw(canvas);

	}
}
