package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Medico;

public interface IMedicoService {

	public void insert(Medico medico);

	public List<Medico> list();

	
	public void delete(int idMedico);
	
	
	
	Optional<Medico> listId(int idMedico);
	public void update(Medico medico);

	//Reporte especialidad medicos
	public List<String[]>especialidadMedico();
}
