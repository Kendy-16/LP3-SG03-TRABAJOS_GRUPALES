import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecetaDAO {
    private Connection conn = DatabaseConnection.connect();

    public void insertar(Receta r) {
        String sql = "INSERT INTO recetas(nombre, ingredientes, preparacion) VALUES(?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, r.getNombre());
            pstmt.setString(2, r.getIngredientes());
            pstmt.setString(3, r.getPreparacion());
            pstmt.executeUpdate();
            System.out.println("Receta insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public List<Receta> listar() {
        List<Receta> recetas = new ArrayList<>();
        String sql = "SELECT * FROM recetas";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Receta r = new Receta(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("ingredientes"),
                        rs.getString("preparacion")
                );
                recetas.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return recetas;
    }

    public void actualizar(Receta r) {
        String sql = "UPDATE recetas SET nombre = ?, ingredientes = ?, preparacion = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, r.getNombre());
            pstmt.setString(2, r.getIngredientes());
            pstmt.setString(3, r.getPreparacion());
            pstmt.setInt(4, r.getId());
            pstmt.executeUpdate();
            System.out.println("Receta actualizada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM recetas WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Receta eliminada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
    //===============================PRUEBA=======================================
    public void mostrarIngredientes() {
      String sql = "SELECT nombre FROM ingrediente";
      try(PrepareStatement pstmt = conn.PrepareStatement(sql)) {
        pstmt.setInt(1, ingrediente_id);
        rs = pstmt.executeQuery(sql);
      }
    }
    //============================================================================
}

