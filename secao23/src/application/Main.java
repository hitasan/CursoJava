package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Scene mainScene;	// Especificando a cena como static no inicio para ter acesso em outra classes
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			ScrollPane sp = loader.load();	// Alterado de parent para scrollpane
			
			sp.setFitToHeight(true);	// Especificado o SP completando a tela
			sp.setFitToWidth(true);
			
			mainScene = new Scene(sp);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Modelo de Aplicação JavaFX");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Como o mainScene é private, precisamos criar esse metodo get para ter o acesso
	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
