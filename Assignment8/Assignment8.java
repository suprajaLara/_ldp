package Assignment8;

import java.util.Scanner;

public class Assignment8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter name:");
        String name = sc.nextLine();
        System.out.println("enter bill:");
        int bill = sc.nextInt();
        System.out.println("enter number of people to divide among: ");
        int noOfPeople = sc.nextInt();
        Customer customer = new Customer(name,bill,noOfPeople);
    }
}
