import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TestFilePrueba {
    public static void main(String[] args) {
        FileInputStream file = null;
        byte[] b = new byte[1024];

        try {
            file = new FileInputStream("src/archivos/TestFile.java");
            int bytesLeidos = file.read(b); // lee hasta 1024 bytes y devuelve cuántos se leyeron
            if (bytesLeidos > 0) {
                String s = new String(b, 0, bytesLeidos); // construye la cadena sólo con los bytes leídos
                ViewFile view = new ViewFile(s);
                view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                view.setSize(400, 150);
                view.setVisible(true);
            } else {
                System.out.println("El archivo está vacío o no se leyó nada.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    System.out.println("Error cerrando el archivo: " + e.getMessage());
                }
            }
        }
    }
}

class ViewFile extends JFrame {
    private JTextArea areaTexto;

    public ViewFile(String s) {
        super("Mostrando el contenido de un archivo");
        areaTexto = new JTextArea(s, 5, 40);
        areaTexto.setEditable(false);
        add(areaTexto);
        pack();
    }
}
