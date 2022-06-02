package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Medico;
import pe.edu.upc.demo.repositories.IMedicoRepository;
import pe.edu.upc.demo.serviceinterfaces.IMedicoService;

@Service
public class MedicoServiceImpl implements IMedicoService {
	@Autowired
	private IMedicoRepository medicoRepository;

	@Override
	public void insert(Medico medico) {
		medicoRepository.save(medico);
	}

	@Override
	public List<Medico> list() {
		// TODO Auto-generated method stub
		return medicoRepository.findAll();

	}

	@Override
	public void delete(int idMedico) {
		// TODO Auto-generated method stub
		medicoRepository.deleteById(idMedico);
	}

	@Override
	public Optional<Medico> listId(int idMedico) {
		// TODO Auto-generated method stub
		return medicoRepository.findById(idMedico);
	}

	@Override
	public void update(Medico medico) {
		// TODO Auto-generated method stub
		medicoRepository.save(medico);
	}

}
