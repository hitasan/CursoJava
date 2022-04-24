package com.course.secao25course.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.course.secao25course.entities.Order;
import com.course.secao25course.entities.Product;

@Embeddable
public class OrderItemPK  implements Serializable {	// Como é uma classe auxiliar de chave composta, adicionamos o embeddable

	private static final long serialVersionUID = 1L;

	// Atributos da classe
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	
	// Metodos Construtores - Como essa é uma classe de associação entre o pedido e os produtos não terá construtores
	
	
	// Getters / Setters
	public Order getOrder() { return order; }
	public void setOrder(Order order) { this.order = order; }

	public Product getProduct() { return product; }
	public void setProduct(Product product) { this.product = product; }
	
	
	// Metodos hashcode / equals
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		OrderItemPK other = (OrderItemPK) obj;

		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
}
