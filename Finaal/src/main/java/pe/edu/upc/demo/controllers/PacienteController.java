package pe.edu.upc.demo.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Paciente;
import pe.edu.upc.demo.serviceinterface.IPacienteService;

@Controller
@RequestMapping("/ppacientes")
public class PacienteController {
	@Autowired
	private IPacienteService pacienteService;

	@GetMapping("/new")
	public String newPaciente(Model model) {
		model.addAttribute("p", new Paciente());
		return "paciente/frmRegistro";

	}

	@PostMapping("/save")
	public String savePaciente(@Valid Paciente pa, BindingResult binres, Model model) {

		if (binres.hasErrors()) {
			return "paciente/frmRegistro";
		} else {
			pacienteService.insert(pa);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/ppacientes/list";
		}

	}

	@GetMapping("/list")
	public String listPaciente(Model model) {
		try {
			model.addAttribute("listaPacientes", pacienteService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/paciente/frmLista";

	}

	@RequestMapping("/delete")
	public String deletePaciente(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				pacienteService.delete(id);
				model.put("listaPacientes", pacienteService.list());

			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "paciente/frmLista";
	}

	@RequestMapping("/goupdate/{id}")

	public String goUpdatePaciente(@PathVariable int id, Model model) {
		Optional<Paciente> objPac = pacienteService.listId(id);
		model.addAttribute("pe", objPac.get());
		return "paciente/frmActualiza";
	}

	@PostMapping("/update")
	public String upddatePerson(Paciente p) {
		pacienteService.update(p);
		return "redirect:/ppacientes/list";
	}

}
