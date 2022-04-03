package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Person;

public class ViewController implements Initializable {

	// Atributos da tela
	@FXML
	private ComboBox<Person> comboBoxPerson;
	// adicionado o combobox na tela e ele espera o tipo, nessa caso é do tipo person.
	// Por padrão o combobox utiliza o toString para listar os itens entao esse precisa sem ajustado para o modo que deverá ser apresentado as informações ou usar o callback disponivel no initialize
	
	@FXML
	private Button btAll;
	
	private ObservableList<Person> obsList;	// tipo especial de lista que fica associado ao componente visual
	
	@FXML
	public void onComboBoxPersonAction() {		// Ação de seleção do item do combobox
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
		System.out.println(person);	// imprimindo os dados com o tostring da classe PERSON
	}
	
	@FXML
	public void onBtAllAction() {	// Função para percorrer os itens de um combobox
		for (Person person : comboBoxPerson.getItems()) {
			System.out.println(person);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// Criando uma lista normal
		List<Person> list = new ArrayList<>();

		// Adicionando os itens na lista. Cada item esta adicionando um obj instanciando uma PERSON
		list.add(new Person(1, "Maria", "maria@gmail.com"));
		list.add(new Person(2, "Alex", "alex@gmail.com"));
		list.add(new Person(3, "Box", "bob@gmail.com"));
		
		// Instanciando o ObsList usando os itens da lista acima
		obsList = FXCollections.observableArrayList(list);
		comboBoxPerson.setItems(obsList);	// Associando o combobox com o ObsList que tem os itens
		
		
		// Metodo para ajuste de como apresentar as informações no combobox para não ajustar o toString
		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
		    @Override
		    protected void updateItem(Person item, boolean empty) {
		        super.updateItem(item, empty);
		        setText(empty ? "" : item.getName());
		    }
		};
		comboBoxPerson.setCellFactory(factory);
		comboBoxPerson.setButtonCell(factory.call(null));
	}
}
