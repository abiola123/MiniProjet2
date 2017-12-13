package ch.epfl.cs107.play.game.actor;

import java.util.ArrayList;

import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.game.actor.general.Trigger;
import ch.epfl.cs107.play.math.ContactListener;
import ch.epfl.cs107.play.math.Node;
import ch.epfl.cs107.play.window.Canvas;


public abstract class Level extends Node implements Actor {

	protected ArrayList<Actor> localOperatingActorList = new ArrayList<Actor>();
	
	protected ArrayList<Trigger> triggerList = new ArrayList<Trigger>();
	protected ArrayList<Crate> cratesList = new ArrayList<Crate>();
	//dans bikeGame

	protected ArrayList<ContactListener> listenerList = new ArrayList<ContactListener>();
	private ActorGame game;




	public void createLevel() {
	
			
		}
		
	
	
	
	protected void setGame(BikeGame game) {
		this.game = game;
	}


	public void AddActors(Actor actor) {
		localOperatingActorList.add(actor);

	}
	


	public void AddTriggers(Trigger trigger) {
		triggerList.add(trigger);
	}

//	public void AddLevel(Level level) {
//		levelList.add(level);
//	}

	public void AddListener(ContactListener listener) {
		listenerList.add(listener);
	}

	protected void clearActorList() {
		localOperatingActorList.clear();
	}

	protected void clearListenerList() {
		listenerList.clear();
	}

	public void clearTriggerList() {
		triggerList.clear();
	}

	public void clearCrates() {
		for(int i = 0 ;i<cratesList.size();i++) {
			cratesList.get(i).destroy();
			cratesList.remove(i);
		}
		
		
	}
	
	public void clearEverything() {
		for(Actor actor: localOperatingActorList){
			game.actorListRemoveActor(actor);
		}
		clearCrates();
		clearListenerList();
		clearActorList();
		clearTriggerList();
		
		
	}
	
	public void triggerGotHit() {
		for(Trigger	 t: triggerList ) {
			if(t.gotHit()) {
				t.destroy();
				triggerList.remove(t);
			}
		}
	}


	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}



}