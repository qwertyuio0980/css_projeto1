package client;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import application.EventService;
import application.IndTicService;
import application.ReservePassTicketService;
import application.VenueService;
import facade.exceptions.ApplicationException;
import facade.startup.BilGes;

public class SimpleClient {

	/**
	 * An utility class should not have public constructors
	 */
	private SimpleClient() {
	}

	/**
	 * A simple interaction with the application services
	 *
	 * @param args Command line parameters
	 */
	public static void main(String[] args) {

		BilGes app = new BilGes();
		try {
			app.run();

			// Access services
			EventService es = app.getEventService();
			VenueService vs = app.getVenueService();
			IndTicService its = app.getIndTicService();
			ReservePassTicketService rpts = app.getPassTicketService();
			String eventName1 = "Bye Semestre X";
			String eventName2 = "Bye Semestre Y";
			String eventName3 = "Open dos Exames";
			String eventName4 = "Festival Estou de Ferias";
			int companyNr1 = 1;
			int companyNr2 = 2;





			//		1	--------------------------------------------------------------------------------------------------------------------						
			System.out.println("\n\nCaso1 \n");
			List<String> days1 = new ArrayList<String>();
			List<String> startAndEndHours1 = new ArrayList<String>();
			days1.add("09/05/2021");
			startAndEndHours1.add("21:00");
			startAndEndHours1.add("24:00");			
			es.giveEventDetails(eventName1, days1, startAndEndHours1, "TETEATETE", companyNr1);
			//		2	--------------------------------------------------------------------------------------------------------------------
			System.out.println("\n\nCaso2 \n");
			List<String> days2 = new ArrayList<String>();
			List<String> startAndEndHours2 = new ArrayList<String>();

			days2.add("09/05/2021");
			startAndEndHours2.add("20:00");
			startAndEndHours2.add("22:00");
			es.giveEventDetails(eventName2, days2, startAndEndHours2, "TETEATETE", companyNr1);
			//		3	--------------------------------------------------------------------------------------------------------------------
			System.out.println("\n\nCaso3 \n");
			List<String> days3 = new ArrayList<String>();
			List<String> startAndEndHours3 = new ArrayList<String>();
			days3.add("17/07/2021");
			startAndEndHours3.add("21:00");
			startAndEndHours3.add("23:30");	
			days3.add("18/07/2021");
			startAndEndHours3.add("15:00");
			startAndEndHours3.add("20:00");
			es.giveEventDetails(eventName3, days3, startAndEndHours3, "BANDOSENTADO", companyNr1);
			//		4	--------------------------------------------------------------------------------------------------------------------
			System.out.println("\n\nCaso4 \n");
			try {
				List<String> days4 = new ArrayList<String>();
				List<String> startAndEndHours4 = new ArrayList<String>();	
				days4.add("31/07/2021");
				days4.add("01/08/2021");
				startAndEndHours4.add("21:00");
				startAndEndHours4.add("23:00");			
				startAndEndHours4.add("14:00");
				startAndEndHours4.add("19:00");
				es.giveEventDetails(eventName4, days4, startAndEndHours4, "MULTIDAOEMPE", companyNr1);	
			}catch (ApplicationException e){
				System.out.println(e.getMessage());
			}
			//		5	--------------------------------------------------------------------------------------------------------------------
			System.out.println("\n\nCaso5 \n");
			try {
				List<String> days5 = new ArrayList<String>();
				List<String> startAndEndHours5 = new ArrayList<String>();
				days5.add("31/12/2021");
				days5.add("01/08/2021");
				startAndEndHours5.add("21:00");
				startAndEndHours5.add("23:00");			
				startAndEndHours5.add("14:00");
				startAndEndHours5.add("19:00");
				es.giveEventDetails(eventName4, days5, startAndEndHours5, "MULTIDAOEMPE", companyNr2);
			}catch (ApplicationException e){
				System.out.println(e.getMessage());
			}
			//		6	--------------------------------------------------------------------------------------------------------------------			
			System.out.println("\n\nCaso6 \n");
			List<String> days6 = new ArrayList<String>();
			List<String> startAndEndHours6 = new ArrayList<String>();
			days6.add("31/07/2021");
			days6.add("01/08/2021");
			startAndEndHours6.add("21:00");
			startAndEndHours6.add("23:00");			
			startAndEndHours6.add("14:00");
			startAndEndHours6.add("19:00");
			es.giveEventDetails(eventName4, days6, startAndEndHours6, "MULTIDAOEMPE", companyNr2);
			//		7	--------------------------------------------------------------------------------------------------------------------
			System.out.println("\n\nCaso7 \n");
			List<String> availableVenues = vs.chooseVenue();
			try {
				for(String s : availableVenues) {
					System.out.println(s);
				}
				vs.atributeVenue(eventName1, "Mini Estadio", "01/05/2021", 10.5);
			}catch (ApplicationException e){
				System.out.println(e.getMessage());
			}
			//		8	--------------------------------------------------------------------------------------------------------------------
			System.out.println("\n\nCaso8 \n");
			for(String s : availableVenues) {
				System.out.println(s);
			}
			vs.atributeVenue(eventName1, "Micro Pavilhao", "01/05/2021", 20);
			//		9	--------------------------------------------------------------------------------------------------------------------			
			System.out.println("\n\nCaso9 \n");
			try {
				for(String s : availableVenues) {
					System.out.println(s);
				}
				vs.atributeVenue(eventName2, "Micro Pavilhao", "01/05/2021", 20);
			}catch (ApplicationException e){
				System.out.println(e.getMessage());
			}

			//		10	--------------------------------------------------------------------------------------------------------------------			
			System.out.println("\n\nCaso10 \n");
			for(String s : availableVenues) {
				System.out.println(s);
			}
			vs.atributeVenue(eventName3, "Mini Estadio", "01/05/2021", 20);
			vs.setPassTicketPrice(30);
			//		11	--------------------------------------------------------------------------------------------------------------------					
			System.out.println("\n\nCaso11 \n");
			for(String s : availableVenues) {
				System.out.println(s);
			}
			vs.atributeVenue(eventName4, "Pequeno Relvado", "01/05/2021", 15);
			//		12	--------------------------------------------------------------------------------------------------------------------								
			System.out.println("\n\nCaso12 \n");
			String emailAddress12 = "u1@gmail.com";

			Set<String> availableDatesForIndividualTickets12 = its.getEventDates(eventName1);
			for(String s : availableDatesForIndividualTickets12) {
				System.out.println(s);
			}

			String chosenDay12 = "09/05/2021";

			List<String> availableSortedSeatsOnChosenDate12 = its.getSeatsOfEventDate(chosenDay12);
			for(String s : availableSortedSeatsOnChosenDate12) {
				System.out.println(s);
			}


			List<String> chosenSeats12 = new ArrayList<>();
			chosenSeats12.add("A-1");
			chosenSeats12.add("A-2");
			chosenSeats12.add("B-1");

			List<String> triploEntRefVal12 = its.reserveSeats(chosenSeats12, emailAddress12);
			for(String s : triploEntRefVal12) {
				System.out.println(s);
			}
			//		13	--------------------------------------------------------------------------------------------------------------------						
			System.out.println("\n\nCaso13 \n");
			try {
				String emailAddress13 = "u2@gmail.com";

				Set<String> availableDatesForIndividualTickets13 = its.getEventDates(eventName1);
				for(String s : availableDatesForIndividualTickets13) {
					System.out.println(s);
				}

				String chosenDay13 = "09/05/2021";

				List<String> availableSortedSeatsOnChosenDate13 = its.getSeatsOfEventDate(chosenDay13);
				for(String s : availableSortedSeatsOnChosenDate13) {
					System.out.println(s);
				}


				List<String> chosenSeats13 = new ArrayList<>();
				chosenSeats13.add("B-1");

				List<String> triploEntRefVal13 = its.reserveSeats(chosenSeats13, emailAddress13);
				for(String s : triploEntRefVal13) {
					System.out.println(s);
				}		
			}catch (ApplicationException e){
				System.out.println(e.getMessage());
			}
			//	 14		--------------------------------------------------------------------------------------------------------------------				
			System.out.println("\n\nCaso14 \n");
			String emailAddress14 = "u2@gmail.com";

			Set<String> availableDatesForIndividualTickets14 = its.getEventDates(eventName1);
			for(String s : availableDatesForIndividualTickets14) {
				System.out.println(s);
			}

			String chosenDay14 = "09/05/2021";

			List<String> availableSortedSeatsOnChosenDate14 = its.getSeatsOfEventDate(chosenDay14);
			for(String s : availableSortedSeatsOnChosenDate14) {
				System.out.println(s);
			}


			List<String> chosenSeats14 = new ArrayList<>();
			chosenSeats14.add("B-2");

			List<String> triploEntRefVal14 = its.reserveSeats(chosenSeats14, emailAddress14);
			for(String s : triploEntRefVal14) {
				System.out.println(s);
			}			
			//		15	--------------------------------------------------------------------------------------------------------------------				
			System.out.println("\n\nCaso15 \n");
			try {
				String emailAddress15 = "u1@gmail.com";

				Set<String> availableDatesForIndividualTickets15 = its.getEventDates(eventName4);
				for(String s : availableDatesForIndividualTickets15) {
					System.out.println(s);
				}

				String chosenDay15 = "09/05/2021";

				List<String> availableSortedSeatsOnChosenDate15 = its.getSeatsOfEventDate(chosenDay15);
				for(String s : availableSortedSeatsOnChosenDate15) {
					System.out.println(s);
				}


				List<String> chosenSeats15 = new ArrayList<>();
				chosenSeats15.add("A-1");
				chosenSeats15.add("A-2");
				chosenSeats15.add("B-1");

				List<String> triploEntRefVal15 = its.reserveSeats(chosenSeats15, emailAddress15);
				for(String s : triploEntRefVal15) {
					System.out.println(s);
				}	

			}catch (ApplicationException e){
				System.out.println(e.getMessage());
			}
			//		16	--------------------------------------------------------------------------------------------------------------------				
			System.out.println("\n\nCaso16 \n");
			String emailAddress16 = "u3@gmail.com";

			Set<String> availableDatesForIndividualTickets16 = its.getEventDates(eventName3);
			for(String s : availableDatesForIndividualTickets16) {
				System.out.println(s);
			}
			String chosenDay16 = "17/07/2021";

			List<String> availableSortedSeatsOnChosenDate16 = its.getSeatsOfEventDate(chosenDay16);
			for(String s : availableSortedSeatsOnChosenDate16) {
				System.out.println(s);
			}

			List<String> chosenSeats16 = new ArrayList<>();
			chosenSeats16.add("A-1");
			chosenSeats16.add("A-2");


			List<String> triploEntRefVal16 = its.reserveSeats(chosenSeats16, emailAddress16);
			for(String s : triploEntRefVal16) {
				System.out.println(s);
			}			
			//		17	--------------------------------------------------------------------------------------------------------------------				
			System.out.println("\n\nCaso17 \n");
			String emailAddress17 = "u4@gmail.com";

			int passTicketsCount17 = 2;
			int nrPassAvailable17 = rpts.indicatePassTickets(eventName3);
			System.out.println("Existem " + nrPassAvailable17 + " bilhetesPasse disponiveis.");

			List<String> reservePassTickets17 = rpts.reservePassTickets(passTicketsCount17, emailAddress17);
			for(String s : reservePassTickets17) {
				System.out.println(s);
			}
			//		18	--------------------------------------------------------------------------------------------------------------------				
			System.out.println("\n\nCaso18 \n");
			String emailAddress18 = "u5@gmail.com";

			int passTicketsCount18 = 3;
			int nrPassAvailable18 = rpts.indicatePassTickets(eventName3);
			System.out.println("Existem " + nrPassAvailable18 + " bilhetesPasse disponiveis.");

			List<String> reservePassTickets18 = rpts.reservePassTickets(passTicketsCount18, emailAddress18);
			for(String s : reservePassTickets18) {
				System.out.println(s);
			}
			//	19 caso retirado do enunciado----------------------------------------------------------------------------------------------				
			//			System.out.println("Caso19 \n");
			//			String emailAddress19 = "u6@gmail.com";
			//
			//			int passTicketsCount19 = 7;
			//			int nrPassAvailable19 = rpts.indicatePassTickets(eventName4);
			//			System.out.println("Existem " + nrPassAvailable19 + " bilhetesPasse disponiveis.");
			//
			//			List<String> reservePassTickets19 = rpts.reservePassTickets(passTicketsCount19, emailAddress19);
			//			for(String s : reservePassTickets19) {
			//				System.out.println(s);
			//			}
			//		20	--------------------------------------------------------------------------------------------------------------------				
			System.out.println("\n\nCaso20 \n");
			String emailAddress20 = "u7@gmail.com";
			try {
				int passTicketsCount20 = 4;
				int nrPassAvailable20 = rpts.indicatePassTickets(eventName4);
				System.out.println("Existem " + nrPassAvailable20 + " bilhetesPasse disponiveis.");

				List<String> reservePassTickets20 = rpts.reservePassTickets(passTicketsCount20, emailAddress20);
				for(String s : reservePassTickets20) {
					System.out.println(s);
				}
			}catch (ApplicationException e){
				System.out.println(e.getMessage());
			}
			//			--------------------------------------------------------------------------------------------------------------------























			app.stopRun();

		} catch (ApplicationException e) {
			System.out.println("Error: " + e.getMessage());
			// for debugging purposes only. Typically, in the application
			// this information can be associated with a "details" button when
			// the error message is displayed.
			if (e.getCause() != null)
				System.out.println("Cause: ");
			e.printStackTrace();
		}
	}
}