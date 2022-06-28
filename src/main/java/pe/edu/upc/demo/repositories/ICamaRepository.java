package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demo.entities.Cama;

@Repository
public interface ICamaRepository extends JpaRepository<Cama, Integer> {
	// Reporte cantidad camas
	@Query(value = "Select count (distinct c.id_cama)\r\n"
			+ "from cama c", nativeQuery = true)
	public List<String[]> camastotalquantity();

	@Query(value = "Select h.name_hospital, count(c.id_cama)\r\n" + "from cama c join  hospital h\r\n"
			+ "on c.id_hospital=h.id_hospital\r\n" + "group by h.name_hospital", nativeQuery = true)
	public List<String[]> camasquantity();

	
	//REPORTE
	@Query(value="Select c.disponibilidad_cama,count (c.id_cama) from cama c  "
			+ "group by c.disponibilidad_cama",nativeQuery = true)
	public List<String[]>camaDisponible();
}
