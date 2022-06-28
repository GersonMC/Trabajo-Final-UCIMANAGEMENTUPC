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

import pe.edu.upc.demo.entities.Cama;
import pe.edu.upc.demo.serviceinterfaces.ICamaService;
import pe.edu.upc.demo.serviceinterfaces.IHospitalService;

@Controller
@RequestMapping("/ccamas")
public class CamaController {

	@Autowired
	private ICamaService camaService;
	
	@Autowired
	private IHospitalService hospitalService;
	
	@GetMapping("/new")
	public String newCama(Model model) {
		model.addAttribute("cama", new Cama());
		model.addAttribute("listaHospitales", hospitalService.list());
		return "cama/frmRegistro";
	}
	
	@PostMapping("/save")
	public String saveCama(@Validated Cama ca, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "cama/frmRegistro";
		}else {
			camaService.insert(ca);
			model.addAttribute("mensaje", "Se registro correctamente");
			return "redirect:/ccamas/list";
		}
	}
	
	@GetMapping("/list")
	public String listCama(Model model) {
		try {
			model.addAttribute("listaCamas", camaService.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "/cama/frmLista";
	}
	
	@RequestMapping("/delete")
	public String delete(Map<String, Object> model, @RequestParam(value= "id") Integer id) {
		try {
			if (id!=null && id>0) {
				camaService.delete(id);
				model.put("listaCamas", camaService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("error", e.getMessage());
		}
		return "cama/frmLista";
	}
	
	// va a llevar el objetivo y lo va mostrar en el formulario 
	@RequestMapping("/goupdate/{id}")
	public String goUpdateCama(@PathVariable int id, Model model) {
		Optional<Cama> objCam=camaService.lisId(id);
		model.addAttribute("ca", objCam.get());
		return "cama/frmActualiza";
	}
	
	//guardar los cambios
	@RequestMapping("/update")
	public String updateCama(Cama c) {
		camaService.update(c);
		return "redirect:/ccamas/list";
	}
	
	
	@RequestMapping("/reporte1")
	public String rpcantidadcamas(Map<String, Object> model) {
		
		model.put("listacantidadCamas", camaService.camasquantity());
		model.put("listacantidadtotalCamas", camaService.camastotalquantity());
		return "reportes/reportecamascantidad";
		
	}
	 
	@RequestMapping("/reporteDisponibilidad")
	public String camaDisponibl(Map<String, Object> model) {
	model.put("listacamadisponile",camaService.camaDisponible());
		
		return "reportes/reportecamadisponible";
}
}