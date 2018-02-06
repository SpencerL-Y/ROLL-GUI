package roll.gui;

import javafx.application.Platform;
import javafx.scene.layout.Region;

public class JavaScriptBridge extends Region {
	public void callback(String data) {
		Platform.exit();
	}
	
	public void testFunction(String input) {
		System.out.println(input);
	}
	
	public String getStringFromJava() {
		return "This is a string from java";
	}
}
