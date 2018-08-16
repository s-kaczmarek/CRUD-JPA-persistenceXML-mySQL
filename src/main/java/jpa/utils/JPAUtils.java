package jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

    private static final String PERSISTENCE_UNIT_NAME = "myDatabase";
    public static EntityManagerFactory entityManagerFactory;
    public static EntityManager entityManager;

    static{
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        //entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManager openEntityManager(){
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    public static void closeConnection(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
