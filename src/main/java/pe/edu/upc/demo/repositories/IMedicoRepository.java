package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Medico;


@Repository
public interface IMedicoRepository extends JpaRepository<Medico, Integer> {

	
	
	@Query(value="Select m.especialidad_medico, count(m.especialidad_medico) from medico m group by m.especialidad_medico", nativeQuery=true)
	public List<String[]>especialidadMedico();
	
}
