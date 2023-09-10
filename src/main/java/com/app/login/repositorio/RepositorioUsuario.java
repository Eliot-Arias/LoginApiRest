package com.app.login.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.login.entidad.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer>{

	Usuario findByNomUserAndContrasenia(String nomUser, String contrasenia);
	
	
}
