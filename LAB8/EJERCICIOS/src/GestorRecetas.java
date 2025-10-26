import java.util.*;

public class GestorRecetas {
    private List<Receta> recetas;
    private RecetaDAO dao;
    
    public GestorRecetas() {
        this.dao = new RecetaDAO();
        this.recetas = new ArrayList<>();
        cargarRecetasDesdeBD();
    }
    
    private void cargarRecetasDesdeBD() {
        this.recetas = dao.listar();
        System.out.println("- " + recetas.size() + " recetas cargadas en memoria");
    }
    
    public List<Receta> consultarRecetas(
            boolean mostrarId, 
            boolean mostrarTitulo, 
            boolean mostrarDescripcion,
            boolean mostrarTiempoPrep, 
            boolean mostrarTiempoCoccion,
            boolean mostrarInstrucciones,
            String filtroCampo, 
            String filtroValor,
            String ordenarPor, 
            boolean ordenDescendente,
            int limite) {
        
        List<Receta> resultado = new ArrayList<>();
        
        for (Receta receta : recetas) {
            resultado.add(receta);
        }
        
        if (filtroCampo != null && filtroValor != null) {
            resultado = aplicarFiltro(resultado, filtroCampo, filtroValor);
        }
        
        if (ordenarPor != null) {
            resultado = ordenarRecetas(resultado, ordenarPor, ordenDescendente);
        }
        
        if (limite > 0 && limite < resultado.size()) {
            resultado = aplicarLimite(resultado, limite);
        }
        
        if (!mostrarId || !mostrarTitulo || !mostrarDescripcion || 
            !mostrarTiempoPrep || !mostrarTiempoCoccion || !mostrarInstrucciones) {
            resultado = crearRecetasConCamposSelectos(resultado, mostrarId, mostrarTitulo, 
                    mostrarDescripcion, mostrarTiempoPrep, mostrarTiempoCoccion, mostrarInstrucciones);
        }
        
        return resultado;
    }
    
    private List<Receta> aplicarFiltro(List<Receta> recetas, String campo, String valor) {
        List<Receta> resultadoFiltrado = new ArrayList<>();
        
        for (Receta receta : recetas) {
            boolean cumple = false;
            
            if (campo.equals("titulo") && receta.getTitulo().contains(valor)) {
                cumple = true;
            } else if (campo.equals("descripcion") && receta.getDescripcion().contains(valor)) {
                cumple = true;
            } else if (campo.equals("instrucciones") && receta.getInstrucciones().contains(valor)) {
                cumple = true;
            } else if (campo.equals("tiempo_total")) {
                int tiempoTotal = receta.getTiempoPreparacion() + receta.getTiempoCoccion();
                if (tiempoTotal <= Integer.parseInt(valor)) {
                    cumple = true;
                }
            }
            
            if (cumple) {
                resultadoFiltrado.add(receta);
            }
        }
        
        return resultadoFiltrado;
    }
    
    private List<Receta> ordenarRecetas(List<Receta> recetas, String campo, boolean descendente) {
        for (int i = 0; i < recetas.size() - 1; i++) {
            for (int j = 0; j < recetas.size() - i - 1; j++) {
                Receta receta1 = recetas.get(j);
                Receta receta2 = recetas.get(j + 1);
                
                boolean debeIntercambiar = false;
                
                if (campo.equals("id")) {
                    if (descendente) {
                        debeIntercambiar = receta1.getId() < receta2.getId();
                    } else {
                        debeIntercambiar = receta1.getId() > receta2.getId();
                    }
                } else if (campo.equals("titulo")) {
                    int comparacion = receta1.getTitulo().compareTo(receta2.getTitulo());
                    if (descendente) {
                        debeIntercambiar = comparacion < 0;
                    } else {
                        debeIntercambiar = comparacion > 0;
                    }
                } else if (campo.equals("tiempo_total")) {
                    int tiempo1 = receta1.getTiempoPreparacion() + receta1.getTiempoCoccion();
                    int tiempo2 = receta2.getTiempoPreparacion() + receta2.getTiempoCoccion();
                    if (descendente) {
                        debeIntercambiar = tiempo1 < tiempo2;
                    } else {
                        debeIntercambiar = tiempo1 > tiempo2;
                    }
                }
                
                if (debeIntercambiar) {
                    Receta temp = recetas.get(j);
                    recetas.set(j, recetas.get(j + 1));
                    recetas.set(j + 1, temp);
                }
            }
        }
        
        return recetas;
    }
    
    private List<Receta> aplicarLimite(List<Receta> recetas, int limite) {
        List<Receta> resultadoLimitado = new ArrayList<>();
        for (int i = 0; i < limite && i < recetas.size(); i++) {
            resultadoLimitado.add(recetas.get(i));
        }
        return resultadoLimitado;
    }
    
    private List<Receta> crearRecetasConCamposSelectos(List<Receta> recetas, 
            boolean mostrarId, boolean mostrarTitulo, boolean mostrarDescripcion,
            boolean mostrarTiempoPrep, boolean mostrarTiempoCoccion, boolean mostrarInstrucciones) {
        
        List<Receta> resultado = new ArrayList<>();
        
        for (Receta recetaOriginal : recetas) {
            int id = mostrarId ? recetaOriginal.getId() : 0;
            String titulo = mostrarTitulo ? recetaOriginal.getTitulo() : "[OCULTO]";
            String descripcion = mostrarDescripcion ? recetaOriginal.getDescripcion() : "[OCULTO]";
            int tiempoPrep = mostrarTiempoPrep ? recetaOriginal.getTiempoPreparacion() : 0;
            int tiempoCoccion = mostrarTiempoCoccion ? recetaOriginal.getTiempoCoccion() : 0;
            String instrucciones = mostrarInstrucciones ? recetaOriginal.getInstrucciones() : "[OCULTO]";
            
            Receta recetaSelecta = new Receta(id, titulo, descripcion, tiempoPrep, tiempoCoccion, instrucciones);
            resultado.add(recetaSelecta);
        }
        
        return resultado;
    }
    
    public boolean insertarRecetaSegura(Receta receta) {
        if (GestorSeguridad.verificarClave()) {
            dao.insertar(receta);
            cargarRecetasDesdeBD(); 
            return true;
        }
        return false;
    }
    
    public boolean actualizarRecetaSegura(Receta receta) {
        if (GestorSeguridad.verificarClave()) {
            dao.actualizar(receta);
            cargarRecetasDesdeBD(); 
            return true;
        }
        return false;
    }
    
    public boolean eliminarRecetaSegura(int id) {
        if (GestorSeguridad.verificarClave()) {
            dao.eliminar(id);
            cargarRecetasDesdeBD(); 
            return true;
        }
        return false;
    }
    
    public List<Receta> getTodasRecetas() {
        List<Receta> copia = new ArrayList<>();
        for (Receta receta : recetas) {
            copia.add(receta);
        }
        return copia;
    }
    
    public int getTotalRecetas() {
        return recetas.size();
    }
}