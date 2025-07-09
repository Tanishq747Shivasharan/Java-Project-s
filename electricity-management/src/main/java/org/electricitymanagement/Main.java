package org.electricitymanagement;

import java.util.Scanner;
// import org.electricitymanagement.DB;


public class Main {
    public static void main(String[] args) {
        // @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        Customer cus = null;
        Bill b = null;
        Payment pay = null;

        while (true) {
            System.out.println("\n----Stateboard Electricity Management System ----");
            System.out.println("1. Enter Customer Details");
            System.out.println("2. Enter Bill Details");
            System.out.println("3. Enter Payment Details");
            System.out.println("4. Display Customer Details");
            System.out.println("5. Display Bill");
            System.out.println("6. Check Payment Status");
            System.out.println("7. Show All Customers");
            System.out.println("8. Show All Bills");
            System.out.println("9. Show All Payments");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1:
                    cus = new Customer();
                    cus.inputCustDetails();
                    DB.saveCust(cus);
                    break;

                case 2:
                    if (cus == null) {
                        System.out.println("Please enter customer details first.");
                    } else {
                        b = new Bill(cus, 0);
                        b.inputBillDetails();
                        DB.saveBill(b);
                    }
                    break;
                case 3:
                    if (b == null) {
                        System.out.println("Please enter bill details first.");
                    } else {
                        pay = new Payment(b, 0);
                        pay.inputPaymentDetails();
                        pay.makePayment();
                        DB.savePayment(pay);
                    }
                    break;
                case 4:
                    if (cus != null)
                        cus.displayCust();
                    else
                        System.out.println("Customer data not available.");
                    break;
                case 5:
                    if (b != null)
                        b.displayBill();
                    else
                        System.out.println("Bill data not available.");
                    break;
                case 6:
                    if (pay != null)
                        pay.chkPaymentStatus();
                    else
                        System.out.println("Payment not done yet.");
                    break;
                case 7:
                    DBView.showCust();
                    break;
                case 8:
                    DBView.showBills();
                    break;
                case 9:
                    DBView.showPayments();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

/*
 * System.out.println("Enter customer details");
 * Customer cus = new Customer();
 * cus.inputCustDetails();
 * cus.displayCust();
 * 
 * System.out.println("\nEnter bill details:");
 * Bill b = new Bill(cus,0);
 * b.inputBillDetails();
 * b.displayBill();
 * 
 * System.out.println("\nEnter payment details:");
 * Payment pay = new Payment(b, 0);
 * pay.inputPaymentDetails();
 * pay.makePayment();
 * pay.chkPaymentStatus();
 */
