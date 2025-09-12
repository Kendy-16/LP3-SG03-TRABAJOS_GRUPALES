class Main {
  public static void main(String[] args) {
        GestorContactos gestor = new GestorContactos();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE CONTACTOS ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Modificar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Buscar contacto");
            System.out.println("5. Listar contactos");
            System.out.println("6. Agregar categoría");
            System.out.println("7. Listar categorías");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese teléfono: ");
                        long fono = scanner.nextLong();
                        scanner.nextLine(); // Limpiar buffer
                        System.out.print("Ingrese correo: ");
                        String correo = scanner.nextLine();
                        
                        try {
                            Contacto nuevo = new Contacto(nombre, fono, correo);
                            gestor.agregarContacto(nuevo);
                        } catch (ExcepcionDeBlanco | ExcepcionFormatoCorreo e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                        
                    case 2:
                        System.out.print("Ingrese el nombre del contacto a modificar: ");
                        String nombreModificar = scanner.nextLine();
                        Contacto contactoExistente = gestor.buscarContacto(nombreModificar);
                        
                        if (contactoExistente != null) {
                            System.out.print("Nuevo nombre (" + contactoExistente.getNombre() + "): ");
                            String nuevoNombre = scanner.nextLine();
                            if (nuevoNombre.isEmpty()) nuevoNombre = contactoExistente.getNombre();
                            
                            System.out.print("Nuevo teléfono (" + contactoExistente.getFono() + "): ");
                            String fonoStr = scanner.nextLine();
                            long nuevoFono = fonoStr.isEmpty() ? contactoExistente.getFono() : Long.parseLong(fonoStr);
                            
                            System.out.print("Nuevo correo (" + contactoExistente.getCorreo() + "): ");
                            String nuevoCorreo = scanner.nextLine();
                            if (nuevoCorreo.isEmpty()) nuevoCorreo = contactoExistente.getCorreo();
                            
                            try {
                                Contacto contactoModificado = new Contacto(nuevoNombre, nuevoFono, nuevoCorreo);
                                gestor.modificarContacto(nombreModificar, contactoModificado);
                            } catch (ExcepcionDeBlanco | ExcepcionFormatoCorreo e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Contacto no encontrado");
                        }
                        break;
                        
                    case 3:
                        System.out.print("Ingrese el nombre del contacto a eliminar: ");
                        String nombreEliminar = scanner.nextLine();
                        gestor.eliminarContacto(nombreEliminar);
                        break;
                        
                    case 4:
                        System.out.print("Ingrese el nombre del contacto a buscar: ");
                        String nombreBuscar = scanner.nextLine();
                        Contacto encontrado = gestor.buscarContacto(nombreBuscar);
                        
                        if (encontrado != null) {
                            System.out.println("Contacto encontrado: " + encontrado);
                        } else {
                            System.out.println("Contacto no encontrado");
                        }
                        break;
                        
                    case 5:
                        gestor.listarContactos();
                        break;
                        
                    case 6:
                        System.out.print("Ingrese nombre de la categoría: ");
                        String nombreCategoria = scanner.nextLine();
                        System.out.print("Ingrese descripción: ");
                        String descripcion = scanner.nextLine();
                        
                        try {
                            Categoria nuevaCategoria = new Categoria(nombreCategoria, descripcion);
                            gestor.agregarCategoria(nuevaCategoria);
                        } catch (ExcepcionDeBlanco e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                        
                    case 7:
                        gestor.listarCategorias();
                        break;
                        
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                        
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido");
                scanner.nextLine(); 
                opcion = -1;
            } catch (NumberFormatException e) {
                System.out.println("Error: Formato de número inválido");
                opcion = -1;
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                opcion = -1;
            }
        } while (opcion != 0);
        
        scanner.close();
    }
}
