package Assignment4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Assignment4 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        System.out.println();
        while (n != 0){
            String[] dates = s.nextLine().split(" ");

            if(dates.length == 2) {
                getDateRange(dates[0], dates[1]);
            }
            else{
                System.out.println("Provide two dates");
            }
            n--;
        }
    }

    private static void getDateRange(String signedDate, String presentDate) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //to get instance of LocalTime from string parameter, using specific formatter
        LocalDate signed = LocalDate.parse(signedDate, dateFormatter);
        LocalDate present = LocalDate.parse(presentDate, dateFormatter);

        if(signed.plusYears(1).minusDays(30).isAfter(present)){//check if boundary date is after the present date
            System.out.println("No Range");
            return;
        }

        LocalDate anniversary = LocalDate.of(present.getYear(),signed.getMonth(),signed.getDayOfMonth());

        LocalDate start = anniversary.minusDays(30);
        LocalDate end = anniversary.plusDays(30);

        if(present.isBefore(end)){
            end = present;
        }
        System.out.println(formatDate(start)+" "+formatDate(end));
    }

    private static String formatDate(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}

/*
Sample input:
5
16-07-1998 27-06-2017
04-02-2016 04-04-2017
04-05-2017 04-04-2017
04-04-2015 04-04-2016
04-04-2015 15-03-2016

Test output:
16-06-2017 27-06-2017
05-01-2017 06-03-2017
No range
05-03-2016 04-04-2016
05-03-2016 15-03-2016
*/