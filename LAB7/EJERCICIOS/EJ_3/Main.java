public class Main {
    public static void main(String[] args) {
        EmpleadoModelo model = new EmpleadoModelo();
        EmpleadoVista view = new EmpleadoVista();
        EmpleadoControlador controller = new EmpleadoControlador(model, view);

        try {
            controller.iniciar();
        } catch (Exception e) {
            System.out.println("Error fatal en la aplicación: " + e.getMessage());
            e.printStackTrace();
        } finally {
            view.close();
        }
    }
}
