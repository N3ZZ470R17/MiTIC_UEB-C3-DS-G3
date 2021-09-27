package com.edu.unbosque.grupo16.equipo3.tiendagenerica.DTO;

public class UsuarioVO {
    /**
     * Clase DTO encargado de los usuarios con las siguientes variables:
     * @param cedula_usuario >> ID del usuario (Cédula de Ciudadanía del usuario)
     * @param email_usuario >> Correo electrónico del usuario
     * @param nombre_usuario >> Nombre de usuario asignado a cada uno.
     * @param password >> Contraseña de acceso del usuario
     * @param usuario >> Nombre descriptivo del usuario (diferente al username/nombre de usuario)
     */
    
    private long cedula_usuario;
    private String email_usuario;
    private String nombre_usuario;
    private String password;
    private String usuario;
    
    // Generación automática de Getters/Setters
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public long getCedula_usuario() {
        return cedula_usuario;
    }
    public void setCedula_usuario(long cedula_usuario) {
        this.cedula_usuario = cedula_usuario;
    }
    public String getEmail_usuario() {
        return email_usuario;
    }
    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
