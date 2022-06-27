package pe.edu.upc.demo.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Medico")
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedico;

	@NotEmpty(message = "Ingrese su nombre")
	@Column(name = "NombreMedico", length = 50, nullable = false)
	private String NombreMedico;

	@NotEmpty(message = "Ingrese su especialidad")
	@Column(name = "EspecialidadMedico", length = 50, nullable = false)
	private String EspecialidadMedico;

	

	@Size(min = 5, max = 5)
	@NotEmpty(message = "Ingrese su número de colegiatura")
	@Column(name = "NumeroColegiatura", length = 9, nullable = false)
	private String NumeroColegiatura;

	@NotNull(message = "Seleccione una fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fncMedico", nullable = false)
	private Date fncMedico;

	@NotEmpty(message = "Ingrese su email")
	@Email(message = "Correo no válido, ingrese de nuevo")
	@Column(name = "emailMedico", length = 40, nullable = false)
	private String emailMedico;

	@NotEmpty(message = "Ingrese su dirección")
	@Column(name = "direccionMedico", length = 35, nullable = false)
	private String direccionMedico;

	@Size(min = 9, max = 9)
	@NotEmpty(message = "Ingrese su número")
	@Column(name = "NumeroMedico", length = 9, nullable = false)
	private String NumeroMedico;

	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medico(int idMedico, String nombreMedico, String especialidadMedico, String numeroColegiatura,
			Date fncMedico, String emailMedico, String direccionMedico, String numeroMedico) {
		super();
		this.idMedico = idMedico;
		NombreMedico = nombreMedico;
		EspecialidadMedico = especialidadMedico;
		NumeroColegiatura = numeroColegiatura;
		this.fncMedico = fncMedico;
		this.emailMedico = emailMedico;
		this.direccionMedico = direccionMedico;
		NumeroMedico = numeroMedico;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombreMedico() {
		return NombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		NombreMedico = nombreMedico;
	}

	public String getEspecialidadMedico() {
		return EspecialidadMedico;
	}

	public void setEspecialidadMedico(String especialidadMedico) {
		EspecialidadMedico = especialidadMedico;
	}

	public String getNumeroColegiatura() {
		return NumeroColegiatura;
	}

	public void setNumeroColegiatura(String numeroColegiatura) {
		NumeroColegiatura = numeroColegiatura;
	}

	public Date getFncMedico() {
		return fncMedico;
	}

	public void setFncMedico(Date fncMedico) {
		this.fncMedico = fncMedico;
	}

	public String getEmailMedico() {
		return emailMedico;
	}

	public void setEmailMedico(String emailMedico) {
		this.emailMedico = emailMedico;
	}

	public String getDireccionMedico() {
		return direccionMedico;
	}

	public void setDireccionMedico(String direccionMedico) {
		this.direccionMedico = direccionMedico;
	}

	public String getNumeroMedico() {
		return NumeroMedico;
	}

	public void setNumeroMedico(String numeroMedico) {
		NumeroMedico = numeroMedico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMedico);
	}

}
