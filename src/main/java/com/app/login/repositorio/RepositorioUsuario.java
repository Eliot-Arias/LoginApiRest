package com.app.login.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.login.entidad.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer>{

	Optional<Usuario> findByNomUserAndContrasenia(String nomUser, String contrasenia);
	Usuario findByNomUser(String nomUser);
	Optional<Usuario> findByDni(String dni);
	Usuario findByCorreo(String correo);
	
}
