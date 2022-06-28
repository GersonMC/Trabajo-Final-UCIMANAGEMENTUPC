package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Paciente;

public interface IPacienteService {

    public void insert(Paciente paciente);

    public List<Paciente> list();

    public void delete(int idPaciente);

    Optional<Paciente> listId(int idPaciente);

    public void update(Paciente paciente);

    public Paciente findByUserName(String user, int id);
    public List<String[]>usuarioCategory();
}
