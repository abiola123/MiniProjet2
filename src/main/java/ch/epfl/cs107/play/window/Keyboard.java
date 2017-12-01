package ch.epfl.cs107.play.window;
import java.util.Scanner;

/**
 * Represents the keyboard.
 */
public interface Keyboard {

	Scanner keyb = new Scanner(System.in);
	
	
    // TODO put int constants here, instead of using KeyEvent directly?
    
    public Button get(int code);
    
}
