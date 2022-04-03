package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {

	// Entidas da classe - Serão associados aos objetos da tela
	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn<Department, Integer> tableColumnId; 
	@FXML
	private TableColumn<Department, String> tableColumnName;
	@FXML
	private Button btNew;
	
	// Metodo para tratamento de eventos do click do botao NEW
	@FXML
	public void onBtNewAction() {
		System.out.println("Clicou no botão NEW");
	}
	
	// Metodo inicializador
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		// Padrao do JavaFX para iniciar o comportamento das colunas
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("ID"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("NAME"));
		
		// Tratamento para tableView completar a altura da janela
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}

}
