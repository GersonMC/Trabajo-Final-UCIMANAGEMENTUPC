package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Paciente;
import pe.edu.upc.demo.repositories.IPacienteRepository;
import pe.edu.upc.demo.serviceinterface.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService {
	@Autowired
	private IPacienteRepository pacienteRepository;

	@Override
	public void insert(Paciente paciente) {
		pacienteRepository.save(paciente);

	}

	@Override
	public List<Paciente> list() {

		return pacienteRepository.findAll();
	}

	@Override
	public void delete(int idPaciente) {

		pacienteRepository.deleteById(idPaciente);
	}

	@Override
	public Optional<Paciente> listId(int idPaciente) {
		// TODO Auto-generated method stub
		return pacienteRepository.findById(idPaciente);
	}

	@Override
	public void update(Paciente paciente) {
		pacienteRepository.save(paciente);

	}

}
