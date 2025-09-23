<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sebastiangelves.ss.model.Producto" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gestión de Productos - S&S</title>
    <style>
        body { font-family: sans-serif; margin: 2em; }
        form { margin-bottom: 2em; border: 1px solid #ccc; padding: 1em; border-radius: 5px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h1>Gestión de Inventario de Productos</h1>

    <form action="productos" method="post">
        <h2>Registrar Nuevo Producto</h2>
        <label for="nombre">Nombre:</label><br>
        <input type="text" id="nombre" name="nombre" required><br><br>
        
        <label for="descripcion">Descripción:</label><br>
        <input type="text" id="descripcion" name="descripcion"><br><br>
        
        <label for="precio">Precio:</label><br>
        <input type="number" step="0.01" id="precio" name="precio" required><br><br>
        
        <label for="stock">Stock:</label><br>
        <input type="number" id="stock" name="stock" required><br><br>
        
        <input type="submit" value="Guardar Producto">
    </form>

    <h2>Inventario Actual</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Precio</th>
            <th>Stock</th>
        </tr>
        <%-- Se usa un scriptlet de JSP para iterar sobre la lista de productos --%>
        <% 
           List<Producto> listaProductos = (List<Producto>) request.getAttribute("productos");
           if (listaProductos != null) {
               for (Producto p : listaProductos) { 
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNombre() %></td>
            <td><%= p.getDescripcion() %></td>
            <td>$<%= String.format("%.2f", p.getPrecio()) %></td>
            <td><%= p.getCantidadStock() %></td>
        </tr>
        <% 
               }
           } 
        %>
    </table>
</body>
</html>