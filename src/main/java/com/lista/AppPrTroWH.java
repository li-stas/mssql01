package com.lista;

import java.sql.*;

public class AppPrTroWH {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // Create a variable for the connection string.

        String server = "85.223.140.88\\SalesWeb:8084";
        String user ="1C_DB";
        String password="TC73dfa0a8!";

        String passwdTC = "TC164500d0!";

        //Connect to  MSSQL
        String connectionUrl = "jdbc:sqlserver://"
                + "85.223.140.88\\SalesWeb:8084"
                + ";user=1C_DB"
                + ";password=TC73dfa0a8!";

        try (Connection con = DriverManager.getConnection(connectionUrl);
             CallableStatement cstmt = con.prepareCall("{call SalesWeb.dbo.prTroWH(?)}"); ) {
            cstmt.setString(1, passwdTC);
            cstmt.execute();

            ResultSet rs = cstmt.getResultSet();

            ResultSetMetaData md = rs.getMetaData();
            int cols = md.getColumnCount();

            for (int i = 0; i < cols; i++) {
                String name = md.getColumnLabel(i + 1);
                print(name + "\t");
            }

            println("");
            while (rs.next()) {
                for (int i = 0; i < cols; i++) {
                    String value = rs.getString(i + 1);
                    print(value + "\t");
                }
                println("");
            }

            System.out.println( "Hello World!" );
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void print(String cOut) {
        System.out.print(cOut);
    }
    private static void println(String cOut) {
        System.out.println(cOut);
    }
}
