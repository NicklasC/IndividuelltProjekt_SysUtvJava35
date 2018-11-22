package com.company;

import java.sql.*;
public class MySqlCon {
    static Connection con = MySqlCon.getConn();
    static String query;
    static Statement stmt;
    static ResultSet rs;


    public static Connection getConn() { // OBS!
        try {
            String url ="jdbc:mysql://localhost:3306/myproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode = false & serverTimezone = CET ";
            Connection con = DriverManager.getConnection(
                    url, "root", "root");
            return con; // OBS!
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean myExecuteQuery(String statement){
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(statement);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}