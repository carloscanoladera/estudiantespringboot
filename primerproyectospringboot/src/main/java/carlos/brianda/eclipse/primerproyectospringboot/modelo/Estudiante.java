package carlos.brianda.eclipse.primerproyectospringboot.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

import javax.persistence.*;


@Entity
public class Estudiante {
	@Id
	private long id;
	private String nombre="";
	private String apellidos="";
	private String curso="";
	
	
	public Estudiante() {
		
		
	}
	public Estudiante(long id, String nombre, String apellidos, String curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.curso = curso;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", curso=" + curso + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, curso, id, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(curso, other.curso) && id == other.id
				&& Objects.equals(nombre, other.nombre);
	}
	
	
	
	

}
