package carlos.brianda.eclipse.primerproyectospringboot.bootstrap;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import carlos.brianda.eclipse.primerproyectospringboot.modelo.Estudiante;
import carlos.brianda.eclipse.primerproyectospringboot.repositorio.RepositorioEstudiantes;

@Component
@Transactional
public class Bootstrap implements CommandLineRunner{

    private final RepositorioEstudiantes repositorioEstudiantes;

    public Bootstrap(RepositorioEstudiantes repositorioEstudiantes) {
        this.repositorioEstudiantes = repositorioEstudiantes;
    }

    @Override
    public void run(String... args) throws Exception {
    	
    	Estudiante estudiante = new Estudiante(1, "David", "Berlinches", "2DAM");
    	repositorioEstudiantes.save(estudiante);
    	
    	System.out.println(" Estudiante guardado " + estudiante.toString());
    	
       	estudiante = new Estudiante(2, "David", "Jimenez", "2DAM");
    	repositorioEstudiantes.save(estudiante);
    	
    	System.out.println(" Estudiante guardado " + estudiante.toString());
    	
       	estudiante = new Estudiante(3, "Javier", "Hidalgo", "2DAM");
    	repositorioEstudiantes.save(estudiante);
  
    	System.out.println(" Estudiante guardado " + estudiante.toString());

    	estudiante = new Estudiante(4, "Alai", "Rueda", "2DAM");
    	repositorioEstudiantes.save(estudiante);
  
    	System.out.println(" Estudiante guardado " + estudiante.toString());
    	
    	estudiante = new Estudiante(5, "Jorge", "Pastor", "2DAM");
    	repositorioEstudiantes.save(estudiante);
  
    	System.out.println(" Estudiante guardado " + estudiante.toString());
    	
    	estudiante = new Estudiante(6, "Bruno", "Martinez", "2DAM");
    	repositorioEstudiantes.save(estudiante);
  
    	System.out.println(" Estudiante guardado " + estudiante.toString());
    	
    }
    
    
}