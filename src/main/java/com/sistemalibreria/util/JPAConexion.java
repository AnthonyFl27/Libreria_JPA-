package com.sistemalibreria.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConexion {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("SistemaLibreriaPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf.isOpen()) emf.close();
    }
}
