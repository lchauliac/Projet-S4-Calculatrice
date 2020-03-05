package application;
	
import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			/*
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/vue/Sample.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
			
			FXMLLoader loader = new FXMLLoader();
			URL url = new File("src/vue/Sample.fxml").toURI().toURL();
			loader.setLocation(url);
			System.out.println(loader.getLocation());
			AnchorPane root = new AnchorPane(); 
			loader.setRoot(root);
			root=loader.load();
	     	Scene scene = new Scene(root,450,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
