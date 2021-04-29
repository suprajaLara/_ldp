package Assignment3;

import java.io.IOException;
import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) throws IOException {
        String host;
        int numberOfPackets;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the host:");
        host = sc.nextLine();
        System.out.println("Enter the number of packets:");
        numberOfPackets = sc.nextInt();
        sc.close();

        Pinger.ping(host,numberOfPackets);
        System.out.println("Median is : "+Pinger.calculateMedian());
    }
}
