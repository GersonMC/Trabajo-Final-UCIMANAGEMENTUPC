package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Reserva;

public interface IReservaService {

	public void insert(Reserva reserva);
	
	public List<Reserva> list();
	
	public void delete(int idReserva);
	
	Optional<Reserva> lisId(int idReserva);
	
	public void update(Reserva reserva);
	
}
