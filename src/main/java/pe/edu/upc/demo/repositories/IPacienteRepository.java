package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Paciente;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {

    @Query(value = "select p from Paciente p where p.usernamePaciente=?1 and (?2 = 0 or p.idPaciente !=?2)")
    public Paciente findByUserName(String user , int id);

    //reporte
    @Query(value="Select p.rol_paciente,count (p.id_paciente) from paciente p "
    		+  "group by p.rol_paciente",nativeQuery=true)
   
    public List<String[]>usuarioCategory();

}


