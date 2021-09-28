package facade.startup;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.EventService;
import application.IndTicService;
import application.ReservePassTicketService;
import business.AddEventHandler;
import business.AtributeVenueHandler;
import business.ReserveIndTicHandler;
import business.ReservePassTicketHandler;
import application.VenueService;
import facade.exceptions.ApplicationException;

public class BilGes {
	
	private EventService eventService;
	private EntityManagerFactory emf;

	public void run() throws ApplicationException {
		// Connects to the database
		try {
			emf = Persistence.createEntityManagerFactory("BilGes");
			eventService = new EventService(new AddEventHandler(emf));
			
			// exceptions thrown by JPA are not checked
		} catch (Exception e) {
			throw new ApplicationException("Error connecting database", e);
		}
	}

	public void stopRun() {
		// Closes the database connection
		emf.close();
	}

	public EventService getEventService() {
		return eventService;
	}

	//Passa uma nova venueService pois estas tem que guardar estado
	public VenueService getVenueService() {
		return new VenueService(new AtributeVenueHandler(emf));
	}
	
	public IndTicService getIndTicService() {
		// always provides a new service because the service (in fact the ReserveIndTicHandler) knows 
		// about the current reservation (it is stateful)
		return new IndTicService(new ReserveIndTicHandler(emf));
	}
	
	//Passa uma nova ReservePassTicketService pois estas tem que guardar estado
    public  ReservePassTicketService getPassTicketService() {
        return new ReservePassTicketService(new ReservePassTicketHandler(emf));
    }
}