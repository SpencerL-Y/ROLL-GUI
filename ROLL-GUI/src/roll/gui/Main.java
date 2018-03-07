package roll.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class Main extends Application {
	public static JavaScriptBridge bridge;
    @Override
    public void start(Stage stage) throws Exception {
    	
        BorderPane borderPane = new BorderPane();
        WebView webView = new WebView();
        String url = getClass().getResource("index.html").toExternalForm();
        System.out.println(url);
        webView.getEngine().load(url);
        borderPane.setCenter(webView);
        final Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setHeight(768);
        stage.setWidth(1024);
        stage.show();
        
        JSObject window = (JSObject) webView.getEngine().executeScript("window");
        bridge = new JavaScriptBridge();
        window.setMember("app", bridge);
    }

    public static void main(String[] args) {
        launch(args);
    }
}