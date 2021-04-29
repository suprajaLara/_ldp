package Assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Pinger {
    static ArrayList<Double> timeList = new ArrayList<>();
    static void ping(String host, int numberOfPackets) throws IOException {
        String command = "ping -c "+numberOfPackets+" "+host;
        Process process = Runtime.getRuntime().exec(command);

        BufferedReader input = new BufferedReader(new
                                    InputStreamReader(process.getInputStream()));
        BufferedReader error = new BufferedReader(new
                                    InputStreamReader(process.getErrorStream()));
        String line;
        if((line=error.readLine())!=null){
            System.out.println(line);
            while((line=error.readLine())!=null)
                System.out.println(line);
            System.exit(0);
        }
        else{
           collectTimeInList(input,numberOfPackets);
        }
    }
    private static void collectTimeInList(BufferedReader reader, int numberOfPackets) throws IOException {
        String line;
        reader.readLine(); // to ignore the first line
        int counter=1,timeIndex;
        while((line = reader.readLine())!=null && counter<=numberOfPackets){
            System.out.println(line);
            timeIndex = line.indexOf("time=");
            if(timeIndex!=-1)
                timeList.add(Double.parseDouble(line.substring(timeIndex+5,line.length()-3)));
            else if(counter==1){
                System.out.println("0 Packets received \nMedian is 0");
                System.exit(0);
            }
            counter++;
        }
    }
    static double calculateMedian(){
        Collections.sort(timeList);
        int numberOfPackets = timeList.size();
        double median;
        int index = numberOfPackets/2;
        if(numberOfPackets%2==0){
            median = ( timeList.get(index-1) + timeList.get(index) ) / 2;
        }
        else {
            median = timeList.get(index);
        }
        return median;
    }
}
