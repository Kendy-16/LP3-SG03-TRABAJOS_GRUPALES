public class EnviarSMS implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje, String destinatario) {
        System.out.println("Enviando SMS a " + destinatario + ": " + mensaje);
    }
    
    @Override
    public boolean estaDisponible() {
        return true;
    }
}
