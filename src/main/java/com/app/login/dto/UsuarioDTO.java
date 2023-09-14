package com.app.login.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
	private int id;
	
	private String dni;
	
	private String nombres;
	
	private String apellidos;
	
	private String nomUser;
	
	private String contrasenia;
	
	private int edad;
	
	private String correo;
	
	private String celular;
}
