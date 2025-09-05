public interface CanalNotificacion {
    void enviarNotificacion(String mensaje, String destinatario);
    boolean estaDisponible();
}
