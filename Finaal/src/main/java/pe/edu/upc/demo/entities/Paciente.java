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
@Table(name = "Paciente")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPaciente;

	@Column(name = "fullNamePaciente", length = 48, nullable = false)
	private String fullNamePaciente;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "birthDatePaciente",nullable = false)
	private Date birthDatePaciente;
	
	@Column(name = "emailPaciente", length = 35, nullable = false)
	private String emailPaciente;
	
	
	@Column(name = "direccionPaciente", length = 48, nullable = false)
	private String direccionPaciente;
	
	@Column(name = "celularPaciente", length = 9, nullable = false)
	private String celularPaciente;
	
	@Column(name = "dniPaciente", length = 8, nullable = false)
	private String dniPaciente;

	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(int idPaciente, String fullNamePaciente, Date birthDatePaciente, String emailPaciente,
			String direccionPaciente, String celularPaciente, String dniPaciente) {
		super();
		this.idPaciente = idPaciente;
		this.fullNamePaciente = fullNamePaciente;
		this.birthDatePaciente = birthDatePaciente;
		this.emailPaciente = emailPaciente;
		this.direccionPaciente = direccionPaciente;
		this.celularPaciente = celularPaciente;
		this.dniPaciente = dniPaciente;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getFullNamePaciente() {
		return fullNamePaciente;
	}

	public void setFullNamePaciente(String fullNamePaciente) {
		this.fullNamePaciente = fullNamePaciente;
	}

	public Date getBirthDatePaciente() {
		return birthDatePaciente;
	}

	public void setBirthDatePaciente(Date birthDatePaciente) {
		this.birthDatePaciente = birthDatePaciente;
	}

	public String getEmailPaciente() {
		return emailPaciente;
	}

	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
	}

	public String getDireccionPaciente() {
		return direccionPaciente;
	}

	public void setDireccionPaciente(String direccionPaciente) {
		this.direccionPaciente = direccionPaciente;
	}

	public String getCelularPaciente() {
		return celularPaciente;
	}

	public void setCelularPaciente(String celularPaciente) {
		this.celularPaciente = celularPaciente;
	}

	public String getDniPaciente() {
		return dniPaciente;
	}

	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente = dniPaciente;
	}

}
