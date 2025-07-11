package com.hibernatepractice.prj;

// import javax.transaction.Transaction;
import org.hibernate.Transaction;
import org.hibernate.Session;

// import com.hibernatepractice.prj.*;

public class App {
    public static void main(String[] args) {
        Region reg = new Region();
        reg.setName("Europe");

        try (Session s = HiberUtil.getSessionFactory().openSession()) {
            Transaction t = s.beginTransaction();
            s.save(reg);
            t.commit();
        }

        Country c = new Country();
        c.setId("FR");
        c.setName("France");
        c.setReg(reg);

        try (Session s = HiberUtil.getSessionFactory().openSession()) {
            Transaction t = s.beginTransaction();
            s.save(c);
            t.commit();
        }

        try (Session s = HiberUtil.getSessionFactory().openSession()) {
            Country c1 = s.get(Country.class, "FR");
            System.out.println("Country: " + c1.getName() + ", Region: " + c1.getReg().getName());
        }

        HiberUtil.shutdown();
    }
}

/*
 * Region region = new Region();
 * Purpose: Creates a new Region object to be saved to the database.
 * region.setName("Europe");
 * Purpose: Sets the name of the Region to "Europe".
 * 
 * try (Session session = HibernateUtil.getSessionFactory().openSession()) {
 * Purpose: Opens a new Hibernate Session to interact with the database.
 * 
 * Transaction tx = session.beginTransaction();
 * Purpose: Begins a new transaction to ensure database operations are performedin a consistent way.
 * 
 * session.save(region);
 * Purpose: Saves the Region object to the database (inserts into the regionstable).
 * 
 * tx.commit();
 * Purpose: Commits the transaction, finalizing and saving changes to thedatabase.
 * 
 * Country country = new Country();
 * Purpose: Creates a new Country object to be populated with data and saved tothe database.
 * 
 * country.setId("FR");
 * Purpose: Sets the id of the Country to "FR" (country code).
 * 
 * country.setName("France");
 * Purpose: Sets the name of the Country to "France".
 * 
 * country.setRegion(region);
 * Purpose: Sets the Region of the Country to the previously created region("Europe").
 * 
 * try (Session session = HibernateUtil.getSessionFactory().openSession()) {
 * Purpose: Opens a new session for saving the Country entity.
 * 
 * Transaction tx = session.beginTransaction();
 * Purpose: Begins a new transaction for saving the Country entity.
 * 
 * session.save(country);
 * Purpose: Saves the Country entity to the database (inserts into the countriestable).
 * 
 * tx.commit();
 * Purpose: Commits the transaction, finalizing and saving the Country entity tothe database.
 * 
 * try (Session session = HibernateUtil.getSessionFactory().openSession()) {
 * Purpose: Opens a new session for reading the Country entity from thedatabase.
 * 
 * Country c = session.get(Country.class, "FR");
 * Purpose: Retrieves the Country entity with the primary key "FR" (France) fromthe database.
 * 
 * System.out.println("Country: " + c.getName() + ", Region: " +
 * c.getRegion().getName());
 * Purpose: Prints the name of the Country (France) and its associated Region(Europe) to the console.
 * 
 * HibernateUtil.shutdown();
 * Purpose: Shuts down Hibernate by closing the SessionFactory and releasingresources.
 */