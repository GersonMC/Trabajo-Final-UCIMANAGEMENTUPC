package pe.edu.upc.demo.controllers;

import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Medico;
import pe.edu.upc.demo.serviceinterfaces.IMedicoService;

@Controller
@RequestMapping("/mmedicos")
public class MedicoController {

	@Autowired
	private IMedicoService medicoService;

	@GetMapping("/new")
	public String newMedic(Model model) {
		model.addAttribute("medico", new Medico());
		return "medico/Registrar";
	}

	@PostMapping("/save")
	public String saveMedico(@Validated Medico me, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "medico/Registrar";
		} else {
				medicoService.insert(me);
				model.addAttribute("mensaje", "Se registró correctamente");
				return "redirect:/mmedicos/listmedic";		
		}
	}

	@GetMapping("/listmedic")
	public String listMedico(Model model) {
		try {
			model.addAttribute("listaMedicos", medicoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "medico/Listar";
	}

	@RequestMapping("/delete")
	public String deleteMedico(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {
				medicoService.delete(id);
				model.put("listaMedicos", medicoService.list());
			}

		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "medico/Listar";
	}


	@RequestMapping("/goupdate/{id}")
	public String goUpdateMedico(@PathVariable int id, Model model) {
		
		Optional<Medico> objMed= medicoService.listId(id);
		model.addAttribute("me", objMed.get());
		return "medico/Actualizar";
	}
	

	@PostMapping("/update")
	public String updateMedico(Medico m) {
		medicoService.update(m);
		return "redirect:/mmedicos/listmedic";
	}
	
	@RequestMapping("/reporteespecialidad")
	public String especialidadMedico(Map<String,Object> model) {
		model.put("listaEspecialidadMedico", medicoService.especialidadMedico());
		return "reportes/reporteespecialidad";
	}
}
