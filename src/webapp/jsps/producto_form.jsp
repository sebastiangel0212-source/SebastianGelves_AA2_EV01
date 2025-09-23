<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="producto" class="com.sebastiangelves.ss.model.Producto" scope="request" />
<!doctype html>
<html><head><meta charset="utf-8"><title>Formulario Producto</title></head><body>
<h2><c:out value="${not empty producto ? 'Editar Producto' : 'Nuevo Producto'}"/></h2>
<form action="${pageContext.request.contextPath}/productos" method="post">
  <input type="hidden" name="id" value="${producto.id}" />
  <label>Nombre: <input type="text" name="nombre" value="${producto.nombre}" required/></label><br/>
  <label>Descripción: <input type="text" name="descripcion" value="${producto.descripcion}"/></label><br/>
  <label>Precio: <input type="number" step="0.01" name="precio" value="${producto.precio}" required/></label><br/>
  <label>Cantidad: <input type="number" name="cantidad" value="${producto.cantidad}" required/></label><br/>
  <button type="submit">Guardar</button>
</form>
<a href="${pageContext.request.contextPath}/productos">Volver al listado</a>
</body></html>
