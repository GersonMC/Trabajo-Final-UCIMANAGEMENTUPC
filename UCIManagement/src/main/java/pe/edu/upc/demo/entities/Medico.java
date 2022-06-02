package pe.edu.upc.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Medico")
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedico;

	@Column(name = "NombreMedico", length = 50, nullable = false)
	private String NombreMedico;
	
	@Column(name = "EspecialidadMedico", length = 50, nullable = false)
	private String EspecialidadMedico;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fncMedico", nullable = false)
	private Date fncMedico;

	@Column(name = "emailMedico", length = 40, nullable = false)
	private String emailMedico;

	@Column(name = "direccionMedico", length = 35, nullable = false)
	private String direccionMedico;
	
	@Column(name = "NumeroMedico", length = 9, nullable = false)
	private String NumeroMedico;

	public Medico() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Medico(int idMedico, String nombreMedico, String especialidadMedico, Date fncMedico, String emailMedico,
			String direccionMedico, String numeroMedico) {
		super();
		this.idMedico = idMedico;
		NombreMedico = nombreMedico;
		EspecialidadMedico = especialidadMedico;
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

	
	

}
