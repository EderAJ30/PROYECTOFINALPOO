package fes.aragon.inicio;
	
import fes.aragon.extras.MusicaCiclica;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
    private static Main instancia=new Main();
    @Override
     
	public void start(Stage primaryStage) {
		try { 
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/Principal.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/fes/aragon/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	public static Main getMain() {
		return instancia;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

