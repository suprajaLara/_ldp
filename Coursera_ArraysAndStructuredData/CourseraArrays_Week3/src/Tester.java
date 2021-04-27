import java.io.IOException;
import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() throws IOException {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("src/short-test_log.txt");
        logAnalyzer.printAll();
    }

    public void testUniqueIP() throws IOException {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("src/short-test_log.txt");
        System.out.println("Count of Unique Ips: "+logAnalyzer.countUniqueIPs());
    }

    public void testPrintAllHigherThanNum() throws IOException {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("src/short-test_log.txt");
        logAnalyzer.printAllHigherThanNum(200);
    }

    public void testPUniqueIPVisitsOnDay() throws IOException {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("src/weblog-short_log");
        ArrayList<String> uniqueIpVisits = logAnalyzer.uniqueIPVisitsOnDay("Sep 30");
        System.out.println(uniqueIpVisits);
    }

    public void testCountUniqueIPsInRange(int low, int high) throws IOException {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("src/short-test_log.txt");
        System.out.println("Number of unique IP addresses that have a status code from "+low+" to "+high+": "
                +logAnalyzer.countUniqueIPsInRange(low,high));
    }

    public void testMostNumberVisitsByIP() throws IOException {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("src/weblog3-short_log");
        int count = logAnalyzer.mostNumberVisitsByIP(logAnalyzer.countVisitsPerIP());
        System.out.println("Maximum number of visits to this website by a single IP address: "+count);
    }

    public void testIPsForDays() throws IOException {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("src/weblog3-short_log");
        HashMap<String, ArrayList<String>> ipForDaysMap = logAnalyzer.iPsForDays();
        System.out.println(ipForDaysMap);
    }

    public void testIPsWithMostVisitsOnDay() throws IOException {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("src/weblog3-short_log");
        ArrayList<String> ipForDaysMap = logAnalyzer.iPsWithMostVisitsOnDay(logAnalyzer.iPsForDays(),"Sep 30");
        System.out.println(ipForDaysMap);
    }

    public static void main(String[] args) throws IOException {
        Tester tester = new Tester();
        tester.testLogEntry();
        tester.testLogAnalyzer();
        tester.testUniqueIP();
        tester.testPrintAllHigherThanNum();
        tester.testPUniqueIPVisitsOnDay();
        tester.testCountUniqueIPsInRange(300,399);
        tester.testMostNumberVisitsByIP();
        tester.testIPsForDays();
        tester.testIPsWithMostVisitsOnDay();
    }
}

