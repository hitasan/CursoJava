package gui;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import db.DbIntegrityException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Seller;
import model.services.SellerService;

public class SellerListController implements Initializable, DataChangeListener {

	// Declaração de dependencia com o service e a instanciação nao será usada para
	// usar o metodo set para injeção de dependencia
	private SellerService service;

	// Entidas da classe - Serão associados aos objetos da tela
	@FXML
	private TableView<Seller> tableViewSeller;
	@FXML
	private TableColumn<Seller, Integer> tableColumnId;
	@FXML
	private TableColumn<Seller, String> tableColumnName;
	@FXML
	private TableColumn<Seller, Seller> tableColumnEDIT;
	@FXML
	private TableColumn<Seller, Seller> tableColumnREMOVE;

	@FXML
	private Button btNew;

	private ObservableList<Seller> obsList;

	// Metodo para tratamento de eventos do click do botao NEW
	@FXML
	public void onBtNewAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		Seller obj = new Seller();
		createDialogForm(obj, "/gui/SellerForm.fxml", parentStage);
	}

	// Metodo SET para adicionar o serviço e evitar o acoplamento
	public void setSellerService(SellerService service) {
		this.service = service;
	}

	// Metodo inicializador
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		// Padrao do JavaFX para iniciar o comportamento das colunas
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

		// Tratamento para tableView completar a altura da janela
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewSeller.prefHeightProperty().bind(stage.heightProperty());
	}

	// Metodo responsavel por acessar o serviço, carregar os departamentos e jogar
	// os departamentos na observableList e esse será associado a tableView
	public void updateTableView() {
		if (service == null) {
			throw new IllegalThreadStateException("Service está nulo");
		}

		// Listando os departamentos listados
		List<Seller> list = service.findAll();

		// Carregando a lista dentro do observableList
		obsList = FXCollections.observableArrayList(list);

		// Associando o observableList no tableViewSeller
		tableViewSeller.setItems(obsList);

		initEditButtons(); 		// Adiciona um botao EDIT em cada linha do grid
		initRemoveButtons(); 	// Adiciona um botão REMOVE em cada linha do grid
	}

	private void createDialogForm(Seller obj, String absoluteName, Stage parentStage) {
//		try {
//			// Logica para abertura da janela de formulario
//			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
//			Pane pane = loader.load();
//
//			SellerFormController controller = loader.getController(); // Pegando o controlador da tela carregada na
//																			// linha acima
//			controller.setSeller(obj); // injetando o department no controller
//			controller.setSellerService(new SellerService()); // injetando o departmentService no controller
//			controller.subscribeDataChangeListener(this);
//			controller.updateFormData(); // Carregando os dados do controller na formulario
//
//			Stage dialogStage = new Stage();
//			dialogStage.setTitle("Enter Seller data");
//			dialogStage.setScene(new Scene(pane));
//			dialogStage.setResizable(false);
//			dialogStage.initOwner(parentStage);
//			dialogStage.initModality(Modality.WINDOW_MODAL); // Especifica que enquanto nao for fechada nao pode acessar
//																// a tela anterior
//			dialogStage.showAndWait();
//
//		} catch (IOException e) {
//			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
//		}
	}

	@Override
	public void onDataChanged() {
		updateTableView();
	}

	// Responsavel por criar um botão de edição em cada linha da minha tabela
	private void initEditButtons() {
		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEDIT.setCellFactory(param -> new TableCell<Seller, Seller>() {
			private final Button button = new Button("edit");

			@Override
			protected void updateItem(Seller obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> createDialogForm(obj, "/gui/SellerForm.fxml", Utils.currentStage(event)));
			}
		});
	}

	// Responsavel por criar um botao REMOVE em cada linha para excluir o registro
	private void initRemoveButtons() {
		tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnREMOVE.setCellFactory(param -> new TableCell<Seller, Seller>() {
			private final Button button = new Button("remove");

			@Override
			protected void updateItem(Seller obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> removeEntity(obj));
			}
		});
	}
	
	private void removeEntity(Seller obj) {
		Optional<ButtonType> result = Alerts.showConfirmation("Confirmação", "Tem certeza que deseja excluir?");	// Mostra a mensagem e pega o resultado na variavel result
		if (result.get() == ButtonType.OK) {
			if (service == null) {	// Se for nulo o dev esqueceu de injetar o service
				throw new IllegalStateException("Service está nulo");
			}
			
			try {
				service.remove(obj);	// função para remover
				updateTableView();		// Forçar atualizar os dados da tabela
			}
			catch (DbIntegrityException e) {
				Alerts.showAlert("Erro removendo objeto", null, e.getMessage(), AlertType.ERROR);
			}
		}
		
	}

}
