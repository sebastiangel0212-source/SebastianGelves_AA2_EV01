<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html><html><head><meta charset="utf-8"><title>Lista Productos</title></head><body>
<h1>Productos</h1>
<a href="${pageContext.request.contextPath}/productos?action=new">Nuevo Producto</a>
<table border="1"><thead><tr><th>ID</th><th>Nombre</th><th>Descripción</th><th>Precio</th><th>Cantidad</th><th>Acciones</th></tr></thead>
<tbody>
<c:forEach var="p" items="${productos}">
  <tr>
    <td><c:out value="${p.id}"/></td>
    <td><c:out value="${p.nombre}"/></td>
    <td><c:out value="${p.descripcion}"/></td>
    <td><c:out value="${p.precio}"/></td>
    <td><c:out value="${p.cantidad}"/></td>
    <td>
      <a href="${pageContext.request.contextPath}/productos?action=edit&id=${p.id}">Editar</a> |
      <a href="${pageContext.request.contextPath}/productos?action=delete&id=${p.id}"
         onclick="return confirm('¿Eliminar este producto?')">Eliminar</a>
    </td>
  </tr>
</c:forEach>
</tbody>
</table>
</body></html>
