package com.sistemalibreria;

import com.sistemalibreria.entities.Autor;
import com.sistemalibreria.entities.Categoria;
import com.sistemalibreria.entities.Libro;
import com.sistemalibreria.services.LibroService;
import com.sistemalibreria.util.JPAConexion;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        LibroService service = new LibroService();

        // Crear autor y categoría
        Autor autor = new Autor("Gabriel García Márquez");
        service.guardarAutor(autor);

        Categoria cat = new Categoria("Novela"); 
        service.guardarCategoria(cat);

        // Crear libro y asociar autor y categoría (usar métodos de entidad para mantener consistencia)
        Libro libro = new Libro("Cien años de soledad", 39.90);
        // Relacionar bidireccionalmente
        autor.agregarLibro(libro);
        cat.agregarLibro(libro);

        // Guardar libro (autor y categoria ya tienen cascada en sus relaciones)
        service.guardarLibro(libro);

        System.out.println("--- Libros en la BD ---");
        List<Libro> libros = service.listarLibros();
        libros.forEach(System.out::println);

        System.out.println("--- Autores en la BD ---");
        service.listarAutores().forEach(System.out::println);

        System.out.println("--- Categorias en la BD ---");
        service.listarCategorias().forEach(System.out::println);

        // Cerrar factory antes de salir
        JPAConexion.close();
    }
}
