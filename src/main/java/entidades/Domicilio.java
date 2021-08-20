package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "domicilio")
public class Domicilio implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="nombreCalle")
	private String nombreCalle;
	
	@Column(name ="numeroCalle")
	private int numeroCalle;
	
	@OneToOne(mappedBy = "domicilio")
	private Cliente cliente;
	
	
	
	public Domicilio(String nombreCalle, int numeroCalle) {
		this.nombreCalle = nombreCalle;
		this.numeroCalle = numeroCalle;
	}
	public Domicilio(String nombreCalle, int numeroCalle, Cliente cliente) {
		this.nombreCalle = nombreCalle;
		this.numeroCalle = numeroCalle;
		this.cliente = cliente;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCalle() {
		return nombreCalle;
	}

	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}

	public int getNumeroCalle() {
		return numeroCalle;
	}

	public void setNumeroCalle(int numeroCalle) {
		this.numeroCalle = numeroCalle;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Domicilio() {
	}


	private static final long serialVersionUID = 1L;
	


}
