package business;

import java.util.List;

import javax.persistence.EntityManager;
import facade.exceptions.ApplicationException;

public class ReservationCatalog {

	/**
	 * Entity manager factory for accessing the persistence service 
	 */
	private EntityManager em;

	/**
	 * Constructs a individual ticket's reservation catalog giving a entity manager factory
	 */
	public ReservationCatalog(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * Adiciona uma reserva
	 * @param totalPrice preço total da reserva
	 * @param email email para reserva
	 * @param bankPayment dados de pagamento
	 * @param ticketList lista dos bilhetes que vao ser reservados
	 * 
	 * @throws ApplicationException
	 */
	public void addReservation(double totalPrice, String email, BankPayment bankPayment, List<Ticket> ticketList) throws ApplicationException {
		Reservation reservation = new Reservation(totalPrice, email, bankPayment, ticketList);
		em.persist(reservation);
	}

}
