package carlos.brianda.eclipse.primerproyectospringboot.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import carlos.brianda.eclipse.primerproyectospringboot.modelo.Estudiante;
import carlos.brianda.eclipse.primerproyectospringboot.repositorio.RepositorioEstudiantes;
import carlos.brianda.eclipse.primerproyectospringboot.repositorio.RepositorioEstudiantesCrud;
@Service
public class ServicioEstudianteImpl implements ServicioEstudiante {

	private final RepositorioEstudiantesCrud repositorioEstudiantes;
	
	public ServicioEstudianteImpl
	(RepositorioEstudiantesCrud repositorioEstudiantes) {
		
		this.repositorioEstudiantes= repositorioEstudiantes;
		
	}
	
	@Override
	public List<Estudiante> findAll() {
		// TODO Auto-generated method stub
		
		// 
		/*return StreamSupport
				.stream(repositorioEstudiantes.findAll().spliterator(), false)
				.collect(Collectors.toList());*/
		
		final ArrayList<Estudiante> list = new ArrayList();
		repositorioEstudiantes.findAll()
		.forEach(estudiante-> list.add(estudiante));
		
		
		return list;
		
		
		//return repositorioEstudiantes.findAll();
	}

	@Override
	public Estudiante findById(Long id) {
		// TODO Auto-generated method stub
		return repositorioEstudiantes.findById(id).get();
	}

	@Override
	public List<Estudiante> findByName(String name) {
		// TODO Auto-generated method stub
		return repositorioEstudiantes.findByNombre(name);
	}

	@Override
	public Estudiante save(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return repositorioEstudiantes.save(estudiante);
	}

	@Override
	public Estudiante update(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return repositorioEstudiantes.save(estudiante);
	}
	
	
	
	

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repositorioEstudiantes.deleteById(id);
	}

	@Override
	public Long getNewId() {
		// TODO Auto-generated method stub
		return repositorioEstudiantes.findMaxId()+10;
	}

}
