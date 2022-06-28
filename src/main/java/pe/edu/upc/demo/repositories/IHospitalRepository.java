package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Hospital;

@Repository
public interface IHospitalRepository extends JpaRepository<Hospital, Integer> {

	// reporte 3
	@Query(value="Select  h.name_hospital, count(r.id_reserva) "
			+ "from hospital h join reserva r "
			+ "on h.id_hospital = r.id_hospital group by h.name_hospital",nativeQuery = true)
	public List<String[]>reservasHospital();
	
	//reporte 26 

	@Query(value="Select h.name_hospital,count(m.id_medico) from hospital h join medico m "
		+ "on h.id_medico=m.id_medico group by h.name_hospital",nativeQuery=true)
public List<String[]>cantme();


}
