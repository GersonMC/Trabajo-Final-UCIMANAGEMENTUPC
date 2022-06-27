package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Cama;

public interface ICamaService {

	public void insert(Cama cama);
	
	public List<Cama> list();
	
	public void delete(int idCama);
	
	Optional<Cama> lisId(int idCama);
	
	public void update(Cama cama);
	
	//Reporte cantidad camas
	public List<String[]> camastotalquantity();
	public List<String[]> camasquantity();
	public List<String[]> camaDisponible();
}
