package pe.edu.upc.demo.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Hospital")
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHospital;
	
	
	@NotEmpty(message = "Ingrese el nombre del hospital")
	@Column(name = "nameHospital", length = 48, nullable = false)
	private String nameHospital;
	@Size(max = 30)
	@NotEmpty(message = "Ingrese la direccion del hospital")
	@Column(name = "adressHospital", length = 40, nullable = false)
	private String adressHospital;
	
	@ManyToOne
	@JoinColumn(name="idMedico", nullable = false)
	private Medico medico;

	public Hospital() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Hospital(int idHospital, String nameHospital, String adressHospital, Medico medico) {
		super();
		this.idHospital = idHospital;
		this.nameHospital = nameHospital;
		this.adressHospital = adressHospital;
		this.medico = medico;
	}

	public int getIdHospital() {
		return idHospital;
	}

	public void setIdHospital(int idHospital) {
		this.idHospital = idHospital;
	}

	public String getNameHospital() {
		return nameHospital;
	}

	public void setNameHospital(String nameHospital) {
		this.nameHospital = nameHospital;
	}

	public String getAdressHospital() {
		return adressHospital;
	}

	public void setAdressHospital(String adressHospital) {
		this.adressHospital = adressHospital;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idHospital);
	}

}
