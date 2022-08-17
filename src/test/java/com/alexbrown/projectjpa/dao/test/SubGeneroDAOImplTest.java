/**
 * 
 */
package com.alexbrown.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.alexbrown.projectjpa.dao.SubGeneroDAO;
import com.alexbrown.projectjpa.dao.impl.SubGeneroDAOImpl;
import com.alexbrown.projectjpa.entity.Genero;
import com.alexbrown.projectjpa.entity.SubGenero;

/**
 * @author DevPredator
 * Clase TEST para comprobar el funcionamiento de los metodos del CRUD de subgenero.
 */
class SubGeneroDAOImplTest {
	
	private SubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.SubGeneroDAOImpl#guardar(com.devpredator.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testGuardar() {
		SubGenero subGenero = new SubGenero();
		subGenero.setDescripcion("Hard Core");
		subGenero.setFechaCreacion(LocalDateTime.now());
		subGenero.setEstatus(true);
		
		Genero genero = new Genero();
		genero.setDescripcion("Metal");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);
		
		subGenero.setGenero(genero);
		
		this.subGeneroDAO.guardar(subGenero);
	}

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.SubGeneroDAOImpl#actualizar(com.devpredator.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testActualizar() {
		SubGenero subGeneroConsultado = this.subGeneroDAO.consultarById(7L);
		
		subGeneroConsultado.setDescripcion("Trash Metal");
		subGeneroConsultado.getGenero().setDescripcion("Metal Trash");
		
		this.subGeneroDAO.actualizar(subGeneroConsultado);
	}

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.SubGeneroDAOImpl#eliminar(java.lang.Long)}.
	 */
	@Test
	void testEliminar() {
		
		this.subGeneroDAO.eliminar(7L);
	}

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.SubGeneroDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<SubGenero> subGenerosConsultados = this.subGeneroDAO.consultar();
		
		assertTrue(subGenerosConsultados.size() > 0);
		
		for (SubGenero subGenero : subGenerosConsultados) {
			System.out.println("Subgenero: " + subGenero.getDescripcion());
			System.out.println("Genero: " + subGenero.getGenero().getDescripcion());
		}
	}

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.SubGeneroDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		fail("Not yet implemented");
	}

}
