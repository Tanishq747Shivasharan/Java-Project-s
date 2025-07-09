package org.electricitymanagement;

import java.sql.*;

public class DB {
    private static final String url = "jdbc:postgresql://localhost:5432/electricitydb";
    private static final String user = "postgres";
    private static final String passwd = "tan3533";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (Exception e) {
            System.out.println("Error while connection to database: " + e.getMessage());
            ;
        }
        return conn;
    }

    public static void saveCust(Customer c) {
        try {
            Connection conn = getConnection();
            String cq = "insert into customer(custid, name, address, phone) values(?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(cq);
            pstmt.setInt(1, c.getCustID());
            pstmt.setString(2, c.getName());
            pstmt.setString(3, c.getAddr());
            pstmt.setString(4, c.getPhone());

            pstmt.executeUpdate();
            System.out.println("Customer saved to database.");

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Failed to save customer: " + e.getMessage());
        }
    }

    public static void saveBill(Bill b) {
        try {
            Connection conn = getConnection();
            String bq = "insert into bill(custid, units, total) values(?, ?, ?)";
            PreparedStatement pstmt1 = conn.prepareStatement(bq);
            pstmt1.setInt(1, b.getCustomer().getCustID());
            pstmt1.setDouble(2, b.getUnitsUsed());
            pstmt1.setDouble(3, b.getTotalBill());

            pstmt1.executeUpdate();
            System.out.println("Bill saved to database.");

            pstmt1.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Failed to save bill: " + e.getMessage());
        }
    }

    public static void savePayment(Payment p) {
        try {
            Connection conn = getConnection();
            String pq = "insert into payment (custid, amountpaid) values(?, ?)";
            PreparedStatement pstmt2 = conn.prepareStatement(pq);
            pstmt2.setInt(1, p.getBill().getCustomer().getCustID());
            pstmt2.setDouble(2, p.getAmountPaid());

            pstmt2.executeUpdate();
            System.out.println("Payment saved to database.");

            pstmt2.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Failed to save payment: " + e.getMessage());
        }
    }
}

/*
 * private static final String url = "jdbc:postgresql://localhost:5432/electricitydb";
 * private static final String user = "postgres";
 * private static final String passwd = "tan3533";
 */