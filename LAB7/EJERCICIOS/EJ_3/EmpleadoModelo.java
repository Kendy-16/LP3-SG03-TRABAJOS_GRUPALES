import java.util.ArrayList;
import java.util.List;

public class EmpleadoModelo {
    private List<Empleado> empleados;

    public EmpleadoModel() {
        this.empleados = new ArrayList<>();
    }

    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = new ArrayList<>(empleados);
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public Empleado buscarEmpleado(int numero) {
        for (Empleado empleado : empleados) {
            if (empleado.getNumero() == numero) {
                return empleado;
            }
        }
        return null;
    }

    public boolean eliminarEmpleado(int numero) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNumero() == numero) {
                empleados.remove(i);
                return true;
            }
        }
        return false;
    }
}
