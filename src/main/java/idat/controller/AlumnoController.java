package idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import idat.model.Alumno;
import idat.service.AlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	
	private Alumno alumno;
	@Autowired
	private AlumnoService service;

	@RequestMapping(method = RequestMethod.GET, path = "/")
	//@GetMapping("")
	public ResponseEntity<List<Alumno>> listar() {
		List<Alumno> listaProductos=service.listar();		
		return new ResponseEntity<List<Alumno>>(listaProductos,HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/{codigo}")
	//@GetMapping("/{codigo}")
	public ResponseEntity<Alumno> buscar(@PathVariable Integer codigo) {	
		alumno = service.buscar(codigo);
		if (alumno!=null) {
			return new ResponseEntity<Alumno>(alumno,HttpStatus.OK);
		}else {
			return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/")
	//@PostMapping("")
	public ResponseEntity<Alumno> create(@RequestBody Alumno p) {
		service.save(p);	
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{codigo}")
	//@PutMapping("/{codigo}")
	public ResponseEntity<?> actualizar(@RequestBody Alumno p, @PathVariable Integer codigo) {
		alumno= service.buscar(codigo);
		if (alumno!=null) {
			p.setId(codigo);
			service.actualizar(p);
			return new ResponseEntity<>(p,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
			
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/{codigo}")
	//@DeleteMapping("/{codigo}")
	public ResponseEntity<?> eliminar(@PathVariable Integer codigo) {
		alumno= service.buscar(codigo);
		if (alumno!=null) {
			service.eliminar(codigo);	
			return new ResponseEntity<>(alumno,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
