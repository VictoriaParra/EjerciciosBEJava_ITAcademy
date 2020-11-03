package com.rockets.persistence;

import java.util.ArrayList;
import java.util.List;

import com.rockets.domain.Cohete;

/**
 * @author Victoria Parra
 */

public class CoheteRepository {

	//Atributos de la clase
	protected List<Cohete> cohetes= new ArrayList<Cohete>();
	
	//Constructor de la clase
	public CoheteRepository() {
		
	}
	
	/**
	 * Método para añadir un cohete a la lista de cohetes
	 * 
	 * @param cohete
	 */
	public void addCohete(Cohete cohete) {
		cohetes.add(cohete);
	}

	/**
	 * @return devuelve lista de cohetes
	 */
	public List<Cohete> getCohetes() {
		return cohetes;
	}

	//? ------------------------------------------------------------
	/**
	 * 
	 * @param cohetes lista de cohetes
	 */
	public void setCohetes(List<Cohete> cohetes) {
		this.cohetes = cohetes;
	}
	
	
}
