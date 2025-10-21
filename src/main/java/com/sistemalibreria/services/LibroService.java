package com.sistemalibreria.services;

import com.sistemalibreria.dao.MyDao;
import com.sistemalibreria.entities.Autor;
import com.sistemalibreria.entities.Categoria;
import com.sistemalibreria.entities.Libro;

import java.util.List;

public class LibroService {
    private final MyDao<Libro> libroDao = new MyDao<>(Libro.class);
    private final MyDao<Autor> autorDao = new MyDao<>(Autor.class);
    private final MyDao<Categoria> categoriaDao = new MyDao<>(Categoria.class);

    // Autor
    public Autor guardarAutor(Autor a) { return autorDao.guardar(a); }
    public List<Autor> listarAutores() { return autorDao.listarTodos(); }

    // Categoria
    public Categoria guardarCategoria(Categoria c) { return categoriaDao.guardar(c); }
    public List<Categoria> listarCategorias() { return categoriaDao.listarTodos(); }

    // Libro
    public Libro guardarLibro(Libro l) { return libroDao.guardar(l); }
    public Libro actualizarLibro(Libro l) { return libroDao.actualizar(l); }
    public void eliminarLibro(Libro l) { libroDao.eliminar(l); }
    public Libro buscarLibro(Long id) { return libroDao.buscarPorId(id); }
    public List<Libro> listarLibros() { return libroDao.listarTodos(); }
}
