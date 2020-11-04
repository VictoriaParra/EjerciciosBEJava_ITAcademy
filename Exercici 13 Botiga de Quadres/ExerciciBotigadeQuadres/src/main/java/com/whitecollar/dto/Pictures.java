package com.whitecollar.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pictures")
public class Pictures {

	// Atributos de entidad pictures
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String author_name;
	private int price;
	// la columna entry_date lo completa directamente la bd
	@Column(insertable = false, name = "entry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entry_date;

	@ManyToOne // se usa para especificar una relación de base de datos de muchos a uno.
	@JoinColumn(name = "shop_id") // es como un inner join. Se especifica porque columna se unen(fk)
	private Shops shop;

	// CONSTRUCTORES

	public Pictures() {

	}

	/**
	 * 
	 * @param id          id del cuadro
	 * @param name        nombre del cuadro
	 * @param author_name nombre del autor del cuadro
	 * @param price       precio del cuadro
	 * @param entry_date  fecha ingreso del cuadro
	 * @param shop        tienda
	 */
	public Pictures(int id, String name, String author_name, int price, Date entry_date, Shops shop) {

		this.id = id;
		this.name = name;
		this.author_name = author_name;
		this.price = price;
		this.entry_date = entry_date;
		this.shop = shop;

	}

	// Getters y setters

	/**
	 * @return id del cuadro
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id to set id del cuadro
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return nombre del cuadro
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name to set nombre del cuadro
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return nombre del autor del cuadro
	 */
	public String getAuthor_name() {
		return author_name;
	}

	/**
	 * @param author_name to set nombre del autor
	 */
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	/**
	 * @return precio del cuadro
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price to set precio del cuadro
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return fecha ingreso
	 */
	public Date getEntry_date() {
		return entry_date;
	}

	/**
	 * @param entry_date to set fecha de ingreso
	 */
	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	/**
	 * @return tienda
	 */
	public Shops getShop() {
		return shop;
	}

	/**
	 * @param shop to set tienda
	 */
	public void setShop(Shops shop) {
		this.shop = shop;
	}

	// Método impresion de datos por consola
	@Override
	public String toString() {
		return "Pictures [id=" + id + ", name=" + name + ", author_name=" + author_name + ", price=" + price
				+ ", entry_date=" + entry_date + ", shop=" + shop + "]";
	}

}
