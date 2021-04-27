import sun.font.CreatedFontTracker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
//import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) throws IOException {
         List<String> list = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
         String[] lines = list.toArray(new String[list.size()]);
         for(String line : lines){
            records.add(WebLogParser.parseEntry(line));
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }

    public int countUniqueIPs(){
         ArrayList<String>counts = new ArrayList<String>();
         for(LogEntry log : records){
             String ipAddr = log.getIpAddress();
             if(!counts.contains(ipAddr)){
                 counts.add(ipAddr);
             }
         }
         return counts.size();
    }

    public void printAllHigherThanNum(int num){
         for(LogEntry log : records){
             if(log.getStatusCode()>num){
                 System.out.println(log);
             }
         }
    }

    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        /* "someday" in the format “MMM DD”
        where MMM is the first three characters of the month name
        with the first letter capitalized and the others in lowercase,
        and DD is the day in two digits */

        ArrayList<String> ipAddrList = new ArrayList<String>();
        for(LogEntry log : records){
            String[] date = log.getAccessTime().toString().split(" ");
            String day = date[1]+" "+date[2];
            if(someday.equals(day)){
                String ipAddr = log.getIpAddress();
                if(!ipAddrList.contains(ipAddr)){
                    ipAddrList.add(ipAddr);
                }
            }
        }
        return ipAddrList;
    }

    public int countUniqueIPsInRange(int low, int high){
         ArrayList<String> ipAddrList = new ArrayList<String>();
        for(LogEntry log : records){
            String ipAddr = log.getIpAddress();
            if(log.getStatusCode()>=low && log.getStatusCode()<=high){
                if(!ipAddrList.contains(ipAddr)){
                    ipAddrList.add(ipAddr);
                }
            }
        }
        return ipAddrList.size();
    }

    public HashMap<String, Integer> countVisitsPerIP(){
        HashMap<String, Integer> counts = new HashMap<String, Integer> ();
        for(LogEntry log : records){
            String ipAddr = log.getIpAddress();
            if(!counts.containsKey(ipAddr)){
                counts.put(ipAddr,1);
            }
            else {
                counts.put(ipAddr,counts.get(ipAddr)+1);
            }
        }
        return counts;
    }
    public int mostNumberVisitsByIP(HashMap<String, Integer> counts){
        int max = 0;
        for(Map.Entry<String,Integer> map : counts.entrySet()){
            if (max<map.getValue()){
                max= map.getValue();
            }
        }
        return max;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts){
         int max = mostNumberVisitsByIP(counts);
         ArrayList<String> maxVisitsList = new ArrayList<String>();
        for(Map.Entry<String,Integer> map : counts.entrySet()){
            if (map.getValue()==max){
                maxVisitsList.add(map.getKey());
            }
        }
        return maxVisitsList;
    }
    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> ipDaysMap = new HashMap<String, ArrayList<String>>();
        for(LogEntry log : records){
            String[] date = log.getAccessTime().toString().split(" ");
            String day = date[1]+" "+date[2];
            String ipAddr = log.getIpAddress();
            ArrayList<String> listItem;
            if(ipDaysMap.containsKey(day)){
                listItem = ipDaysMap.get(day);
            }
            else{
                listItem = new ArrayList<String>();
            }
            listItem.add(ipAddr);
            ipDaysMap.put(day, listItem);
        }
        return ipDaysMap;
    }

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map){
         int max = 0;
         String day="";
         for(Map.Entry<String,ArrayList<String>> myMap : map.entrySet()){
             if(max<myMap.getValue().size()){
                 max = myMap.getValue().size();
                 day = myMap.getKey();
             }
         }
         return day;
    }

    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String day){
        ArrayList<String> mostVisit = new ArrayList<String >();
        ArrayList<String> listToCheck = map.get(day);
        HashMap<String,Integer> ipMap=new HashMap<String,Integer>();
        int max=0;
        for(String ip : listToCheck){
            if(!ipMap.containsKey(ip)){
                ipMap.put(ip,1);
            }
            else{
                ipMap.put(ip,ipMap.get(ip)+1);
            }
        }
        for(Map.Entry<String,Integer> ipMapping: ipMap.entrySet()){
            if(max<ipMapping.getValue()){
                max = ipMapping.getValue();
            }
        }
        for(Map.Entry<String,Integer> ipMapping: ipMap.entrySet()){
            if(max == ipMapping.getValue())
                mostVisit.add(ipMapping.getKey());
        }
        return mostVisit;
    }
}
