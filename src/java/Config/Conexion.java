/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ramos
 */
public class Conexion {
   Connection cn;
   
    public Connection conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/almacen","test","Killer001");
            System.out.println("Conectado");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("o ");
          
             
        }
        return cn;
        
    }

    
}
