package com.edu.unbosque.equipo3.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
//import com.edu.unbosque.equipo3.tiendagenerica.DTO.ClienteVO;
import com.edu.unbosque.equipo3.tiendagenerica.DTO.LoginVO;

public class LoginDAO {

    public ArrayList<LoginVO> consultarUsuario(String usuario, String clave) {
        ArrayList<LoginVO> miusuario = new ArrayList<LoginVO>();
        // Crea el objeto arrayList
        Conexion conex = new Conexion();
        try {
            String cadenaSQL = "SELECT * FROM usuarios where usuario =? and clave=?";
            PreparedStatement consulta = conex.getConnection().prepareStatement(cadenaSQL);
            consulta.setString(1, usuario);
            // el orden de los ? consulta.setString(2, clave);
            ResultSet res = consulta.executeQuery();
            if (res.next()) {
                LoginVO usuario1 = new LoginVO();
                usuario1.setUsuario(res.getString("usuario"));
                // lee la BD
                usuario1.setClave(res.getString("clave"));
                miusuario.add(usuario1);
                // agregar a la lista el usuario encontrado en la BD
            }
            res.close();
            consulta.close();
            conex.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar El usuario\n" + e);
        }
        return miusuario;
    }

}
