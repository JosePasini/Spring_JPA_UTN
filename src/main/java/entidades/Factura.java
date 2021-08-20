package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
	

	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_cliente")
	private Cliente cliente;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "total")
	private int total;
	
	public Factura(String fecha, int numero, int total) {
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
	}
	
	
	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

	
	public Factura() {
		// TODO Auto-generated constructor stub
	}
	
	public Factura(List<DetalleFactura> detalles, String fecha, int numero, int total) {
		this.detalles = detalles;
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
	}

	public Factura(List<DetalleFactura> detalles, Cliente cliente, String fecha, int numero, int total) {
		this.detalles = detalles;
		this.cliente = cliente;
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


}
