package carlos.brianda.eclipse.primerproyectospringboot.servicios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;



import static org.mockito.Mockito.*;

import java.util.Optional;

import carlos.brianda.eclipse.primerproyectospringboot.modelo.Estudiante;
import carlos.brianda.eclipse.primerproyectospringboot.repositorio.RepositorioEstudiantes;
import carlos.brianda.eclipse.primerproyectospringboot.repositorio.RepositorioEstudiantesCrud;



class ServicioEstudianteImplTest {

	
	  @Mock	  
	  RepositorioEstudiantesCrud repositorioEstudiante;
	  
	  ServicioEstudiante servicioEstudiante;
	  
	  
	
	
	@BeforeEach
	void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
		servicioEstudiante = new ServicioEstudianteImpl(repositorioEstudiante);
	}
	
	
	

	@Test
	void testSave() {
		
		Estudiante est = new Estudiante(100, "Carlos","Lopez","2DAM");
		
		Optional<Estudiante> estOpt = Optional.of(est);
		 when(repositorioEstudiante.save(any())).thenReturn(est);
		 
		 when(repositorioEstudiante.findById(anyLong())).thenReturn(estOpt);
		
		est= servicioEstudiante.save(est);
		
		Estudiante estRec = repositorioEstudiante.findById(est.getId())
							.map(estudiante->estudiante)
							.orElse(new Estudiante());
		
		assertTrue(est.equals(estRec));
							
							
		
		
	}

}
