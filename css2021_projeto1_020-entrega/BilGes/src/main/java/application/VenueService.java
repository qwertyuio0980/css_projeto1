package application;

import java.util.List;

import business.AtributeVenueHandler;
import business.Venue;
import facade.exceptions.ApplicationException;

public class VenueService {
	
	/**
	 *  O objeto da facade que trata o caso de uso de atribuir instalaçao para o evento x
	 */
	private AtributeVenueHandler venueHandler;
	private String eventName;
	private String venueName;

    /**
     * Constroi um Serviço de atribuirInstalaçao através de um AtributeVenueHandler.
     * 
     * @param venueHandler O handler de atribuir instalação
     */
	public VenueService(AtributeVenueHandler venueHandler) {
		this.venueHandler = venueHandler;
	}
	
	/**
	 * Metodo que devolve todas as instalaçoes
	 * @return uma lista com todas as instalaçoes disponiveis
	 * @throws ApplicationException caso não existam venues disponiveis
	 */
	public List<String> chooseVenue() throws ApplicationException {
		return venueHandler.getAllVenues();
	}
	
	/**
	 * Metodo que trata de atribuir uma instalaçao para o evento eventName
	 * @param eventName o nome do evento
	 * @param venueName a instalaçao que queremos atribuir
	 * @param date a data de começo de venda dos bilhetes
	 * @param preco o preço dos bilhetes Individuais
	 * @throws ApplicationException caso nao consiga atribuir a instalaçao para o evento
	 */
	public void atributeVenue(String eventName, String venueName, String date, double preco) throws ApplicationException {
		this.eventName = eventName;
		this.venueName = venueName;
		venueHandler.atributeVenue(eventName, venueName, date, preco);
	}
	
	/**
	 * metodo que trata de atribuir um preço aos bilhetesPasse
	 * @param price preco dos bilhetesPasse
	 * @throws ApplicationException caso nao seja possivel adicionar preço aos bilhetesPasse
	 */
	public void setPassTicketPrice(double price) throws ApplicationException {
        venueHandler.indicatePassTicketPrice(price);
    }
	
}