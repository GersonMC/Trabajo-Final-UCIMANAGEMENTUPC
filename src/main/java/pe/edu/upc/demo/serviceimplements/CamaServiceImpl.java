package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Cama;
import pe.edu.upc.demo.repositories.ICamaRepository;
import pe.edu.upc.demo.serviceinterfaces.ICamaService;

@Service
public class CamaServiceImpl implements ICamaService{

	@Autowired
	private ICamaRepository camaRepository;
	
	@Override
	public void insert(Cama cama) {
		// TODO Auto-generated method stub
		camaRepository.save(cama);
	}

	@Override
	public List<Cama> list() {
		// TODO Auto-generated method stub
		return camaRepository.findAll();
	}

	@Override
	public void delete(int idCama) {
		// TODO Auto-generated method stub
		camaRepository.deleteById(idCama);
	}

	@Override
	public Optional<Cama> lisId(int idCama) {
		// TODO Auto-generated method stub
		return camaRepository.findById(idCama);
	}

	@Override
	public void update(Cama cama) {
		// TODO Auto-generated method stub
		camaRepository.save(cama);
	}

	@Override
	public List<String[]> camasquantity() {
		// TODO Auto-generated method stub
		return camaRepository.camasquantity();
	}

	@Override
	public List<String[]> camastotalquantity() {
		// TODO Auto-generated method stub
		return camaRepository.camastotalquantity();
	}

	@Override
	public List<String[]> camaDisponible() {
		// TODO Auto-generated method stub
		return camaRepository.camaDisponible();
	}

}
