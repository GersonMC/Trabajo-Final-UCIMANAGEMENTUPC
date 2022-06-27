package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cama")
public class Cama {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCama;

	@ManyToOne
	@JoinColumn(name = "idHospital", nullable = false)
	private Hospital hospital;

	@Size(max = 8)
	@NotEmpty(message = "Ingrese el codigo de la cama")
	@Column(name = "codigocama", length = 8, nullable = false)
	private String codigocama;
	

	@Column(name = "condicioncama", nullable = false)
	private String condicioncama;


	@Column(name = "pisoCama", length = 25, nullable = false)
	private String pisoCama;


	@Column(name = "disponibilidadCama", length = 20, nullable = false)
	private String disponibilidadCama;

	public Cama() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Cama(int idCama, @NotNull Hospital hospital,
			@Size(max = 8) @NotEmpty(message = "Ingrese el codigo de la cama") String codigocama,
			@NotNull String condicioncama, @NotNull String pisoCama, @NotNull String disponibilidadCama) {
		super();
		this.idCama = idCama;
		this.hospital = hospital;
		this.codigocama = codigocama;
		this.condicioncama = condicioncama;
		this.pisoCama = pisoCama;
		this.disponibilidadCama = disponibilidadCama;
	}



	public int getIdCama() {
		return idCama;
	}

	public void setIdCama(int idCama) {
		this.idCama = idCama;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}


	public String getPisoCama() {
		return pisoCama;
	}

	public void setPisoCama(String pisoCama) {
		this.pisoCama = pisoCama;
	}

	public String getDisponibilidadCama() {
		return disponibilidadCama;
	}

	public void setDisponibilidadCama(String disponibilidadCama) {
		this.disponibilidadCama = disponibilidadCama;
	}

	public String getCodigocama() {
		return codigocama;
	}

	public void setCodigocama(String codigocama) {
		this.codigocama = codigocama;
	}



	public String getCondicioncama() {
		return condicioncama;
	}

	public void setCondicioncama(String condicioncama) {
		this.condicioncama = condicioncama;
	}

}
