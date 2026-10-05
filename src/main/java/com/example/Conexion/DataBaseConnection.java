package com.example.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.Exepciones.ExceptionUser;

public class DataBaseConnection {
    private final String url = "";
    private String user;
    private String password;
    private Connection conec;

    public DataBaseConnection(String user, String password) throws SQLException, ExceptionUser, ClassNotFoundException {
        if (user == null || password == null || user.trim().isEmpty() || password.trim().isEmpty()) {
            throw new ExceptionUser("Error en credenciales, vuelva a intentarlo");
        }
        
        this.user = user;
        this.password = password;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conec = DriverManager.getConnection(this.url, this.user, this.password);
    }

    public Connection getConec() {
        return conec;
    }

    public void close() throws SQLException {
        if (conec != null && !conec.isClosed()) {
            conec.close();
            System.out.println("Conexión con la base de datos cerrada correctamente.");
        }
    }
}
