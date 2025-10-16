import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoControlador {
    private EmpleadoModelo model;
    private EmpleadoVista view;
    private static final String ARCHIVO = "empleados.txt";

    public EmpleadoController(EmpleadoModelo model, EmpleadoVista view) {
        this.model = model;
        this.view = view;
    }

    public void iniciar() {
        cargarEmpleados();
        mostrarMenu();
    }

    private void cargarEmpleados() {
        try {
            List<Empleado> empleados = leerEmpleados();
            model.setEmpleados(empleados);
            view.mostrarMensaje("Datos cargados correctamente desde el archivo.");
        } catch (IOException e) {
            view.mostrarError("Error al cargar los empleados: " + e.getMessage());
        }
    }

    public List<Empleado> leerEmpleados() throws IOException {
        List<Empleado> empleados = new ArrayList<>();
        File archivo = new File(ARCHIVO);

        if (!archivo.exists()) {
            return empleados;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    String[] partes = linea.split("\\|");
                    if (partes.length == 3) {
                        int numero = Integer.parseInt(partes[0]);
                        String nombre = partes[1];
                        double sueldo = Double.parseDouble(partes[2]);
                        empleados.add(new Empleado(numero, nombre, sueldo));
                    }
                } catch (NumberFormatException e) {
                    view.mostrarError("Error en formato de línea: " + linea);
                }
            }
        }
        return empleados;
    }

    public void agregarEmpleado(int numero, String nombre, double sueldo) {
        try {
            // ¿El numero existe?
            for (Empleado emp : model.getEmpleados()) {
                if (emp.getNumero() == numero) {
                    view.mostrarError("Ya existe un empleado con el número: " + numero);
                    return;
                }
            }

            // Validar datos
            if (nombre == null || nombre.trim().isEmpty()) {
                view.mostrarError("El nombre no puede estar vacío.");
                return;
            }
            if (sueldo <= 0) {
                view.mostrarError("El sueldo debe ser mayor a cero.");
                return;
            }

            Empleado nuevoEmpleado = new Empleado(numero, nombre.trim(), sueldo);
            model.agregarEmpleado(nuevoEmpleado);
            guardarEmpleados();
            view.mostrarMensaje("Empleado agregado correctamente.");

        } catch (IOException e) {
            view.mostrarError("Error al guardar el empleado: " + e.getMessage());
        }
    }

    public void buscarEmpleado(int numero) {
        Empleado empleado = model.buscarEmpleado(numero);
        if (empleado != null) {
            view.mostrarEmpleado(empleado);
        } else {
            view.mostrarError("No se encontró ningún empleado con el número: " + numero);
        }
    }

    public void eliminarEmpleado(int numero) {
        try {
            boolean eliminado = model.eliminarEmpleado(numero);
            if (eliminado) {
                guardarEmpleados();
                view.mostrarMensaje("Empleado eliminado correctamente.");
            } else {
                view.mostrarError("No se encontró ningún empleado con el número: " + numero);
            }
        } catch (IOException e) {
            view.mostrarError("Error al eliminar el empleado: " + e.getMessage());
        }
    }

    public void listarEmpleados() {
        List<Empleado> empleados = model.getEmpleados();
        if (empleados.isEmpty()) {
            view.mostrarMensaje("No hay empleados registrados.");
        } else {
            view.mostrarEmpleados(empleados);
        }
    }

    private void guardarEmpleados() throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO))) {
            for (Empleado empleado : model.getEmpleados()) {
                pw.println(empleado.toFileFormat());
            }
        }
    }

    private void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            view.mostrarMenu();
            int opcion = view.leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    listarEmpleados();
                    break;
                case 2:
                    agregarEmpleadoDesdeVista();
                    break;
                case 3:
                    buscarEmpleadoDesdeVista();
                    break;
                case 4:
                    eliminarEmpleadoDesdeVista();
                    break;
                case 5:
                    salir = true;
                    view.mostrarMensaje("¡Hasta luego!");
                    break;
                default:
                    view.mostrarError("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void agregarEmpleadoDesdeVista() {
        try {
            int numero = view.leerEntero("Ingrese el número del empleado: ");
            String nombre = view.leerString("Ingrese el nombre del empleado: ");
            double sueldo = view.leerDouble("Ingrese el sueldo del empleado: ");
            agregarEmpleado(numero, nombre, sueldo);
        } catch (NumberFormatException e) {
            view.mostrarError("Error en el formato de los datos ingresados.");
        }
    }

    private void buscarEmpleadoDesdeVista() {
        try {
            int numero = view.leerEntero("Ingrese el número del empleado a buscar: ");
            buscarEmpleado(numero);
        } catch (NumberFormatException e) {
            view.mostrarError("El número debe ser un valor entero.");
        }
    }

    private void eliminarEmpleadoDesdeVista() {
        try {
            int numero = view.leerEntero("Ingrese el número del empleado a eliminar: ");
            eliminarEmpleado(numero);
        } catch (NumberFormatException e) {
            view.mostrarError("El número debe ser un valor entero.");
        }
    }
}
