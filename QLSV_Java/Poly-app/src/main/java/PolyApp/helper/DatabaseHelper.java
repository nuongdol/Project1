/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PolyApp.helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin-PC
 */
public class DatabaseHelper {
    public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
          String connectionUrl = "jdbc:sqlserver://localhost;database=PolyApp;";
          String username = "sa";
          String password = "123456789";
          Connection con = DriverManager.getConnection(connectionUrl,username,password);
          return con;
    }
    
}
