package de.kiwi.middle.methods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This Class contains usable methods. 
 * To make the main code shorter and readable.
 */

public class Utulities {

	/** This method gives the date and name of the day with ENUMS */
	public String giveDateAndTheNameOfTheDay() {

		String dateToday = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n";
		String dateWithNameOfTheDay;

		switch (LocalDate.now().getDayOfWeek()) {
		case MONDAY:
			dateWithNameOfTheDay = dateToday + String.valueOf(WeekDays.MONTAG);
			break;
		case TUESDAY:
			dateWithNameOfTheDay = dateToday + String.valueOf(WeekDays.DIENSTAG);
			break;
		case WEDNESDAY:
			dateWithNameOfTheDay = dateToday + String.valueOf(WeekDays.MITTWOCH);
			break;
		case THURSDAY:
			dateWithNameOfTheDay = dateToday + String.valueOf(WeekDays.DONNERSTAG);
			break;
		case FRIDAY:
			dateWithNameOfTheDay = dateToday + String.valueOf(WeekDays.FREITAG);
			break;
		case SATURDAY:
			dateWithNameOfTheDay = dateToday + String.valueOf(WeekDays.SAMSTAG);
			break;
		case SUNDAY:
			dateWithNameOfTheDay = dateToday + String.valueOf(WeekDays.SONNTAG);
			break;
		default:
			dateWithNameOfTheDay = dateToday + "HOLIDAY";
			break;
		}
		return dateWithNameOfTheDay;
	}

//	GridPane grid;
//
//	public Utulities() {
//
//	}
//	
//	public Utulities(GridPane grid) {
//		
//		this.grid = grid;
//		
//	}
//	
//	public GridPane createGrid(int vGap, int hGap, int paddings) {
//		
//		new GridPane();
//		grid.setVgap(vGap);
//		grid.setHgap(hGap);
//		grid.setPadding(new Insets(paddings,paddings,paddings,paddings));
//		
//		return grid;
//		
//	}
}
