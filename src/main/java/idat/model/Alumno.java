package idat.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idalumno;
	private String alumno;
	private String celular;

	public Integer getId() {
		return idalumno;
	}

	public void setId(Integer id) {
		this.idalumno = id;
	}

	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String cliente) {
		this.alumno = cliente;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}
