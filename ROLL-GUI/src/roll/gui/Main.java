package roll.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import netscape.javascript.JSObject;

public class Main extends Application {
	public JavaScriptBridge bridge;
	private double xOffset = 0;
	private double yOffset = 0;
    @Override
    public void start(Stage stage) throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("ROLL-GUI-border.fxml"));
    	stage.initStyle(StageStyle.DECORATED);
    	root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
    	root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
    	stage.setTitle("ROLL");
        BorderPane borderPane = new BorderPane();
        WebView webView = new WebView();
        //webpage of the interface
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
    //entrance of the interface
    public static void main(String[] args) {
        launch(args);
    }
}