package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Hospital;

public interface IHospitalService {

	public void insert(Hospital hospital);
	
	public List<Hospital> list();
	
	public void delete(int idHospital);
	
	Optional<Hospital> listId(int idHospital);
	
	public void update(Hospital hospital);
	
}
