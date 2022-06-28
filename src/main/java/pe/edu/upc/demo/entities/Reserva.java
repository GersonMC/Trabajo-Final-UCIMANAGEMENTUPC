package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	
	@ManyToOne
	@JoinColumn(name="idHospital", nullable = false)
	private Hospital hospital;
	
	@ManyToOne
	@JoinColumn(name="idPaciente", nullable = false)
	private Paciente paciente;
	
	@Column(name="estado", nullable=false)
	private String estado;
	

	
	public Reserva() {
		super();
		//TODO Auto-generated constructor stub
	}



	public Reserva(int idReserva, Hospital hospital, Paciente paciente, String estado) {
		super();
		this.idReserva = idReserva;
		this.hospital = hospital;
		this.paciente = paciente;
		this.estado = estado;
	}



	public int getIdReserva() {
		return idReserva;
	}



	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}



	public Hospital getHospital() {
		return hospital;
	}



	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}



	public Paciente getPaciente() {
		return paciente;
	}



	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}




	
	
	
}
