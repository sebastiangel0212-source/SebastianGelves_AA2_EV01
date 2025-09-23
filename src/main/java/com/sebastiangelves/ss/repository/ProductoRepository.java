package com.sebastiangelves.ss.repository;

import com.sebastiangelves.ss.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// La interfaz JpaRepository nos da métodos como findAll(), findById(), save(), deleteById(), etc.
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Puedes agregar métodos de consulta personalizados aquí si los necesitas
}