package com.company;

import com.company.MySqlCon;

import java.sql.*;
public class queryDBExempel {
    public static void main(String[] args) {
        Connection con = MySqlCon.getConn(); // uppkoppling (se tidigare bild)
        String query = "SELECT * FROM Actor;"; // skapa en textsträng med SQL
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query); // skicka SQL till databasen
            while (rs.next()) { // loopa igenom resultatet
                System.out.print(rs.getString("first_name")+" "); // skriv ut data
                System.out.println(rs.getString("last_name")); // skriv ut data
            }
            stmt.close(); // stäng uppkoppling
            con.close(); // stäng uppkoppling
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}