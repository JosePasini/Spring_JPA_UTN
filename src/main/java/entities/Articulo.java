package entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articulo")
@Audited
@Data
@NoArgsConstructor
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="articulo_categoria",
        joinColumns = @JoinColumn(name="articulo_id"),
    inverseJoinColumns = @JoinColumn(name="categoria_id"))
    private List<Categoria> categoria = new ArrayList<>();


    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
    private List<DetalleFactura> detalles = new ArrayList<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "denominacion")
    private String denominacion;


    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio")
    private int precio;

    public Articulo(int precio,String denominacion) {
        this.precio = precio;
        this.denominacion = denominacion;
    }

}
