package carlos.brianda.eclipse.primerproyectospringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import carlos.brianda.eclipse.primerproyectospringboot.modelo.Estudiante;
import carlos.brianda.eclipse.primerproyectospringboot.servicios.ServicioEstudiante;

@Controller
@RequestMapping({""})
public class ControladorEstudiante {
	
	private ServicioEstudiante  serviciosEstudiantes;
	
	public ControladorEstudiante(ServicioEstudiante  serviciosEstudiantes) {
		this.serviciosEstudiantes=serviciosEstudiantes;
		
	}

	@GetMapping()
	public String getEstudiantes(Model model) {
		
		
		model.addAttribute("estudiantes", serviciosEstudiantes.findAll());
		
		return "index";
	}
	
	@RequestMapping("/estudiante/{id}")
	public String getEstudiante(@PathVariable String id, Model model) {
		
		
		model.addAttribute("estudiante", serviciosEstudiantes.findById(Long.valueOf(id)));
		
		return "estudiante/estudianteview";
	}
	
	
	@RequestMapping("/estudiante/new")
	
	public String createNewEstudiante(Model model) {
		
		Estudiante estudiante = new Estudiante();
		
		estudiante.setId(serviciosEstudiantes.getNewId());
		model.addAttribute("estudiante", estudiante);

		return "/estudiante/estudianteform.html";
		
		
	}
	

	
	
	@RequestMapping("/estudiante/update/{id}")
	
	public String getEstudianteForm(@PathVariable String id, Model model) {
		
		
		model.addAttribute("estudiante", serviciosEstudiantes.findById(Long.valueOf(id)));

		return "/estudiante/estudianteform.html";
	}
	
	@PostMapping("/estudiante/")
	
	public String updateEstudianteMethod(@ModelAttribute("estudiante") Estudiante estudiante, BindingResult bindingResult) {
		
		serviciosEstudiantes.save(estudiante);

		return "redirect:/estudiante/"+estudiante.getId();
	}

}
