public class EnviarCorreo implements CanalNotificacion {

    @Override
    public void enviarNotificacion(String mensaje, String destinatario) {
        System.out.println("Enviando correo a " + destinatario + ": " + mensaje);
    }
    
    @Override
    public boolean estaDisponible() {
        return true;
    }

}
