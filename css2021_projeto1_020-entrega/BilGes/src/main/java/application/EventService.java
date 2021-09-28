package application;

import java.util.List;

import business.AddEventHandler;
import business.EventType;
import facade.exceptions.ApplicationException;

public class EventService {
	
	/**
	 * O objeto da facade que trata o caso de uso de criar Eventos
	 */
	private AddEventHandler eventHandler;

    /**
     *Constroi um eventService atraves do eventHandler
     * 
     * @param eventHandler o Handler de adicionar evento
     */
	public EventService(AddEventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}
	
	/**
	 * cria o evento com os parametros passados
	 * 
	 * @param name o nome do evento a criar
	 * @param days lista de strings com os dias do evento 
	 * @param startAndEndHours as horas de inicio e fim do evento
	 * @param type o tipo do evento
	 * @param companyNr o numero de registo da empresa
	 * @throws ApplicationException Caso não seja posivel criar o evento
	 */
	public void giveEventDetails(String name, List<String> days, List<String> startAndEndHours, String type, int companyNr) throws ApplicationException {
		eventHandler.addEvent(name, days, startAndEndHours, type, companyNr);
	}

	/**
	 *  metodo que cria uma lista com todos os tipos de eventos
	 * @return lista com todos os tipos de eventos
	 */
	public List<String> createNewEvent() {
		return eventHandler.getEventTypes();
	}
}