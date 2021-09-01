import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entities.*;

import java.io.Serializable;

public class Main implements Serializable {
    private static final long serialVersionUID = 1L;
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
        EntityManager em = emf.createEntityManager();
        try{


            em.getTransaction().begin();

            Factura factura = new Factura();
            factura.setNumeroFactura(1);
            factura.setTipoFactura("B");

            Domicilio dom = new Domicilio("San Martin", 101);
            Cliente cli = new Cliente("Nombre", "Apellido");

            cli.setDomicilio(dom);
            dom.setCliente(cli);

            factura.setCliente(cli);

            Categoria perecederos = new Categoria("Perecederos");
            Categoria lacteos = new Categoria("lacteos");
            Categoria limpieza = new Categoria("limpieza");

            Articulo articulo = new Articulo(200, "Flan con dulce de leche");
            Articulo articulo2 = new Articulo(130, "Azúcar negra");

            articulo.getCategoria().add(perecederos);
            articulo.getCategoria().add(lacteos);
            lacteos.getArticulo().add(articulo);
            perecederos.getArticulo().add(articulo);

            articulo2.getCategoria().add(limpieza);
            limpieza.getArticulo().add(articulo2);

            DetalleFactura detalleFactura = new DetalleFactura();

            detalleFactura.setArticulo(articulo);
            detalleFactura.setCantidad(3);
            detalleFactura.setSubtotal(40);

            articulo.getDetalles().add(detalleFactura);
            factura.getDetalles().add(detalleFactura);
            detalleFactura.setFactura(factura);

            DetalleFactura detalleFactura2 = new DetalleFactura();
            detalleFactura2.setArticulo(articulo2);
            detalleFactura2.setCantidad(2);
            detalleFactura2.setSubtotal(400);

            articulo2.getDetalles().add(detalleFactura2);
            factura.getDetalles().add(detalleFactura2);

            em.persist(factura);
            //em.persist(articulo);
            em.flush();

            em.getTransaction().commit();

            em.close();
        } catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }




    }
}
