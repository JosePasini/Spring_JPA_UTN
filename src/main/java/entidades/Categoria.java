package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy = "categorias", cascade = CascadeType.MERGE)
	private List<Articulo> articulos = new ArrayList<>();
	
	@Column(name = "denominacion")
	private String denominacion;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	public Categoria() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Categoria(String denominacion) {
		this.denominacion = denominacion;
	}
	
	
	
}
