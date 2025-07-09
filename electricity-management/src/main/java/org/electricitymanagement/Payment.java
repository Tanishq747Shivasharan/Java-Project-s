package org.electricitymanagement;

import java.util.Scanner;

public class Payment {
    private Bill b;
    private double amountPaid;

    public Bill getBill() {
        return b;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public Payment(Bill bi, double amtP) {
        this.b = bi;
        this.amountPaid = amtP;
    }

    public boolean makePayment() {
        if (amountPaid >= b.getTotalBill()) {
            System.out.println("Payment successful! Amount paid: " + amountPaid);
            return true;
        } else {
            System.out.println("Insufficient payment! Amount due: Rs." + (b.getTotalBill() - amountPaid));
            return false;
        }
    }

    public void chkPaymentStatus() {
        double remaining = b.getTotalBill() - amountPaid;

        if (remaining > 0) {
            System.out.println("Amount still due: Rs." + remaining);
        } else {
            System.out.println("Payment complete!");
        }
    }

    public void inputPaymentDetails() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter amount paid: ");
        while (true) {
            try {
                this.amountPaid = Double.parseDouble(sc.nextLine());
                if (this.amountPaid < 0) {
                    throw new NumberFormatException("Amount paid cannot be negative.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + " Please try again.");
            }
        }
    }
}
