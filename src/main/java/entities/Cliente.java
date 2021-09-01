package entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "cliente")
@Audited
@Data
@NoArgsConstructor
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    //Relaciones
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas = new ArrayList<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

     @Column(name = "nombre")
     private String nombre;

     @Column(name = "apellido")
     private String apellido;


    //Constructores

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
