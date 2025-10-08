package modelo;
public class Producto {
  
  protected String nombre;
  protected double peso;
  protected double precio;
  protected String categoria;
  protected String identificador;
  protected String descripcion;
  
  public Producto(String nombre, double peso, double precio, String categoria, String identificador, String descripcion) {
    
    this.setNombre(nombre);
    this.setPeso(peso);
    this.setPrecio(precio);
    this.setCategoria(categoria);
    this.setIdentificador(identificador);
    this.setDescripcion(descripcion);
    
  }

  public String getDescripcion() {
	  return descripcion;
  }

  public void setDescripcion(String descripcion) {
	  this.descripcion = descripcion;
  }

  public String getIdentificador() {
	  return identificador;
  }

  public void setIdentificador(String identificador) {
	  this.identificador = identificador;
  }

  public String getCategoria() {
	  return categoria;
  }

  public void setCategoria(String categoria) {
	  this.categoria = categoria;
  }

  public double getPrecio() {
	  return precio;
  }

  public void setPrecio(double precio) {
	  this.precio = precio;
  }

  public double getPeso() {
	  return peso;
  }

  public void setPeso(double peso) {
	  this.peso = peso;
  }

  public String getNombre() {
	  return nombre;
  }

  public void setNombre(String nombre) {
	  this.nombre = nombre;
  }
  
  @Override
  public String toString() {
    return "  Nombre: " + nombre +
           "\n|Peso: " + peso + " kg" +
           "\n|Precio: S/ " + precio +
           "\n|Categoría: " + categoria +
           "\n|Código: " + identificador +
           "\n|Descripción: " + descripcion;
  }

}
