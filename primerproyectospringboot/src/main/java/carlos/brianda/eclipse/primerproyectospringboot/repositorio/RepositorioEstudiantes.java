package carlos.brianda.eclipse.primerproyectospringboot.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import carlos.brianda.eclipse.primerproyectospringboot.modelo.Estudiante;

public interface RepositorioEstudiantes
extends JpaRepository<Estudiante, Long> {
	

	
	
	
	public List<Estudiante> findByNombre(String nombre);
	
	@Query("SELECT Max(id) FROM Estudiante")
	public Long findMaxId();
	
	@Query("Select e from Estudiante e where e.nombre=?1 and e.apellidos=?2")
	public Estudiante findNombreApellidos(String nombre, String apellidos);

		
		
	
	
	
}
