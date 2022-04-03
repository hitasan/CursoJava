package secao19.Set.entities;

import java.util.Date;
import java.util.Objects;

public class LogEntry {
	
	// ATRIBUTOS DA CLASSE
	private String username;
	private Date moment;


	// CONSTRUTORES DA CLASSE
	public LogEntry() {
	}

	public LogEntry(String username, Date moment) {
		this.username = username;
		this.moment = moment;
	}

	
	// METODOS GETTERS / SETTERS
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	
	// DEMAIS METODOS
	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogEntry other = (LogEntry) obj;
		return Objects.equals(username, other.username);
	}
	
	
	

}
