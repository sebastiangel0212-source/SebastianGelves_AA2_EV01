package com.sebastiangelves.ss.web.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/ssdb?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";        // Ajusta tu usuario
    private static final String PASS = "tu_clave";    // Ajusta tu contraseña

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
