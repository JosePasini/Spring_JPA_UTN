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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "articulo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Articulo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "articulo_categoria",
			joinColumns = @JoinColumn(name = "articulo_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Categoria> categorias = new ArrayList<>();
	
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<DetalleFactura> getDetalles_factura() {
		return detalles_factura;
	}

	public void setDetalles_factura(List<DetalleFactura> detalles_factura) {
		this.detalles_factura = detalles_factura;
	}
	@OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
	private List<DetalleFactura> detalles_factura = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name = "precio")
	@NonNull private int precio;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "denominacion")
	@NonNull private String denominacion;




	
}
