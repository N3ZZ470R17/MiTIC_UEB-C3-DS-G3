package com.edu.unbosque.grupo16.equipo3.tiendagenerica.DAO;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Importar UsuarioVO del paquete DTO
import com.edu.unbosque.grupo16.equipo3.tiendagenerica.DTO.UsuarioVO;
public class UsuarioDAO {
    public ArrayList<UsuarioVO> listaDeUsuarios() {
        ArrayList<UsuarioVO> mUs = new ArrayList<UsuarioVO>();
        Conexion conn = new Conexion();
        try{
            PreparedStatement ps = conn.getConnection().prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                UsuarioVO User = new UsuarioVO();
                // cedula_usuario equivale al ID en la tabla de usuarios
                User.setCedula_usuario(rs.getLong("cedula_usuario"));
                User.setEmail_usuario(rs.getString("email_usuario"));
                User.setNombre_usuario(rs.getString("nombre_usuario"));
                User.setPassword(rs.getString("password"));
                User.setUsuario(rs.getString("usuario"));
            }
            rs.close();
            ps.close();
            conn.desconectar();
        }catch(SQLException errSQL){
            System.err.println("Error al conectar");
        }
        return mUs;
    }

    public ArrayList<UsuarioVO> buscarUsuario(long cedula_usuario){
        ArrayList<UsuarioVO> mUs = new ArrayList<UsuarioVO>();
        Conexion conn = new Conexion();
        try{
            PreparedStatement ps = conn.getConnection().prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
            ps.setLong(1, cedula_usuario);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                UsuarioVO User = new UsuarioVO();

                User.setCedula_usuario(rs.getLong("cedula_usuario"));
                User.setEmail_usuario(rs.getString("email_usuario"));
                User.setNombre_usuario(rs.getString("nombre_usuario"));
                User.setPassword(rs.getString("password"));
                User.setUsuario(rs.getString("usuario"));
                mUs.add(User);
            }
            rs.close();
            ps.close();
            conn.desconectar();
        }catch(Exception errOtherOne){
            System.err.println("Error al conectar");
        }
        return mUs;
    }

    public boolean existeUsuario(Long cedula_usuario){
        boolean exists = false;
        Conexion conn = new Conexion();
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");

            ps.setLong(1, cedula_usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                exists = true;
            }
            rs.close();
            ps.close();
            conn.desconectar();
        }catch(Exception err){
            System.err.println("Error al realizar la operación...");
        }
        return exists;
    }

    public boolean crearUsuario (UsuarioVO User){
        boolean swCreate = false;
        if(!existeUsuario(User.getCedula_usuario())){
            Conexion conn = new Conexion();
            try {
                Statement stmt = (Statement) conn.getConnection().createStatement();
                String SQL = "INSERT INTO usuarios (cedula_usuario,email_usuario,nombre_usuario,password,usuario) VALUES ("+
                    User.getCedula_usuario()+",'"+User.getEmail_usuario()+"','"+User.getNombre_usuario()+"','"+User.getPassword()+"','"+User.getUsuario()+"');";
                ((java.sql.Statement) stmt).executeUpdate(SQL);
                ((java.sql.Statement) stmt).close();
                conn.desconectar();
                swCreate = true;
            }catch(SQLException errSQLCreate){
                System.err.println("Error al crear el usuario");
            }
        }else {
            System.out.println("El Usuario ya se encuentra en la base de datos...");
        }
        return swCreate;
    }

    public boolean borrarUsuario(long cedula_usuario){
        boolean swDel = false;
        if (existeUsuario(cedula_usuario)) {
            Conexion conn = new Conexion();
            try{
                Statement stmt = (Statement) conn.getConnection().createStatement();
                String SQL = "DELETE FROM usuarios WHERE cedula_usuario="+cedula_usuario;
                stmt.executeQuery(SQL);
                stmt.close();
                conn.desconectar();
                swDel = true;
            }catch(SQLException errSQLDel){
                System.err.println("Error al eliminar al usuario");
            }
        }else{
            System.out.println("El usuario no existe en la base de datos");
        }
        return swDel;
    }

    public boolean actualizarUsuario(UsuarioVO User){
        boolean swUpdate = false;
        if(existeUsuario(User.getCedula_usuario())) {
            Conexion conn = new Conexion();
            try{
                Statement stmt = (Statement) conn.getConnection().createStatement();
                String SQL = "UPDATE usuarios SET email_usuario='"+User.getEmail_usuario()+"',nombre_usuario='"+User.getNombre_usuario()+"',password='"+User.getPassword()+"',usuario='"+User.getUsuario()+"' WHERE cedula_usuario="+User.getCedula_usuario();
                ((java.sql.Statement) stmt).executeUpdate(SQL);
                ((java.sql.Statement) stmt).close();
                conn.desconectar();
                swUpdate=true;
            }catch (SQLException errSQLUpdate){
                System.err.println("Error al actualizar el usuario...");
            }
        }else{
            System.out.println("El usuario no existe en la base de datos");
        }
        return swUpdate;
    }
    
}
