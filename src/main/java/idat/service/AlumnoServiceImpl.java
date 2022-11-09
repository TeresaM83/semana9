package idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.model.Alumno;
import idat.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository repository;
	
	@Override
	public void save(Alumno p) {
		repository.save(p);
	}

	@Override
	public void actualizar(Alumno p) {
		repository.saveAndFlush(p);
	}

	@Override
	public void eliminar(Integer codigo) {
		repository.deleteById(codigo);
	}

	@Override
	public Alumno buscar(Integer codigo) {
		return repository.findById(codigo).orElse(null);
	}

	@Override
	public List<Alumno> listar() {
		return repository.findAll();
	}

}
