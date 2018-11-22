package com.company;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Item {
    private ItemClass itemClass;
    private static int numberOfItems;



    static Connection con = MySqlCon.getConn();
    static String query;
    static Statement stmt;
    static ResultSet rs;



    public Item(){
    }

    public Item(ItemClass itemClass){
        this.itemClass=itemClass;
        numberOfItems++;
    }
    public enum ItemClass {
        CAR,BOOK,MOVIE
    }

    public static void executeQuery(String statement){
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
