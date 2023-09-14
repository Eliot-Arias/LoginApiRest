package com.app.login.servicios;

import java.util.List;
import org.springframework.stereotype.Service;
import com.app.login.dto.UsuarioDTO;

@Service
public interface ServicioUsuario {
	
	public UsuarioDTO RegistrarUsuario(UsuarioDTO usuarioDTO);
	
	public UsuarioDTO ActualizarUsuario(UsuarioDTO usuarioDTO, Integer id);
	
	public UsuarioDTO ValidarUsuario(String nomUser, String contrasenia);
	
	public void EliminarUsuario(Integer id);
	
	public List<UsuarioDTO> ListarUsuarios();
	
	public UsuarioDTO MostrarUsuario(Integer id);
	
	public UsuarioDTO validarNomUser(String nomUser);
	
	public UsuarioDTO validarDni(String dni);
	
	public UsuarioDTO validarCorreo(String correo);
	
}
