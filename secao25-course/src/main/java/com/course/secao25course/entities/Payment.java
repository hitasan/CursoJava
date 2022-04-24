package com.course.secao25course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_payment")
public class Payment  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos da classe
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	
	
	// Associações
	@JsonIgnore
	@OneToOne
	@MapsId
	private Order order;	// Adicionado anotações necessarias somente da classe dependente pois pagamentos depende de ter um pedido e nao o contrario.
	
	
	// Construtores
	public Payment() {
	}

	public Payment(Long id, Instant moment, Order order) {
		super();
		this.id = id;
		this.moment = moment;
		this.order = order;
	}

	
	// Getters / Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public Instant getMoment() { return moment; }
	public void setMoment(Instant moment) { this.moment = moment; }

	public Order getOrder() { return order; }
	public void setOrder(Order order) { this.order = order; }

	
	// Metodos Hashcode / Equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Payment other = (Payment) obj;

		return Objects.equals(id, other.id);
	}	
}