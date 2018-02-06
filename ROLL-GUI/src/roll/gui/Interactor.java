package roll.gui;

import com.sun.media.jfxmediaimpl.platform.Platform;

import javafx.stage.Stage;

public class Interactor {
	private int testNum;
	public Interactor() {
		this.testNum = 10;
	}
	
	public void testFunc(Stage stage) {
		stage.close();
	}
	
	 
}
