package carlos.brianda.eclipse.primerproyectospringboot.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import carlos.brianda.eclipse.primerproyectospringboot.modelo.Estudiante;

public interface RepositorioEstudiantesCrud
extends CrudRepository<Estudiante, Long> {
	
	
	@Query("SELECT e FROM Estudiante e where e.nombre=?1")
	public List<Estudiante> findByNombre(String nombre);
	
	@Query("SELECT Max(id) FROM Estudiante")
	public Long findMaxId();
	
	@Query("Select e from Estudiante e where e.nombre=?1 and e.apellidos=?2")
	public Estudiante findNombreApellidos(String nombre, String apellidos);
		
		
		
	}
	
	
/*
	@Override
	public <S extends Estudiante> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Estudiante> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Estudiante> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Estudiante> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Estudiante> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Estudiante entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Estudiante> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
*/
	
	
