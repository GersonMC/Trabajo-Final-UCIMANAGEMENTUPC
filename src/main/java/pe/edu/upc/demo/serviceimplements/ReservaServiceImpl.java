package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Reserva;
import pe.edu.upc.demo.repositories.IReservaRepository;
import pe.edu.upc.demo.serviceinterfaces.IReservaService;

@Service
public class ReservaServiceImpl implements IReservaService{

	@Autowired
	private IReservaRepository reservaRepository;
	
	@Override
	public void insert(Reserva reserva) {
		// TODO Auto-generated method stub
		reservaRepository.save(reserva);
	}

	@Override
	public List<Reserva> list() {
		// TODO Auto-generated method stub
		return reservaRepository.findAll();
	}

	@Override
	public void delete(int idReserva) {
		// TODO Auto-generated method stub
		reservaRepository.deleteById(idReserva);
	}

	@Override
	public Optional<Reserva> lisId(int idReserva) {
		// TODO Auto-generated method stub
		return reservaRepository.findById(idReserva);
	}

	@Override
	public void update(Reserva reserva) {
		// TODO Auto-generated method stub
		reservaRepository.save(reserva);
	}


}
