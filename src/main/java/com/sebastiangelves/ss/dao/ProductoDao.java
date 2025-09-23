package com.sebastiangelves.ss.web.dao;

import com.sebastiangelves.ss.web.model.Producto;
import com.sebastiangelves.ss.web.db.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {

    public List<Producto> list() throws SQLException {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, precio FROM producto ORDER BY id";
        try (Connection c = DbUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio")));
            }
        }
        return lista;
    }

    public Producto getById(int id) throws SQLException {
        String sql = "SELECT id, nombre, precio FROM producto WHERE id = ?";
        try (Connection c = DbUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"));
                }
            }
        }
        return null;
    }

    public void insert(Producto p) throws SQLException {
        String sql = "INSERT INTO producto (nombre, precio) VALUES (?, ?)";
        try (Connection c = DbUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.executeUpdate();
        }
    }

    public void update(Producto p) throws SQLException {
        String sql = "UPDATE producto SET nombre = ?, precio = ? WHERE id = ?";
        try (Connection c = DbUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM producto WHERE id = ?";
        try (Connection c = DbUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
