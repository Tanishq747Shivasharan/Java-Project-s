package org.electricitymanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter customer details");
        Customer cus = new Customer();
        cus.inputCustDetails();
        cus.displayCust();

        System.out.println("\nEnter bill details:");
        Bill b = new Bill(cus,0);  
        b.inputBillDetails();
        b.displayBill();

        System.out.println("\nEnter payment details:");
        Payment pay = new Payment(b, 0);
        pay.inputPaymentDetails();
        pay.makePayment();
        pay.chkPaymentStatus();

        sc.close();
    }
}

