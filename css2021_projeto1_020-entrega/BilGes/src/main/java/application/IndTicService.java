package application;

import java.util.List;
import java.util.Set;

import business.AtributeVenueHandler;
import business.ReserveIndTicHandler;
//import business.ReserveIndividualTicketHandler;
import facade.exceptions.ApplicationException;

public class IndTicService {
	
	/**
	 * O objeto da facade que trata o caso de uso de criar Eventos
	 */
	private ReserveIndTicHandler reserveIndTicHandler;

      /**
     * Constroi um Serviço de bilheteIndividual através de um handlerBilheteIndividual.
     * 
     * @param ReserveIndTicHandler o handler de bilheteIndividual
     */
	public IndTicService(ReserveIndTicHandler reserveIndividualTicketHandler) {
		this.reserveIndTicHandler = reserveIndividualTicketHandler;
	}
	
		/**
	 * Devolve as datas de um dado eventName
	 * 
	 * @param EventName o nome do evento para qual pretendemos comprar bilhetes
	 * @return Set de Strings com todas as datas do evento
	 * @throws ApplicationException no caso em que não e possivel comprar bilhetes
	 */
	public Set<String> getEventDates(String eventName) throws ApplicationException {
		return reserveIndTicHandler.getEventDates(eventName);
	}

	/** 
	 * Devolve uma lista contendo os lugares disponiveis para reservar na data especifica do evento chosenDay
	 * @param chosenDate a data escolhida
	 * @return Retorna uma lista de strings com os lugares disponiveis para o evento no dia escolhido ordenadas primeiro por fila e seguidamente por numero de cadeira
	 * @throws ApplicationException caso não tenha lugares disponiveis.
	 */
	public List<String> getSeatsOfEventDate(String chosenDay) throws ApplicationException {
		return reserveIndTicHandler.getSeatsOfEventDate(chosenDay);
	}

	/**
	 * Reserva os bilhetes de acordo com os lugares escolhidos e também coloca esses lugares especificos como "SOLD" (indisponiveis)
	 * @param chosenSeats os lugares escolhidos para reservar
	 * @param emailAddress o email para onde a informaçao sobre os bilhetes vai ser enviada ( Não esta implementado nesta fase)
	 * @return Uma lista com 3 elementos: Referencia, Entidade e Valor para pagamento.
	 * @throws ApplicationException
	 */
	public List<String> reserveSeats(List<String> chosenSeats, String emailAddress) throws ApplicationException {
		return reserveIndTicHandler.reserveSeats(chosenSeats, emailAddress);
	}
	
}
