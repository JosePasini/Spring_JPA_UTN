package entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
@Audited
@Data
@NoArgsConstructor
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToMany(mappedBy = "categoria", cascade = CascadeType.MERGE)
    private List<Articulo> articulo = new ArrayList<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "denominacion")
    private String denominacion;


    //Constructor

    public Categoria(String denominacion) {
        this.denominacion = denominacion;
    }


}
