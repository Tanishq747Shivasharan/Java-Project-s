package org.electricitymanagement;

import java.util.Scanner;

public class Bill {
    private Customer cust;
    private double UnitsUsed;
    private double totalBill;

    public Customer getCustomer() {
        return cust;
    }

    public double getUnitsUsed() {
        return UnitsUsed;
    }

    public Bill(Customer c, double UnitsConsumed) {
        this.cust = c;
        this.UnitsUsed = UnitsConsumed;
        calBill();
    }

    private void calBill() {
        if (UnitsUsed <= 100) {
            totalBill = UnitsUsed * 1.5;
        } else if (UnitsUsed <= 200) {
            totalBill = 100 * 1.5 + (UnitsUsed - 100) * 2;
        } else {
            totalBill = 100 * 1.5 + 100 * 2 + (UnitsUsed - 200) * 3;
        }
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void displayBill() {
        // cust.displayCust();
        System.out.println("Units Consumed: " + UnitsUsed);
        System.out.println("Total Bill: " + totalBill);
    }

    public void inputBillDetails() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter units consumed (positive number): ");
        while (true) {
            try {
                String in = sc.nextLine();
                UnitsUsed = Double.parseDouble(in);
                if (this.UnitsUsed <= 0) {
                    throw new NumberFormatException("Units consumed must be a positive number.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print(" Please enter units consumed again: ");
            }
        }
        calBill();
    }
}
