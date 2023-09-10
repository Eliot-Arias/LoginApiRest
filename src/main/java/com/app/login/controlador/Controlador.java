package com.app.login.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.login.entidad.Usuario;
import com.app.login.servicios.ServicioUsuario;


@RestController
public class Controlador {
	
	@Autowired
	private ServicioUsuario servicioUsuario;
	
	
	@GetMapping("/listarUsuarios")
	public List<Usuario> ListarUsuarios(){
		return servicioUsuario.ListarUsuarios();
		
	}
	@PostMapping("/registrarUsuario")
	public Usuario RegistrarUsuario(@RequestParam String dni, String nombre, String apellidos, String nomUser, String contrasenia, int edad, String correo, String celular) {
		
		Usuario usuario = new Usuario();
		try {
			//usuario.setId(52);
			usuario.setDni(dni);
			usuario.setNombres(nombre);
			usuario.setApellidos(apellidos);
			usuario.setNomUser(nomUser);
			usuario.setContrasenia(contrasenia);
			usuario.setEdad(edad);
			usuario.setCorreo(correo);
			usuario.setCelular(celular);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return servicioUsuario.RegistrarUsuario(usuario);
		
	}
	
	@PostMapping("/validarUsuario")
	public Usuario ValidarUsuario(@RequestParam String nomUser, String contrasenia) {		
		
		return servicioUsuario.ValidarUsuario(nomUser, contrasenia);
	}
	
	@PostMapping("/mostrarUsuario")
	public Usuario MostrarUsuario(@RequestParam String nomUser, String contrasenia) {		
		
		return servicioUsuario.MostrarUsuario(nomUser, contrasenia);
	}
		
}
