package com.app.login.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.login.dto.UsuarioDTO;
import com.app.login.servicios.ServicioUsuario;


@RestController
@RequestMapping("/api/login")
public class Controlador {
	
	@Autowired
	private ServicioUsuario servicioUsuario;
	
	
	
	@PostMapping("/registrarUsuario")
	public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioDTO usarioDTO){
		
		return new ResponseEntity<>(servicioUsuario.RegistrarUsuario(usarioDTO), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/listar")
	public List<UsuarioDTO> listarPublicaciones(){		
		
		return servicioUsuario.ListarUsuarios();
		
	}
	
	@PostMapping("/validarUsuario")
	public ResponseEntity<UsuarioDTO> validarUsuario(@RequestParam String nomUser, @RequestParam String contrasenia){
		UsuarioDTO usuarioDTO = servicioUsuario.ValidarUsuario(nomUser, contrasenia);
		if (usuarioDTO != null) {
			return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(usuarioDTO, HttpStatus.UNAUTHORIZED);
		}
		
	}
	
	@DeleteMapping("/EliminarUsuario/{id}")
	public void EliminarUsuario(@PathVariable Integer id) {
		servicioUsuario.EliminarUsuario(id);
	}
	
}
