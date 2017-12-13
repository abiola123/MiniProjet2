package ch.epfl.cs107.play.game.actor;

import java.awt.Color;
import java.util.ArrayList;

import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Window;

public class GameLauncher extends ActorGame {
private Window window;
private FileSystem fileSystem;
private TextGraphics message_up;
private TextGraphics message_down;
private ArrayList<Level> levelList = new ArrayList<>();
levelList.add(new BikeGameLevel1(this));

	public boolean begin(Window window, FileSystem fileSystem) {
		super.begin(window, fileSystem);
		this.window = window;
		this.fileSystem = fileSystem;
		
		
		
		levelList.get(0).createLevel();

		message_up = new TextGraphics("", .4f, Color.WHITE, Color.GRAY, 0.02f, true,
				false, new Vector(0.5f,-1.5f), 1.0f, 2.0f);
		message_down = new TextGraphics("", .4f, Color.WHITE, Color.GRAY, 0.02f, true,
				false, new Vector(0.5f,-1.5f), 1.0f, 2.0f);

		message_up.setText("START!");
		message_up.setParent(getCanvas());
		message_up.draw(getCanvas());
		message_down.setText("");
		message_down.setParent(getCanvas());
		message_down.draw(getCanvas());
		
		return true;
	}
	
	public void update(float deltaTime) {
		setViewCandidate(levelList.get(levelNb)getBike());
		super.update(deltaTime);
		
		//levels.get(levelNb).clearEverything
		//TODO: check si finish touche
		//TODO: if levelNb = 0 --> nextlevel()
		//TODO: if levelNb = 1 --> end()
		//TODO: win = true
		
		//TODO: reset --> remove all, create all
		//TODO: nextlevel--> removeall, levelNb++, createAll		
		@Override
//		public void update(float deltaTime ) {
//			setViewCandidate(bike);
//			super.update(deltaTime);
	//
	//
//			setHit();
	//
//			// delayer
//			timeSinceStart += deltaTime;
//			if(timeSinceStart < 1f) {
//				message_up.setText("START");
//				message_up.setParent(getCanvas());
//				message_up.draw(getCanvas());
//			} else {
//				message_up.setText("");
//				message_up.draw(getCanvas());
//			}
	//
//			if (bike.wasHit()) {
//				endingMessage("YOU LOSE", "PRESS R TO TRY AGAIN");
//				if(timeSinceEnd < 5f) {
//					timeSinceEnd += deltaTime;
//				} else {
//					endingMessage("","");
//					end();
//				}
//			}
	//
//			if (hasHit && collectedKeys >= 10) {
//				bike.setHandLocation();
//				finishLine.setFinishGraphics("flag.green.png");
//				endingMessage("YOU WIN", "PRESS R TO TRY AGAIN");
//				if(timeSinceEnd < 5f) {
//					timeSinceEnd += deltaTime;
//				} else {
//					end();
//				}
	//
//			} else if (hasHit && collectedKeys < 10) {
//				endingMessage("OH NO", "You didn't collect all 10 keys");
//				if(timeSinceEnd < 3f) {
//					timeSinceEnd += deltaTime;
//				} else {
//					hasHit = false;
//					endingMessage("","");
//				}
//			}
	//
	//
	//
//			if(collectedKeys==10) {
//				finishLine.setFinishGraphics("door.open.png");
//			}
	//
	//
	//
//			//--------------ContactListeners----------------------
	//
//			if(contactListenerWell.hasContactWith(bike.getEntity())) {
//				//			bike.getEntity().applyForce(new Vector(362.5f,11f), new Vector(362.5f,-0f));
	//
//				setWellGravity(new Vector(0,4f));
//			}else {
//				setWellGravity(new Vector(0,-9.81f));
//			}
	//
	//
//			//----------------KEYS---------------------------------
	//
//			if(key1.gotHit()) {
//				this.getOperatingActor().remove(key1);
//				key1.destroy();
//				collectedKeys++;
//				key1.setGotHit(false);
	//
//			}
	//
//			if(key2.gotHit()) {
//				this.getOperatingActor().remove(key2);
//				key2.destroy();
//				collectedKeys++;
//				key2.setGotHit(false);
	//
//			}
	//
//			if(key3.gotHit()) {
//				this.getOperatingActor().remove(key3);
//				key3.destroy();
//				collectedKeys++;
//				key3.setGotHit(false);
	//
//			}
	//
//			if(key4.gotHit()) {
//				this.getOperatingActor().remove(key4);
//				key4.destroy();
//				collectedKeys++;
//				key4.setGotHit(false);
	//
//			}
	//
//			if(key5.gotHit()) {
//				this.getOperatingActor().remove(key5);
//				key5.destroy();
//				collectedKeys++;
//				key5.setGotHit(false);
//			}
	//
//			if(key6.gotHit()) {
//				this.getOperatingActor().remove(key6);
//				key6.destroy();
//				collectedKeys++;
//				key6.setGotHit(false);
//			}
	//
//			if(key7.gotHit()) {
//				this.getOperatingActor().remove(key7);
//				key7.destroy();
//				collectedKeys++;
//				key7.setGotHit(false);
	//
//			}
	//
//			if(key8.gotHit()) {
//				this.getOperatingActor().remove(key8);
//				key8.destroy();
//				collectedKeys++;
//				key8.setGotHit(false);
//			}
	//
//			if(key9.gotHit()) {
//				this.getOperatingActor().remove(key9);
//				key9.destroy();
//				collectedKeys++;
//				key9.setGotHit(false);
//			}
	//
//			if(key10.gotHit()) {
//				this.getOperatingActor().remove(key10);
//				key10.destroy();
//				collectedKeys++;
//				key10.setGotHit(false);
//			}
//			if(collectedKeys >10) {
//				collectedKeys = 10;
//			}
//			keysCounter.setText(collectedKeys + "/10");
//			keysCounter.setParent(getCanvas());
//			keysCounter.draw(getCanvas());
	//
	//
	//
//			//checkpoint
//			if(checkPoint1.gotHit()) {
//				checkPoint1.setGotHit(true);
//				checkPoint1.setTriggerGraphics("flag.green.png");
//				startingPosition = checkPointPosition;
//			}
	//
//		}
		
	}
	
	
		
}
	}
	
}
