package com.sebastiangelves.ss.controller;

import com.sebastiangelves.ss.dao.ProductoDao;
import com.sebastiangelves.ss.dao.ProductoDaoImpl;
import com.sebastiangelves.ss.model.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

// La anotación @WebServlet simplifica la configuración que iría en web.xml
@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {
    private ProductoDao productoDao;

    @Override
    public void init() {
        productoDao = new ProductoDaoImpl();
    }

    /**
     * Utiliza el método GET para Cargar y mostrar los productos.
     * Se ejecuta cuando se accede a la URL directamente.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // 1. Obtener la lista de productos desde el DAO
        List<Producto> productos = productoDao.obtenerTodos();
        
        // 2. Guardar la lista en el objeto request para que la vista (JSP) la pueda usar
        request.setAttribute("productos", productos);
        
        // 3. Redirigir la petición al archivo JSP para que renderice la vista
        request.getRequestDispatcher("productos.jsp").forward(request, response);
    }

    /**
     * Utiliza el método POST para procesar los datos del formulario de creación.
     * Se ejecuta cuando el formulario HTML hace un submit.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // 1. Obtener los datos enviados desde el formulario
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        // 2. Crear un nuevo objeto Producto
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(nombre);
        nuevoProducto.setDescripcion(descripcion);
        nuevoProducto.setPrecio(precio);
        nuevoProducto.setCantidadStock(stock);

        // 3. Guardar el producto en la base de datos usando el DAO
        productoDao.agregar(nuevoProducto);

        // 4. Redirigir al usuario de vuelta a la lista de productos (usando el método GET)
        response.sendRedirect("productos");
    }
}