package pl.kz.championshipsfootballapp;

/**
 * Created by JACZAW on 21.07.2018.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestPolaczenia {

        public static void main(String[] args) {

            String connectionUrl = "jdbc:sqlserver://192.168.0.24:1433;databaseName=kz_wc18;user=sa;password=Comarch!2011";

            try {
                // Load SQL Server JDBC driver and establish connection.
                System.out.print("sie do SQL Server u Grzeska na laptopie... ");
                try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                    System.out.println("Zrobione.");
                    System.out.print("Wykonuje zapytanie ... ");
                    String sql = "select * from kz.grupy";

                    try (Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(sql)) {
                        while (resultSet.next()) {
                            System.out.println(
                                    resultSet.getInt(1) + " " + resultSet.getString(2));
                        }
                    }
                    connection.close();
                    System.out.println("All done.");               }
            } catch (Exception e) {
                System.out.println();
                e.printStackTrace();
            }
        }
    }

