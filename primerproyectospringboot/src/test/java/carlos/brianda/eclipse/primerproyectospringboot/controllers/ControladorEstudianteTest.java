package carlos.brianda.eclipse.primerproyectospringboot.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import carlos.brianda.eclipse.primerproyectospringboot.modelo.Estudiante;
import carlos.brianda.eclipse.primerproyectospringboot.repositorio.RepositorioEstudiantes;
import carlos.brianda.eclipse.primerproyectospringboot.servicios.ServicioEstudiante;



class ControladorEstudianteTest {


	@Mock
	private ServicioEstudiante servicioEstudiante;
	@InjectMocks
	private ControladorEstudiante controladorEstudiante;
    private MockMvc mockMvc;	
	@BeforeEach
	void setUp() {
		
		MockitoAnnotations.openMocks(this);
		
		//controladorEstudiante = new ControladorEstudiante(servicioEstudiante);
	    mockMvc = MockMvcBuilders.standaloneSetup(controladorEstudiante)
                .build();
	
	}
	
	@Test
	void testGetEstudiante() throws Exception {
		Estudiante estu = new Estudiante(1, "Nombre","Apellidos" ,"Curso");
		 when(servicioEstudiante.findById(any())).thenReturn(estu);
		
		 mockMvc.perform(get("/estudiante/1"))
         .andExpect(status().isOk())
         .andExpect(view().name("estudiante/estudianteview"))
         .andExpect(model().attributeExists("estudiante"));
		
		
		
	}
	
	@Test
	void testUpdateEstudianteForm() throws Exception {
		
		
        Estudiante estudiante = new Estudiante(2, "nombre","apellidos", "curso");
      

        when(servicioEstudiante.save(any())).thenReturn(estudiante);

        mockMvc.perform(post("/estudiante/")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "2")
                .param("nombre", "nombre2")
                .param("apellidos", "apellidos2")
                .param("Curso", "Curso2")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/estudiante/2"));
	
	}

}
