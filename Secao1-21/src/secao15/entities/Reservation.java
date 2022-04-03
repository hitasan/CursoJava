package secao15.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import secao15.exceptions.DomainException;

public class Reservation {

	// Atributos da class
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	// Metodos construtores
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	
	// Metodos Getters / Setters
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	
	// Metodos de processamento
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();				// diferente entre as 2 data em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);		// retorna a quantidade de dias usando como base a quantidade em milisegundos obtidos entre as duas datas.
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();	// Data atual

		if (checkIn.before(now) || checkOut.before(now)) {				// Verifico se as datas de entrada/saida são anteriores a data atual pois não deve permitir 
			//throw new IllegalArgumentException("Reservation dates for update must be future dates");
			throw new DomainException("Reservation dates for update must be future dates");
		}

		if (!checkOut.after(checkIn)) {									// Verifico se a data de saida não é anterior a data de entrada 
			//throw new IllegalArgumentException("Check-out date must be after check-in date");
			throw new DomainException("Check-out date must be after check-in date");
		}

		this.checkIn = checkIn;			// Valore recebidos passados para atributos do objeto
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room " + roomNumber
			+ ", check-in: " + sdf.format(checkIn)
			+ ", check-out: " + sdf.format(checkOut)
			+ ", " + duration() + " nights";
	}
}