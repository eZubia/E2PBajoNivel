package mx.examen.test;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.uach.examen.Alumno;
import mx.uach.examen.Computadora;
import mx.uach.examen.Pelicula;
import org.junit.Test;

/**
 *
 * Clase de pruebas para las operaciónes CRUD de los diferentes modelos.
 * 
 * @author Erik David Zubia Hernández
 * @version 1.0
 */
public class CRUDTest {
    
    /**
     * Realiza pruebas de CRUD para los diferentes modelos del sistema.
     */
    @Test
    public void testCRUD() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamenPU");
        EntityManager em = emf.createEntityManager();
        Pelicula peli = new Pelicula( "Titulo de prueba", new Date(), "Es una pelicula muy padre", Boolean.TRUE);
        em.getTransaction().begin();;
        em.persist(peli);
        em.getTransaction().commit();
        Query q = em.createQuery("SELECT a FROM Pelicula a");
        List<Pelicula> peliculas = q.getResultList();
        for (Pelicula pelicula : peliculas) {
            System.out.println("pelicula = " + pelicula);
        }
        
        em.getTransaction().begin();
        peli.setTitulo( "Titulo despues de la actualizacion");
        em.persist(peli);
        em.getTransaction().commit();
        q = em.createQuery("SELECT a FROM Pelicula a");
        peliculas.clear();
        peliculas = q.getResultList();
        for (Pelicula pelicula : peliculas) {
            System.out.println("pelicula = " + pelicula);
        }
        
        em.getTransaction().begin();
        em.remove(peli);
        em.getTransaction().commit();
        q = em.createQuery("SELECT a FROM Pelicula a");
        peliculas.clear();
        peliculas = q.getResultList();
        for (Pelicula pelicula : peliculas) {
            System.out.println("pelicula = " + pelicula);
        }
        System.out.println("peliculas.size() = " + peliculas.size());
        
        
        Alumno object = new Alumno("Juanito", "Perez", "Martinez", 18, "ZUHE950920HCHBRR00", "ZUHE950920KW7");
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        q = em.createQuery("SELECT a FROM Alumno a");
        List<Alumno> objects = q.getResultList();
        for (Alumno alumno : objects) {
            System.out.println("alumno = " + alumno);
        }
        
        em.getTransaction().begin();
        object.setNombre("Pancho");
        object.setApellidoP("Panchitos");
        object.setApellidoM("Panchitas");
        em.persist(object);
        em.getTransaction().commit();
        q = em.createQuery("SELECT a FROM Alumno a");
        objects.clear();
        objects = q.getResultList();
        for (Alumno alumno : objects) {
            System.out.println("alumno = " + alumno);
        }
        
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
        q = em.createQuery("SELECT a FROM Alumno a");
        objects.clear();
        objects = q.getResultList();
        for (Alumno alumno : objects) {
            System.out.println("alumno = " + alumno);
        }
        System.out.println("objects.size() = " + objects.size());
        
        Computadora computadora = new Computadora("13 Pulgadas", "Mac", 19500.0, new Date(), Boolean.TRUE);
        em.getTransaction().begin();;
        em.persist(computadora);
        em.getTransaction().commit();
        q = em.createQuery("SELECT a FROM Computadora a");
        List<Computadora> comus = q.getResultList();
        for (Computadora compu : comus) {
            System.out.println("compu = " + compu);
        }
        
        em.getTransaction().begin();
        computadora.setMarca("HP");
        computadora.setModelo("15p");
        computadora.setPrecio(9000.0);
        em.persist(computadora);
        em.getTransaction().commit();
        q = em.createQuery("SELECT a FROM Computadora a");
        comus.clear();
        comus = q.getResultList();
        for (Computadora compu : comus) {
            System.out.println("compu = " + compu);
        }
        
        em.getTransaction().begin();
        em.remove(computadora);
        em.getTransaction().commit();
        q = em.createQuery("SELECT a FROM Computadora a");
        comus.clear();
        comus = q.getResultList();
        for (Computadora compu : comus) {
            System.out.println("compu = " + compu);
        }
        System.out.println("comus.size() = " + comus.size());
        
        
        emf.close();
    }
    
}
