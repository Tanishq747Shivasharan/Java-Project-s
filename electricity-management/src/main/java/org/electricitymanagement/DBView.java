package org.electricitymanagement;

import java.sql.*;

public class DBView {
    private static final String url = "jdbc:postgresql://localhost:5432/electricitydb";
    private static final String user = "postgres";
    private static final String passwd = "tan3533";

    public static void showCust() {
        System.out.println("\nCustomer Table");
        try{
            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer");

            while(rs.next()) {
                int id = rs.getInt("custid");
                String name = rs.getString("name");
                String addr = rs.getString("address");
                String phone = rs.getString("phone");

                System.out.println("ID: " + id + ", Name: " + name + ", Address: " + addr + ", Phone: " + phone);
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e) {
            System.out.println("Error showing customer: " + e.getMessage());
        }
    }

    public static void showBills() {
        System.out.println("\nBill Table:");
        try {
            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from bill");

            while (rs.next()) {
                int id = rs.getInt("billid");
                int custId = rs.getInt("custid");
                double units = rs.getDouble("units");
                double total = rs.getDouble("total");

                System.out.println("Bill ID: " + id + ", Customer ID: " + custId + ", Units: " + units + ", Total: " + total);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error showing bills: " + e.getMessage());
        }
    }

    public static void showPayments() {
        System.out.println("\nPayment Table:");
        try {
            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from payment");

            while (rs.next()) {
                int id = rs.getInt("payid");
                int custId = rs.getInt("custid");
                double paid = rs.getDouble("amountpaid");

                System.out.println("Payment ID: " + id + ", Customer ID: " + custId + ", Amount Paid: " + paid);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error showing payments: " + e.getMessage());
        }
    }
}
