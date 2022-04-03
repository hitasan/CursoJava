package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

public class MainViewController implements Initializable {

	// Atributos da Classe
	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;
	
	// Metodos de ação/Eventos da tela
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction click");
	}
	
	@FXML
	public void onMenuItemDepartmentAction() {
		loadView("/gui/DepartmentList.fxml", (DepartmentListController ctrl) -> {
					ctrl.setDepartmentService(new DepartmentService());
					ctrl.updateTableView();
				});		// Modo com segundo parametro LAMBDA com uma função para inicializar o controlador departmentListController  
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml", x -> {});
	}
	
	// Demais Metodos	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
	}
	
	
	// Função para abrir outra tela
	private synchronized <T> void loadView(String absoluteName, Consumer<T> initAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			// Mostrar essa view dentro da janela MDI principal
			Scene mainScene = Main.getMainScene();	// Pegando a scene da tela principal
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();	// Root pega o primeiro elemento da minha view
			
			Node mainMenu = mainVBox.getChildren().get(0);	// Pegando o primeiro filho do VBOX da tela principal
			mainVBox.getChildren().clear();		// Limpando todos os filhos do mainVBox
			
			mainVBox.getChildren().add(mainMenu);					// Adiciona o menu do VBOX principal
			mainVBox.getChildren().addAll(newVBox.getChildren());	// Adiciona os filhos do Vbox About
			
			// Essas 2 linhas executará um que esta vindo no segudno parametro da função
			T ctrl = loader.getController();	// getController retorna um departmentLisControler que é o especificado via parametro
			initAction.accept(ctrl);
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro carregando a tela", e.getMessage(), AlertType.ERROR);
		}
	}
}
