package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Articulo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;

//import entidades.Cliente;
//import entidades.Domicilio;

public class PersistenceApp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			//Comienza la transacción
			em.getTransaction().begin();

			/*
			Factura factura1 = new Factura();
			factura1.setNumero(12);
			factura1.setFecha("04/07/1995");
			
			Domicilio dom = new Domicilio("San Martín", 101);
			Cliente cliente = new Cliente("Jose", "Pasini", 156000111);
			cliente.setDomicilio(dom);
			dom.setCliente(cliente);
			
			factura1.setCliente(cliente);
			
			Categoria perecederos = new Categoria("Perecederos");
			Categoria lacteos = new Categoria("lacteos");
			Categoria limpieza = new Categoria("limpieza");
			
			Articulo art1 = new Articulo(200, "Flan Dulce de Leche");
			Articulo art2 = new Articulo(300, "Bizcochuelo");
			
			art1.getCategorias().add(perecederos);
			art1.getCategorias().add(lacteos);
			lacteos.getArticulos().add(art1);
			perecederos.getArticulos().add(art1);
			
			art2.getCategorias().add(limpieza);
			limpieza.getArticulos().add(art2);
			
			DetalleFactura det1 = new DetalleFactura();
			
			det1.setArticulo(art1);
			det1.setCantidad(2);
			det1.setSubtotal(40);
			
			
			art1.getDetalles_factura().add(det1);
			factura1.getDetalles().add(det1);
			det1.setFactura(factura1);
			
			DetalleFactura det2 = new DetalleFactura();
			
			det2.setArticulo(art2);
			det2.setCantidad(3);
			det2.setSubtotal(80);
			
			art2.getDetalles_factura().add(det2);
			factura1.getDetalles().add(det2);
			det2.setFactura(factura1);
			
			factura1.setTotal(320);
			
			em.persist(factura1);
			
			
			*/
			
			
			//Limpiamos la conexión
			em.flush();
			
			//Comiteamos
			em.getTransaction().commit();
			
		} catch (Exception e) {
			
			System.out.println("HOLAAAAAAAAAAAAA excepcion");
			
			//Vuelve hacia atrás si falla algo
			em.getTransaction().rollback();
			
			// TODO: handle exception
		} finally {
			emf.close();
			em.close();
		}
		
	}

}
