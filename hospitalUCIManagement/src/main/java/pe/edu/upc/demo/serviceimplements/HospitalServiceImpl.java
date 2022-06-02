package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Hospital;
import pe.edu.upc.demo.repositories.IHospitalRepository;
import pe.edu.upc.demo.serviceinterfaces.IHospitalService;

@Service
public class HospitalServiceImpl implements IHospitalService{
	
	@Autowired
	private IHospitalRepository hospitalRepository;
	
	@Override
	public void insert(Hospital hospital) {
	
		hospitalRepository.save(hospital);
	}
	
	@Override
	public List<Hospital> list() {
		
		return hospitalRepository.findAll();
	}
	
	@Override
	public void delete(int idHospital) {
		
		hospitalRepository.deleteById(idHospital);
	}
	
	@Override
	public Optional<Hospital> listId(int idHospital) {
		
		return hospitalRepository.findById(idHospital);
	}
	
	@Override
	public void update(Hospital hospital) {
		
		hospitalRepository.save(hospital);
	}
	
}
