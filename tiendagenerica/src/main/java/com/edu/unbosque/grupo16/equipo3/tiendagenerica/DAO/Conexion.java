package com.edu.unbosque.grupo16.equipo3.tiendagenerica.DAO;

import java.sql.*;

public class Conexion {
    /** Parametros de conexion */
    static String bd = "tiendagenerica1";
    static String login = "root";
    // static String password = "admin"; static String password = "1234";
    static String url = "jdbc:mysql://localhost/" + bd;
    Connection connection = null;

    /** Constructor de DbConnection */
    public Conexion() {
        try { // obtenemos el driver de para mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            // obtenemos la conexión
            connection = DriverManager.getConnection(url, login, bd);
            if (connection != null) {
                System.out.println("Conexión a base de datos " + bd + " OK\n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /** Permite retornar la conexión */
    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        connection = null;
    }
}
