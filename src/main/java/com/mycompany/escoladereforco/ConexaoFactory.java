/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escoladereforco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
class ConexaoFactory {

    static Connection getConnection() {
        try {        
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mercadinho","root","root");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
