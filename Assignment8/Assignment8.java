package Assignment8;

import java.util.Scanner;

public class Assignment8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter name:");
        String name = sc.nextLine();
        System.out.println("enter bill:");
        int bill = sc.nextInt();
        sc.nextLine(); // to ignore space or new line after int
        System.out.println("enter mobile number: ");
        String mobile = sc.nextLine();
        Customer customer = new Customer(name,bill,mobile);
    }
}
