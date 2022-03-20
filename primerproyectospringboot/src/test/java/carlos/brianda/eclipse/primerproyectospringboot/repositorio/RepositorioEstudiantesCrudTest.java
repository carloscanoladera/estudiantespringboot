package carlos.brianda.eclipse.primerproyectospringboot.repositorio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.hibernate.hql.spi.id.IdTableSupportStandardImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import carlos.brianda.eclipse.primerproyectospringboot.modelo.Estudiante;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RepositorioEstudiantesCrudTest {
	
	 @Autowired
	    RepositorioEstudiantesCrud repositorioEstudiante;
	
	 
	 
	 @BeforeEach	 
	 void setUp() {
		 
		 
		 Estudiante estudiante = new Estudiante(4,"Carlos","Lopez","2DAM");
		 
		 repositorioEstudiante.save(estudiante);
		 
	 }

	@Test
	void testFindByNombre() {
		
		String nombre= 
				
				StreamSupport
				.stream(repositorioEstudiante.findAll().spliterator(), false)
				.findAny()
				.map(estudiante->estudiante.getNombre())
				.orElse("");
				
		
		
		assertTrue( repositorioEstudiante.findByNombre(nombre).size()>0);
		
		
			}

	@Test
	void testFindMaxId() {
	 Long id = StreamSupport
				.stream(repositorioEstudiante.findAll().spliterator(), false)
				.collect(Collectors.toList())
				.stream()
				.map((estudiante) -> {
					
					
					LinkedList<Estudiante> listaEstudiantes = new LinkedList ();
					
					listaEstudiantes.add(estudiante);
					return listaEstudiantes;
					
				})
				.findFirst()
				.map(est-> est.getLast().getId()).orElse(-1L);
				
		
		assertEquals(id , repositorioEstudiante.findMaxId());
		
				
				
	}

	@Test
	void testFindNombreApellidos() {
		Estudiante estudianteRep= 
				
				StreamSupport
				.stream(repositorioEstudiante.findAll().spliterator(), false)
				.findAny()
				.map(estudiante->estudiante)
				.orElse(new Estudiante());
		
		Estudiante estudianteByName = repositorioEstudiante
				.findNombreApellidos(estudianteRep.getNombre(), estudianteRep.getApellidos());
		
		assertTrue(estudianteByName.equals(estudianteRep));
		
	}

}
