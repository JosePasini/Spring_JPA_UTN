package entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "domicilio")
@Audited
@Data
@NoArgsConstructor
public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;
    //Relaciones

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre_calle")
    private String nombreCalle;

    @Column(name = "numero_calle")
    private int numeroCalle;

    //Constructor
    public Domicilio(String nombreCalle, int numeroCalle) {
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
    }

}
