import java.util.*;

public class Main {
    private static GestorRecetas gestor = new GestorRecetas();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n=== 🍽 SISTEMA DE RECETAS ===");
            System.out.println("1. Insertar receta");
            System.out.println("2. Listar recetas");
            System.out.println("3. Actualizar receta");
            System.out.println("4. Eliminar receta");
            System.out.println("5. Consultas avanzadas en memoria");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> insertarReceta();
                case 2 -> listarRecetas();
                case 3 -> actualizarReceta();
                case 4 -> eliminarReceta();
                case 5 -> menuConsultasAvanzadas();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        DatabaseConnection.close();
        sc.close();
    }

    private static void insertarReceta() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Tiempo de preparación: ");
        int prep = sc.nextInt();
        System.out.print("Tiempo de cocción: ");
        int coc = sc.nextInt();
        sc.nextLine();
        System.out.print("Instrucciones: ");
        String instr = sc.nextLine();

        Receta r = new Receta(titulo, descripcion, prep, coc, instr);
        
        if (gestor.insertarRecetaSegura(r)) {
            System.out.println("Receta insertada correctamente.");
        } else {
            System.out.println("Inserción cancelada por seguridad.");
        }
    }

    private static void listarRecetas() {
        List<Receta> lista = gestor.getTodasRecetas();
        if (lista.isEmpty()) {
            System.out.println("No hay recetas para mostrar.");
        } else {
            System.out.println("\n--- LISTA DE RECETAS (" + lista.size() + ") ---");
            for (Receta r : lista) {
                System.out.println("\nID: " + r.getId());
                System.out.println("Título: " + r.getTitulo());
                System.out.println("Descripción: " + r.getDescripcion());
                System.out.println("Preparación: " + r.getTiempoPreparacion() + " min");
                System.out.println("Cocción: " + r.getTiempoCoccion() + " min");
                System.out.println("Instrucciones: " + r.getInstrucciones());
                System.out.println("Tiempo total: " + (r.getTiempoPreparacion() + r.getTiempoCoccion()) + " min");
            }
        }
    }

    private static void actualizarReceta() {
        System.out.print("ID de receta a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo título: ");
        String titulo = sc.nextLine();
        System.out.print("Nueva descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Nuevo tiempo de preparación: ");
        int prep = sc.nextInt();
        System.out.print("Nuevo tiempo de cocción: ");
        int coc = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevas instrucciones: ");
        String instr = sc.nextLine();

        Receta r = new Receta(id, titulo, descripcion, prep, coc, instr);
        
        if (gestor.actualizarRecetaSegura(r)) {
            System.out.println("Receta actualizada correctamente.");
        } else {
            System.out.println("Actualización cancelada por seguridad.");
        }
    }

    private static void eliminarReceta() {
        System.out.print("ID de receta a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        if (gestor.eliminarRecetaSegura(id)) {
            System.out.println("Receta eliminada correctamente.");
        } else {
            System.out.println("Eliminación cancelada por seguridad.");
        }
    }

    private static void menuConsultasAvanzadas() {
        System.out.println("\n===  CONSULTAS AVANZADAS EN MEMORIA ===");
        System.out.println("Total de recetas en memoria: " + gestor.getTotalRecetas());
        
        System.out.println("\n1. Recetas ordenadas por título (A-Z)");
        System.out.println("2. Recetas rápidas (menos de 30 min total)");
        System.out.println("3. Top 5 recetas más recientes (por ID)");
        System.out.println("4. Buscar recetas por palabra clave");
        System.out.println("5. Consulta personalizada completa");
        System.out.print("Seleccione consulta: ");
        
        int consulta = sc.nextInt();
        sc.nextLine();
        
        switch (consulta) {
            case 1 -> consultarOrdenadasPorTitulo();
            case 2 -> consultarRecetasRapidas();
            case 3 -> consultarTop5Recientes();
            case 4 -> buscarPorPalabraClave();
            case 5 -> consultaPersonalizadaCompleta();
            default -> System.out.println("Consulta no válida");
        }
    }

    private static void consultarOrdenadasPorTitulo() {
        List<Receta> resultado = gestor.consultarRecetas(
            true, true, true, true, true, true,  
            null, null,                          
            "titulo", false,                     
            0                                    
        );
        
        mostrarResultadoConsulta(resultado, "RECETAS ORDENADAS POR TÍTULO (A-Z)");
    }

    private static void consultarRecetasRapidas() {
        List<Receta> resultado = gestor.consultarRecetas(
            true, true, false, true, true, false,  
            "tiempo_total", "30",                  
            "tiempo_total", false,                 
            0                                      
        );
        
        mostrarResultadoConsulta(resultado, "RECETAS RÁPIDAS (≤ 30 MIN)");
    }

    private static void consultarTop5Recientes() {
        List<Receta> resultado = gestor.consultarRecetas(
            true, true, false, false, false, false,  
            null, null,                             
            "id", true,                             
            5                                      
        );
        
        mostrarResultadoConsulta(resultado, "TOP 5 RECETAS MÁS RECIENTES");
    }

    private static void buscarPorPalabraClave() {
        System.out.print("Palabra clave a buscar: ");
        String palabra = sc.nextLine();
        
        List<Receta> resultado = gestor.consultarRecetas(
            true, true, true, false, false, false,  
            "titulo", palabra,                     
            null, false,                            
            0                                       
        );
        
        mostrarResultadoConsulta(resultado, "RECETAS QUE CONTIENEN: '" + palabra + "'");
    }

    private static void consultaPersonalizadaCompleta() {
        System.out.println("\n--- CONFIGURAR CONSULTA PERSONALIZADA ---");
        
        System.out.println("¿Qué campos desea mostrar?");
        System.out.print("Mostrar ID? (s/n): ");
        boolean mostrarId = sc.nextLine().equals("s");
        System.out.print("Mostrar título? (s/n): ");
        boolean mostrarTitulo = sc.nextLine().equals("s");
        System.out.print("Mostrar descripción? (s/n): ");
        boolean mostrarDescripcion = sc.nextLine().equals("s");
        System.out.print("Mostrar tiempo preparación? (s/n): ");
        boolean mostrarTiempoPrep = sc.nextLine().equals("s");
        System.out.print("Mostrar tiempo cocción? (s/n): ");
        boolean mostrarTiempoCoccion = sc.nextLine().equals("s");
        System.out.print("Mostrar instrucciones? (s/n): ");
        boolean mostrarInstrucciones = sc.nextLine().equals("s");
        
        String filtroCampo = null;
        String filtroValor = null;
        System.out.print("¿Desea aplicar filtro? (s/n): ");
        if (sc.nextLine().equals("s")) {
            System.out.print("Campo a filtrar (titulo/descripcion/instrucciones/tiempo_total): ");
            filtroCampo = sc.nextLine();
            System.out.print("Valor a buscar: ");
            filtroValor = sc.nextLine();
        }
        
        String ordenarPor = null;
        boolean ordenDescendente = false;
        System.out.print("¿Desea ordenar? (s/n): ");
        if (sc.nextLine().equals("s")) {
            System.out.print("Campo para ordenar (id/titulo/tiempo_total): ");
            ordenarPor = sc.nextLine();
            System.out.print("Orden descendente? (s/n): ");
            ordenDescendente = sc.nextLine().equals("s");
        }
        
        int limite = 0;
        System.out.print("Límite de resultados (0 para sin límite): ");
        limite = sc.nextInt();
        sc.nextLine();
        
        List<Receta> resultado = gestor.consultarRecetas(
            mostrarId, mostrarTitulo, mostrarDescripcion, mostrarTiempoPrep, 
            mostrarTiempoCoccion, mostrarInstrucciones, filtroCampo, filtroValor,
            ordenarPor, ordenDescendente, limite
        );
        
        mostrarResultadoConsulta(resultado, "CONSULTA PERSONALIZADA");
    }

    private static void mostrarResultadoConsulta(List<Receta> resultado, String titulo) {
        System.out.println("\n--- " + titulo + " ---");
        System.out.println("Resultados encontrados: " + resultado.size());
        
        if (resultado.isEmpty()) {
            System.out.println("No se encontraron recetas que coincidan con los criterios.");
        } else {
            for (Receta r : resultado) {
                System.out.println("\n---");
                if (r.getId() > 0) System.out.println("ID: " + r.getId());
                if (!r.getTitulo().equals("[OCULTO]")) System.out.println("Título: " + r.getTitulo());
                if (!r.getDescripcion().equals("[OCULTO]")) System.out.println("Descripción: " + r.getDescripcion());
                if (r.getTiempoPreparacion() > 0) System.out.println("Preparación: " + r.getTiempoPreparacion() + " min");
                if (r.getTiempoCoccion() > 0) System.out.println("Cocción: " + r.getTiempoCoccion() + " min");
                if (!r.getInstrucciones().equals("[OCULTO]")) System.out.println("Instrucciones: " + r.getInstrucciones());
                
                if (r.getTiempoPreparacion() > 0 && r.getTiempoCoccion() > 0) {
                    System.out.println("Tiempo total: " + (r.getTiempoPreparacion() + r.getTiempoCoccion()) + " min");
                }
            }
        }
    }
}


