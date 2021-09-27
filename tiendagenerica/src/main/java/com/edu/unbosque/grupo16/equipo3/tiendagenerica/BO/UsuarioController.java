package com.edu.unbosque.grupo16.equipo3.tiendagenerica.BO;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edu.unbosque.grupo16.equipo3.tiendagenerica.DAO.UsuarioDAO;
import com.edu.unbosque.grupo16.equipo3.tiendagenerica.DTO.UsuarioVO;
//Autoriza para hacer consultas desde afuera
@RestController
public class UsuarioController {

    /**
    * recibe la peticion para el listado de Usuarios
    * @return
    */
    @RequestMapping("/lstusrs")
    public ArrayList<UsuarioVO> listaDeUsuarios(){
        UsuarioDAO DAO = new UsuarioDAO();
        return DAO.listaDeUsuarios();
    }
    ////////////////////////////////////////////////////
    /**
    * Busca los datos de un Usuario por su CEDULA
    * @param cedula_usuario
    * @return
    */
    @RequestMapping("/fndusr")
    public ArrayList<UsuarioVO> buscarUsuario(String cedula_usuario){//revisar****
        UsuarioDAO DAO = new UsuarioDAO();
        return DAO.buscarUsuario(Long.parseLong(cedula_usuario));
    }
    ////////////////////////////////////////////////////
    /**
    * Agrega un nuevo Usuario a la base de datos
    * @param cedula_usuario
    * @param email_usuario
    * @param nombre_usuario
    * @param password
    * @param usuario
    * @return
    */
    @RequestMapping("/crtusr")
    public boolean crearUsuario(String cedula_usuario,String email_usuario,String nombre_usuario, String password, String usuario) {
        UsuarioDAO DAO = new UsuarioDAO();
        UsuarioVO User = new UsuarioVO();

        User.setCedula_usuario(Long.parseLong(cedula_usuario));
        User.setEmail_usuario(email_usuario);
        User.setNombre_usuario(nombre_usuario);
        User.setPassword(password);
        User.setUsuario(usuario);

        return DAO.crearUsuario(User);
    }
    ////////////////////////////////////////////////////
    /**
    * Elimina un Usuario de acuerdo a su cedula
    * @param cedula_usuario
    * @return
    */
    @RequestMapping("/delusr")
    public boolean borrarUsuario(String cedula_usuario) {
        UsuarioDAO DAO = new UsuarioDAO();
        return DAO.borrarUsuario(Long.parseLong(cedula_usuario));
    }
    ////////////////////////////////////////////////////
    /**
    * Actualiza los datos del Usuario segun su cedula
    * @param cedula_usuario
    * @param email_usuario
    * @param nombre_usuario
    * @param password
    * @param usuario
    * @return
    */
    @RequestMapping("/updtusr")
    public boolean actualizarUsuario(String cedula_usuario,String email_usuario, String nombre_usuario, String password, String usuario) {
        UsuarioDAO DAO = new UsuarioDAO();
        UsuarioVO User = new UsuarioVO();
        User.setCedula_usuario(Long.parseLong(cedula_usuario));
        User.setEmail_usuario(email_usuario);
        User.setNombre_usuario(nombre_usuario);
        User.setPassword(password);
        User.setUsuario(usuario);
        
        return DAO.actualizarUsuario(User);
    }
}

