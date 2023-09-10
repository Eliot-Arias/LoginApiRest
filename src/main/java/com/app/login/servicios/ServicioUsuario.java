package com.app.login.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.login.entidad.Usuario;

@Service
public interface ServicioUsuario {
	
	public Usuario RegistrarUsuario(Usuario usuario);
	
	public void ActualizarUsuario(Integer id,  String dni, String nombre, String apellidos, String nomUser, String contrasenia, int edad, String correo, String celular);
	
	public Usuario ValidarUsuario(String nomUser, String contrasenia);
	
	public List<Usuario> ListarUsuarios();
	
	public Usuario MostrarUsuario(String nomUser, String contrasenia);
	
}
