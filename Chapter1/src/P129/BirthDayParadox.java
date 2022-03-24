package P129;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import P128.WriteSentenceMultiple;

public class BirthDayParadox {
	
	public static void main(String[] args) {
		try {
			int[] testsMatches= {0,0,0,0,0,0};
			int numberOfTests = 100;
			int[] birthDayParadoxTests = {5,10,15,20,25,100};
			BirthDayParadox paradox = new BirthDayParadox();
			for(int j = 0 ; j<numberOfTests ; j++ ) {
				for(int i = 0; i< birthDayParadoxTests.length; i++ ) {
					int numberPeople = birthDayParadoxTests[i];
					LocalDate[] birthDays = paradox.GenerateBirthDays(numberPeople);
					int matches = paradox.NumberMatches(birthDays);	
					testsMatches[i] = matches == 0 ? testsMatches[i] : testsMatches[i] + 1;
				}
			}

			for(int i = 0; i< birthDayParadoxTests.length; i++ ) {
			    int percentMatch = testsMatches[i]; 
				System.out.println("For " + birthDayParadoxTests[i] + " people the percent matcha was " + percentMatch );
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public LocalDate[] GenerateBirthDays(int numberPeople) throws ParseException {
		LocalDate[] birthDays = new LocalDate[numberPeople];
		
		for(int i = 0; i<numberPeople; i++) {
			birthDays[i] = GenerateBirthDay();
		}
		return birthDays;
	}

	public int NumberMatches(LocalDate[] birthDays) {
		int equals = 0;
		
		for(int i = 0; i<birthDays.length; i++) {
			LocalDate date = birthDays[i];
			for(int j = i; j<birthDays.length; j++) {
				LocalDate dateToCompare = birthDays[j];
				if(i!=j && (date.getDayOfMonth() == dateToCompare.getDayOfMonth()) && (date.getMonth() == dateToCompare.getMonth())) {
					equals++;
				}
			}
		}
		return equals;
	}
	
	public LocalDate GenerateBirthDay() throws ParseException {
		Random random = new Random();
		int rangeYear = 2010 - 1950 + 1;
		int year =  random.nextInt(rangeYear) + 1950;
		int rangeMounth = 12 - 1 + 1;
		int mounth =  random.nextInt(rangeMounth) + 1;
		int lastDay = 
				mounth == 2 ? 28 : 
				  ((mounth == 1 || 
					mounth == 3 || 
					mounth == 5 ||
					mounth == 7 || 
					mounth == 8 ||
					mounth == 12) 
				? 31 : 30);
		int rangeday = lastDay - 1 + 1;
		int day = random.nextInt(rangeday) + 1;
		String date_string = year + "-" + (mounth >= 10 ? mounth : "0" +mounth)  + "-" +  (day >= 10 ? day : "0" + day) ;
		LocalDate birthDay = LocalDate.parse(date_string);    
		return birthDay;
	}

}

