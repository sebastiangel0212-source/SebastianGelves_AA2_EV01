package com.sebastiangelves.ss.controller;

import com.sebastiangelves.ss.model.Producto;
import com.sebastiangelves.ss.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// @Controller indica que esta clase maneja peticiones web
@Controller
public class ProductoController {

    // @Autowired inyecta una instancia del Repositorio automáticamente
    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Este método maneja las peticiones GET a la URL "/productos".
     * Muestra la lista de productos y el formulario para agregar uno nuevo.
     * @param model El modelo para pasar datos a la vista (Thymeleaf).
     * @return El nombre del archivo HTML de la vista.
     */
    @GetMapping("/productos")
    public String listarProductos(Model model) {
        // Usamos el repositorio para obtener todos los productos de la BD
        model.addAttribute("productos", productoRepository.findAll());
        // Creamos un nuevo objeto producto para el formulario
        model.addAttribute("productoForm", new Producto());
        return "productos"; // Devuelve el nombre del archivo 'productos.html'
    }

    /**
     * Este método maneja las peticiones POST a la URL "/productos".
     * Procesa los datos del formulario para guardar un nuevo producto.
     * @param producto El objeto producto con los datos del formulario.
     * @return Una redirección a la lista de productos.
     */
    @PostMapping("/productos")
    public String guardarProducto(@ModelAttribute Producto producto) {
        // Usamos el repositorio para guardar el nuevo producto en la BD
        productoRepository.save(producto);
        return "redirect:/productos"; // Redirige para mostrar la lista actualizada
    }
}