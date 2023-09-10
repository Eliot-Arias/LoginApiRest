package com.app.login.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario {
	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String dni;
	
	private String nombres;
	
	private String apellidos;
	
	@Column(name = "nom_user")
	private String nomUser;
	
	private String contrasenia;
	
	private int edad;
	
	private String correo;
	
	private String celular;	
}
