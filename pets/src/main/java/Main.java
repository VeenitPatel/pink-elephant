import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("petManagerPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Query query = em.createQuery("SELECT c FROM Customer c");
        //TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);
        //List<Customer> customers = query.getResultList();

        List<Pet> petsList = new ArrayList<>();

        Pet newPet = new Pet(null, "dog", 2, "name", "male", null);
        petsList.add(newPet);

        Owner newOwner = new Owner(null, "Owner", 50, "Here", "email", "123", petsList);

        newPet.setOwner(newOwner);

        tx.begin();
        em.persist(newOwner); //persist will insert or update
        tx.commit();
    }

}
