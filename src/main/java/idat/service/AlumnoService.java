package idat.service;

import java.util.List;

import idat.model.Alumno;

public interface AlumnoService {
	void save(Alumno p);
	void actualizar(Alumno p);
	void eliminar(Integer codigo);
	Alumno buscar(Integer codigo);
	List<Alumno> listar();
}
