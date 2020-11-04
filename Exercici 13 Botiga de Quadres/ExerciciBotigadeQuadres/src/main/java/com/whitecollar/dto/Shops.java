package com.whitecollar.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shops")
public class Shops {

	// Atributos de entidad shops
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int capacity;

	// @OneToMany: se utiliza para especificar una relación de bd de uno a muchos.
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
	private List<Pictures> pictures;

	// CONSTRUCTORES

	public Shops() {

	}

	/**
	 * 
	 * @param id       id de la tienda
	 * @param name     nombre de la tienda
	 * @param capacity capacidad de la tienda
	 */
	public Shops(int id, String name, int capacity) {

		this.id = id;
		this.name = name;
		this.capacity = capacity;
	}

	// Getters y setters

	/**
	 * @return id de la tienda
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id to set id tienda
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return nombre de la tienda
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name to set nombre de la tienda
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return capacidad de la tienda
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity to set capacidad
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * JsonIgnore: de este modo al hacer un GET de tiendas me trae solo los datos de
	 * la misma y no las pinturas que posee.
	 * 
	 * @return lista de cuadros
	 */
	@JsonIgnore 
	public List<Pictures> getPictures() {
		return pictures;
	}

	/**
	 * @param pictures to set lista de cuadros
	 */
	public void setPictures(List<Pictures> pictures) {
		this.pictures = pictures;
	}

	// Método impresion de datos por consola
	@Override
	public String toString() {
		return "Shops [id=" + id + ", name=" + name + ", capacity=" + capacity + "]";
	}

}
