package carlos.brianda.eclipse.primerproyectospringboot.servicios;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
import carlos.brianda.eclipse.primerproyectospringboot.repositorio.RepositorioEstudiantes;

@ExtendWith(SpringExtension.class)
@SpringBootTest

public class ServiceEstudianteImplIT {
	
	@Autowired
	private final RepositorioEstudiantes repositorioEstudiantes=null;
	
	@Autowired
	private final ServicioEstudianteImpl servicioEstudiante=null;
	
	
	@BeforeEach
	void setUp() throws Exception {
       
		
		
	}
	
	
	 @Transactional
	 @Test
	 public void testFindByName() {
		 
		 
		 
		assertTrue( repositorioEstudiantes.findByNombre("David").size()
					== servicioEstudiante.findByName("David").size());
				
		 
		 
		 
	 }
	
	
}
