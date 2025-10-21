package com.sistemalibreria.interfaces;

import java.util.List;

public interface ICRUD<T> {
    T guardar(T t);
    T actualizar(T t);
    void eliminar(T t);
    T buscarPorId(Long id);
    List<T> listarTodos();
}
