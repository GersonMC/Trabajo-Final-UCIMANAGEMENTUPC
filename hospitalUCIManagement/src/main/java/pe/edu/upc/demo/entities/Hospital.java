package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hospital")
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHospital;
	
	@Column(name = "nameHospital", length = 48, nullable = false)
	private String nameHospital;
	
	@Column(name = "adressHospital", length = 48, nullable = false)
	private String adressHospital;

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(int idHospital, String nameHospital, String adressHospital) {
		super();
		this.idHospital = idHospital;
		this.nameHospital = nameHospital;
		this.adressHospital = adressHospital;
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
	
}
