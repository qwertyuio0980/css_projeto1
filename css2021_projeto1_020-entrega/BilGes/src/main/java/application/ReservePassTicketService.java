package application;

import business.ReservePassTicketHandler;
import facade.exceptions.ApplicationException;

import java.util.List;
public class ReservePassTicketService {
    /**
	 * O objeto da facade que trata o caso de uso de comprar bilhetesPasse com escolha
	 * ou não de lugares.
	 */
    private ReservePassTicketHandler passTicketHandler;
    
    /**
     * Constroi um Serviço de bilhetePasse através de um handlerBilhetesPasse.
     * @param passTicketHandler passTicketHandler o handler de bilhetePasse
     */
    public ReservePassTicketService(ReservePassTicketHandler passTicketHandler) {
        this.passTicketHandler = passTicketHandler;
    }

    /**
     * Metodo que verifica quantos bilhetes existem em cada dia do evento e devolve o numero de bilhetesPasse disponiveis
     * @param eventName nome do evento para o qual queremos comprar bilhetesPasse
     * @return o numero de bilhetesPasse disponiveis para compra
     * @throws ApplicationException caso não existam bilhetesPasse disponiveis 
     */
    public int indicatePassTickets(String eventName) throws ApplicationException {

        return passTicketHandler.getPassTicketValidated(eventName);
    }

    /**
     * Metodo que efetua o processo de reservar os passTicketsCount que o cliente pretende, podendo o evento ser com lugares marcados ou não.
     * @param passTicketsCount numero de bilhetes passe que o cliente quer comprar
     * @param emailAddress emailAddress o email para onde a informaçao sobre os bilhetesPasse vai ser enviada ( Não esta implementado nesta fase)
     * @return Uma lista com 3 elementos: Referencia, Entidade e Valor para pagamento.
     * @throws ApplicationException caso não consiga reservar os bilhetes
     */
    public List<String> reservePassTickets(int passTicketsCount, String emailAddress) throws ApplicationException {

        return passTicketHandler.buyPassTickets(passTicketsCount, emailAddress);
    }

}