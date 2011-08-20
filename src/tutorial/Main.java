package tutorial;

import javax.persistence.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
    	
    	Main m = new Main();
    	
    	m.testPoint();
        m.testFeedInfo();
        m.testFeedInfoSelect();
    }
    
    public void testPoint()
    {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/points.odb");
        EntityManager em = emf.createEntityManager();
 
        // Store 1000 Point objects in the database:
        em.getTransaction().begin();
        for (int i = 0; i < 1000; i++) {
            Point p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();
 
        // Find the number of Point objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        System.out.println("Total Points: " + q1.getSingleResult());
 
        // Find the average X value:
        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        System.out.println("Average X: " + q2.getSingleResult());
 
        // Retrieve all the Point objects from the database:
        TypedQuery<Point> query =
            em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = query.getResultList();
        for (Point p : results) {
            System.out.println(p);
        }
 
        // Close the database connection:
        em.close();
        emf.close();
    	
    }
    
    public void testFeedInfo()
    {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/feed-info.odb");
        EntityManager em = emf.createEntityManager();
 
        // Store 1000 Point objects in the database:
        em.getTransaction().begin();
        for (int i = 0; i < 1000; i++) {
        	FeedInfo fi = new FeedInfo("Daryl" + i, "ORourke" + i);
            em.persist(fi);
        }
        em.getTransaction().commit();
 
        // Find the number of Point objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(fi) FROM FeedInfo fi");
        System.out.println("Total Points: " + q1.getSingleResult());
 
        // Find the average X value:
//        Query q2 = em.createQuery("SELECT AVG(fi.x) FROM FeedInfo fi");
//        System.out.println("Average X: " + q2.getSingleResult());
 
        // Retrieve all the Point objects from the database:
        TypedQuery<FeedInfo> query = em.createQuery("SELECT fi FROM FeedInfo fi", FeedInfo.class);
        List<FeedInfo> results = query.getResultList();
        for (FeedInfo fi : results) {
            System.out.println(fi);
        }
 
        // Close the database connection:
        em.close();
        emf.close();
    	
    }
    
    public void testFeedInfoSelect()
    {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/feed-info.odb");
        EntityManager em = emf.createEntityManager();
 
 
 
        // Retrieve all the Point objects from the database:
        TypedQuery<FeedInfo> query = em.createQuery("SELECT fi FROM FeedInfo fi where fi.pid = 18", FeedInfo.class);
        List<FeedInfo> results = query.getResultList();
        for (FeedInfo fi : results) {
            System.out.println(fi);
        }
 
        // Close the database connection:
        em.close();
        emf.close();
    }
}