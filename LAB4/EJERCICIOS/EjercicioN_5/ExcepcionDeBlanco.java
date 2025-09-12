class ExcepcionDeBlanco extends Exception {
    public ExcepcionDeBlanco() {
        super("(!) Excepción de blanco: Espacio en blanco detectado");
    }
    
    public ExcepcionDeBlanco(String mensaje) {
        super(mensaje);
    }
}
