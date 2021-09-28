package business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MockDate {
	
	private static final String currentDate = "01/05/2021";
	
	
	
	
	
	/**
	 * metodo que devolve a mock date do trabalho fornecida pelos professores
	 * @return Data fornecida
	 */
	public static Date getCurrentDate() {
		DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate date = LocalDate.parse(currentDate, formatterDay);
		return java.sql.Date.valueOf(date);
	}
}
