package pe.edu.upc.demo.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Paciente;
import pe.edu.upc.demo.serviceinterfaces.IPacienteService;

@Controller
@RequestMapping("/ppacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/new")
    public String newPaciente(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "paciente/frmRegistro";
    }

    @PostMapping("/save")
    public String savePaciente(@Validated Paciente pa, BindingResult binres, Model model) {
        if (binres.hasErrors()) {
            return "paciente/frmRegistro";
        } else {
            if (pacienteService.findByUserName(pa.getUsernamePaciente(), 0) == null) {
                pa.setPswrdPaciente(encoder.encode(pa.getPswrdPaciente()));
                pacienteService.insert(pa);
                model.addAttribute("mensaje", "Se registro correctamente");
                return "redirect:/ppacientes/list";
            } else {
                model.addAttribute("error", "El usuario " + pa.getUsernamePaciente() + " ya se encuentra registrado.");
                model.addAttribute("paciente", pa);
                return "paciente/frmRegistro";
            }

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
    public String upddatePerson(Paciente p, Model model) {
        if (pacienteService.findByUserName(p.getUsernamePaciente(), p.getIdPaciente()) == null) {
            pacienteService.update(p);
            return "redirect:/ppacientes/list";
        } else {
            model.addAttribute("error", "El usuario " + p.getUsernamePaciente() + " ya se encuentra registrado.");
            model.addAttribute("pe", p);
            return "paciente/frmActualiza";
        }

    }

    @RequestMapping("/reporte1")
    public String usuarioCategory(Map<String,Object>model) {
  model.put("listaUsuarioCategoria", pacienteService.usuarioCategory());
    	return "paciente/report1";	
    }
    
    
}
