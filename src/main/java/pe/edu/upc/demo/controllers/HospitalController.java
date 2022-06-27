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

import pe.edu.upc.demo.entities.Hospital;
import pe.edu.upc.demo.serviceinterfaces.IHospitalService;
import pe.edu.upc.demo.serviceinterfaces.IMedicoService;

@Controller
@RequestMapping("/hhospitals")
public class HospitalController {

	@Autowired
	private IHospitalService hospitalService;

	@Autowired
	private IMedicoService medicoService;
	
	@GetMapping("/new")
	public String newHospital(Model model) {
		model.addAttribute("hospital", new Hospital());
		model.addAttribute("listaMedicos", medicoService.list());
		return "hospital/frmRegistro";
	}

	@PostMapping("/save")
	public String saveHospital(@Validated Hospital ho, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			return "hospital/frmRegistro";
		} else {
			hospitalService.insert(ho);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/hhospitals/list";
		}
	}

	@GetMapping("/list")
	public String listHospital(Model model) {

		try {
			model.addAttribute("listaHospitales", hospitalService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/hospital/frmLista";
	}

	@RequestMapping("/delete")
	public String delete(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {
				hospitalService.delete(id);
				model.put("listaHospitales", hospitalService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "hospital/frmLista";
	}

	// va a llevar el objetivo y lo va mostrar en el formulario 
	@RequestMapping("/goupdate/{id}")
	public String goUpdateHospital(@PathVariable int id, Model model) {

		Optional<Hospital> objHos = hospitalService.lisId(id);
		model.addAttribute("ho", objHos.get());
		return "hospital/frmActualiza";
	}

	//guardar los cambios
	@RequestMapping("/update")
	public String updateHospital(Hospital h) {

		hospitalService.update(h);
		return "redirect:/hhospitals/list";
	}

	//reporte 3
	@RequestMapping("/report3")
	public String reservasHospital(Map<String,Object> model) {
		model.put("listaReservasHosiptal", hospitalService.reservasHospital());
		return "reportes/reporteReservaHospital";
	}
	
	//reporte 3
		@RequestMapping("/reportcantm")
		public String cantme(Map<String,Object> model) {
			model.put("listacantme", hospitalService.cantme());
			return "reportes/reportecantme";
		}
		



}
