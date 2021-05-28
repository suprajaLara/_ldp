package org.example.mappings.oneToOne;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbcForMappings {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "root";
        String pass = "password";

        try {
            System.out.println("connecting to database: "+jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("connection successful..!");
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
