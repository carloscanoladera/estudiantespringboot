package carlos.brianda.eclipse.primerproyectospringboot.servicios;

import java.util.List;

import carlos.brianda.eclipse.primerproyectospringboot.modelo.Estudiante;

public interface ServicioEstudiante {
	
	
	public List<Estudiante> findAll();
	
	public Estudiante findById(Long id);
	public List<Estudiante> findByName(String name);
	public Estudiante save(Estudiante estudiante);
	public Estudiante update(Estudiante estudiante);
	
	public Long getNewId();
	public void delete(Long id);
	

}
