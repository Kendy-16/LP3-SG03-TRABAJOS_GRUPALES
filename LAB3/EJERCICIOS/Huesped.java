
public class Huesped {
	private String nombre;
	private long telefono;
	private int dni;
	
	public Huesped(String nombre, long telefono, int dni) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.dni = dni;
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "| Nombre: " + nombre +
				"| DNI: " + dni +
				"| Teléfono" + telefono;
	}
	
}
