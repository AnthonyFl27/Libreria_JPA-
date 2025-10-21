package com.sistemalibreria.dao;

import com.sistemalibreria.interfaces.ICRUD;
import com.sistemalibreria.util.JPAConexion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MyDao<T> implements ICRUD<T> {

    private final Class<T> tipo;

    public MyDao(Class<T> tipo) {
        this.tipo = tipo;
    }

    @Override
    public T guardar(T t) {
        EntityManager em = JPAConexion.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            return t;
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
    public T actualizar(T t) {
        EntityManager em = JPAConexion.getEntityManager();
        try {
            em.getTransaction().begin();
            T merged = em.merge(t);
            em.getTransaction().commit();
            return merged;
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
    public void eliminar(T t) {
        EntityManager em = JPAConexion.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(t) ? t : em.merge(t));
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
    public T buscarPorId(Long id) {
        EntityManager em = JPAConexion.getEntityManager();
        try {
            return em.find(tipo, id);
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
    public List<T> listarTodos() {
        EntityManager em = JPAConexion.getEntityManager();
        try {
            TypedQuery<T> q = em.createQuery("SELECT e FROM " + tipo.getSimpleName() + " e", tipo);
            return q.getResultList();
        } finally {
            if (em.isOpen()) em.close();
        }
    }
}
