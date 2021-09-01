package entities;


import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "factura")
@Audited
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;

    //Relaciones
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;


    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<DetalleFactura> detalles = new ArrayList<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tipo_factura")
    private String tipoFactura;

    @Column(name = "numero_factura")
    private int numeroFactura;


    public Factura(String tipoFactura, int numeroFactura) {
        this.tipoFactura = tipoFactura;
        this.numeroFactura = numeroFactura;
    }




}
