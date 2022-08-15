/**
 * 
 */
package com.alexbrown.projectjpa.dao;

import java.util.List;

import com.alexbrown.projectjpa.entity.Disquera;

/**
 * @author DevPredator
 * Interface que genera el DAO para las transacciones del CRUD a la tabla de disquera.
 */
public interface DisqueraDAO {

	void guardar(Disquera disquera);
	
	void actualizar(Disquera disquera);
	
	void eliminar(Long id);
	
	List<Disquera> consultar();
	
	Disquera consultarById(Long id);
}