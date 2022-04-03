package secao13.model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	// Atributos da classe
	private Date moment;
	private OrderStatus status;
	
	private Client client;									// Composição onde 1 pedido tem 1 cliente
	private List<OrderItem> items = new ArrayList<OrderItem>();		// Composição onde 1 pedido tem N itens
	
	
	// Metodos Construtores
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		// A lista de itens não deve entrar no construtor pois já esta instanciada de forma vazia acima nos atributos da classe e será manipulada atraves dos metodos ADD e REMOVE
		this.moment = moment;
		this.status = status;
		this.client = client;
	}


	// Metodos Getters / Setters
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// Lista de items não tem metodos Get/Set por isso implementamos os metodos add e remove para não permitir o acesso completo a classe e permitir somente atraves dos metodos add/remove encapsulados
	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	
	// Demais metodos
	public double total() {
		double sum = 0.0;

		for (OrderItem it : items) {
			sum += it.subTotal();		// soma o subTotal do item (atraves de delegação, retorno do subtotal atraves de metodo da propria classe de item) na variavel SUM
		}

		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f", total()));

		return sb.toString();
	}

}
