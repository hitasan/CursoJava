package secao13.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	
	// Atributos da classe
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	// Declarando da formatação de data como static para usar unico SDF em toda classe sem necessidade de mais declarações. Será usado para data de nascimento

	private String name;
	private String email;
	private Date birthDate;
	
	// Motodos Construtores
	public Client() {
	}
	
	public Client(String name, String email, Date birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	// Metodos Getters / Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	// Demais metodos
	@Override
	public String toString() {
		return name + " (" + sdf.format(birthDate) + ") - " + email;
 	}
	
}
