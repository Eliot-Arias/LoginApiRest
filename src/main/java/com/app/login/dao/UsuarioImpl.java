package com.app.login.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.login.entidad.Usuario;
import com.app.login.repositorio.RepositorioUsuario;
import com.app.login.servicios.ServicioUsuario;

@Service
public class UsuarioImpl implements ServicioUsuario{

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Override
	public Usuario RegistrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return repositorioUsuario.save(usuario);
	}

	@Override
	public void ActualizarUsuario(Integer id, String dni, String nombre, String apellidos, String nomUser,
			String contrasenia, int edad, String correo, String celular) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario ValidarUsuario(String nomUser, String contrasenia) {
		// TODO Auto-generated method stub
		
		
		return repositorioUsuario.findByNomUserAndContrasenia(nomUser, contrasenia);

		
	}

	@Override
	public List<Usuario> ListarUsuarios() {
		// TODO Auto-generated method stub
		return repositorioUsuario.findAll();
	}

	@Override
	public Usuario MostrarUsuario(String nomUser, String contrasenia) {
		// TODO Auto-generated method stub
		repositorioUsuario.findByNomUserAndContrasenia(nomUser, contrasenia);
		
		
		return repositorioUsuario.findByNomUserAndContrasenia(nomUser, contrasenia);
	}

}
