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

import pe.edu.upc.demo.entities.Reserva;
import pe.edu.upc.demo.serviceinterfaces.IHospitalService;
import pe.edu.upc.demo.serviceinterfaces.IPacienteService;
import pe.edu.upc.demo.serviceinterfaces.IReservaService;

@Controller
@RequestMapping("/rreservas")
public class ReservaController {

	@Autowired
	private IReservaService reservaService;

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private IHospitalService hospitalService;

	@GetMapping("/new")
	public String newReserva(Model model) {
		model.addAttribute("reserva", new Reserva());
		model.addAttribute("listaPacientes", pacienteService.list());
		model.addAttribute("listaHospitales", hospitalService.list());
		return "reserva/frmRegistro";
	}

	@PostMapping("/save")
	public String saveReserva(@Validated Reserva re, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "reserva/frmRegistro";
		} else {
			reservaService.insert(re);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/rreservas/list";
		}
	}

	@GetMapping("/list")
	public String listReserva(Model model) {
		try {
			model.addAttribute("listaReservas", reservaService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/reserva/frmLista";
	}

	@RequestMapping("/delete")
	public String delete(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				reservaService.delete(id);
				model.put("listaReservas", reservaService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "reserva/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateReserva(@PathVariable int id, Model model) {
		Optional<Reserva> objReser = reservaService.lisId(id);
		model.addAttribute("re", objReser.get());
		return "reserva/frmActualiza";
	}

	@RequestMapping("/update")
	public String updateReserva(Reserva r) {
		reservaService.update(r);
		return "redirect:/rreservas/list";
	}



}
