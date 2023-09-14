package com.app.login.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.login.dto.UsuarioDTO;
import com.app.login.entidad.Usuario;
import com.app.login.excepciones.ResourceNotFoundExcepcion;
import com.app.login.repositorio.RepositorioUsuario;
import com.app.login.servicios.ServicioUsuario;

@Service
public class UsuarioImpl implements ServicioUsuario{

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Override
	public UsuarioDTO RegistrarUsuario(UsuarioDTO usuarioDTO) {
		
		Usuario usuario = mapearEntidad(usuarioDTO);
		Usuario nuevoUsuario = repositorioUsuario.save(usuario);
		
		UsuarioDTO usuarioRespuesta = mapearDto(nuevoUsuario);
		return usuarioRespuesta;
	}

	@Override
	public List<UsuarioDTO> ListarUsuarios() {

		List<Usuario> usuarios = repositorioUsuario.findAll();
		return usuarios.stream().map(usuario -> mapearDto(usuario)).collect(Collectors.toList());
		
	}
	
	@Override
	public UsuarioDTO ActualizarUsuario(UsuarioDTO usuarioDTO, Integer id) {
		
		Usuario usuario = repositorioUsuario.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario", "ID", id));
		
		usuario.setDni(usuarioDTO.getDni());
		usuario.setNombres(usuarioDTO.getNombres());
		usuario.setApellidos(usuarioDTO.getApellidos());
		usuario.setNomUser(usuarioDTO.getNomUser());
		usuario.setContrasenia(usuarioDTO.getContrasenia());
		usuario.setEdad(usuarioDTO.getEdad());
		usuario.setCorreo(usuarioDTO.getCorreo());
		usuario.setCelular(usuarioDTO.getCelular());
		
		Usuario usuarioActualizado = repositorioUsuario.save(usuario);
		
		return mapearDto(usuario);
	}

	@Override
	public UsuarioDTO ValidarUsuario(String nomUser, String contrasenia) {
		
		Optional<Usuario> usuarioConsulta = repositorioUsuario.findByNomUserAndContrasenia(nomUser, contrasenia);
		Usuario usuario = usuarioConsulta.orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario o Contraseña Erroneos", "Usuario | Contraseña", nomUser + " " + contrasenia));		
		
		return mapearDto(usuario);
	}

	@Override
	public UsuarioDTO MostrarUsuario(Integer id) {
		
		Usuario usuario = repositorioUsuario.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario", "ID", id));
		
		return mapearDto(usuario);
	}

	
	@Override
	public UsuarioDTO validarNomUser(String nomUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO validarDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO validarCorreo(String correo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	//Convierte entidad a DTO
	private UsuarioDTO mapearDto(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setDni(usuario.getDni());
		usuarioDTO.setNombres(usuario.getNombres());
		usuarioDTO.setApellidos(usuario.getApellidos());
		usuarioDTO.setNomUser(usuario.getNomUser());
		usuarioDTO.setContrasenia(usuario.getContrasenia());
		usuarioDTO.setEdad(usuario.getEdad());
		usuarioDTO.setCorreo(usuario.getCorreo());
		usuarioDTO.setCelular(usuario.getCelular());		
		
		return usuarioDTO;
	}
	
	
	//Convierte DTO a entidad
	private Usuario mapearEntidad(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		
		usuario.setDni(usuarioDTO.getDni());
		usuario.setNombres(usuarioDTO.getNombres());
		usuario.setApellidos(usuarioDTO.getApellidos());
		usuario.setNomUser(usuarioDTO.getNomUser());
		usuario.setContrasenia(usuarioDTO.getContrasenia());
		usuario.setEdad(usuarioDTO.getEdad());
		usuario.setCorreo(usuarioDTO.getCorreo());
		usuario.setCelular(usuarioDTO.getCelular());		
		
		return usuario;
	}

	@Override
	public void EliminarUsuario(Integer id) {
		// TODO Auto-generated method stub
		repositorioUsuario.deleteById(id);
	}

}
