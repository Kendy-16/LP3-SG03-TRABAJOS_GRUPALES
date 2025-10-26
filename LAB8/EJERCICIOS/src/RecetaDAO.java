import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecetaDAO {
    private Connection conn = DatabaseConnection.connect();

    public void insertar(Receta r) {
        String sql = "INSERT INTO receta(titulo, descripcion, tiempo_preparacion, tiempo_coccion, instrucciones) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, r.getTitulo());
            pstmt.setString(2, r.getDescripcion());
            pstmt.setInt(3, r.getTiempoPreparacion());
            pstmt.setInt(4, r.getTiempoCoccion());
            pstmt.setString(5, r.getInstrucciones());
            pstmt.executeUpdate();
            System.out.println("Receta insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public List<Receta> listar() {
        List<Receta> recetas = new ArrayList<>();
        String sql = "SELECT * FROM receta";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Receta r = new Receta(
                        rs.getInt("receta_id"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getInt("tiempo_preparacion"),
                        rs.getInt("tiempo_coccion"),
                        rs.getString("instrucciones")
                );
                recetas.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return recetas;
    }

    public void actualizar(Receta r) {
        String sql = "UPDATE receta SET titulo = ?, descripcion = ?, tiempo_preparacion = ?, tiempo_coccion = ?, instrucciones = ? WHERE receta_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, r.getTitulo());
            pstmt.setString(2, r.getDescripcion());
            pstmt.setInt(3, r.getTiempoPreparacion());
            pstmt.setInt(4, r.getTiempoCoccion());
            pstmt.setString(5, r.getInstrucciones());
            pstmt.setInt(6, r.getId());
            pstmt.executeUpdate();
            System.out.println("Receta actualizada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM receta WHERE receta_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Receta eliminada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
