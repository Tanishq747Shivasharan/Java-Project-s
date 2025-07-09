package org.electricitymanagement;

import java.util.Scanner;

public class Customer {
    private int CustId;
    private String name;
    private String address;
    private String phNo;

    public Customer(int CId, String n, String addr, String pNo) {
        this.CustId = CId;
        this.name = n;
        this.address = addr;
        this.phNo = pNo;
    }

    public Customer() {
    }

    public int getCustID() {
        return CustId;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return address;
    }

    public String getPhone() {
        return phNo;
    }

    public void setCustId(int CustId) {
        this.CustId = CustId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(String address) {
        this.address = address;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public void displayCust() {
        System.out.println("\nCustomer Details: ");
        System.out.println("Customer ID: " + CustId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phNo);
    }

    public void inputCustDetails() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID (positive number): ");
        while (true) {
            try {
                this.CustId = Integer.parseInt(sc.nextLine());
                if (this.CustId <= 0) {
                    throw new NumberFormatException("Customer ID must be positive.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + "Please enter valid Customer ID");
            }
        }

        System.out.print("Enter Customer Name: ");
        this.name = sc.nextLine();

        System.out.print("Enter Customer Address: ");
        this.address = sc.nextLine();

        System.out.print("Enter Customer Phone Number: ");
        while (true) {
            this.phNo = sc.nextLine();
            if (this.phNo.matches("\\d{10}")) {
                break;
            } else {
                System.out.println("Invalid phone number. Please enter a 10-digit number:");
            }
        }

    }
}
