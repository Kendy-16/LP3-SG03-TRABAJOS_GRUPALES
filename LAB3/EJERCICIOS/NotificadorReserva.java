
public class NotificadorReserva {
    private CanalNotificacion canal;
    
    public NotificadorReserva(CanalNotificacion canal) {
        this.canal = canal;
    }
    
    public void notificarConfirmacionReserva(Reserva reserva) {
        String mensaje = "Su reserva #" + reserva.getId() + " ha sido confirmada";
        canal.enviarNotificacion(mensaje, reserva.getNombre());
    }
    
    public void notificarCancelacionReserva(Reserva reserva) {
        String mensaje = "Su reserva #" + reserva.getId() + " ha sido cancelada";
        canal.enviarNotificacion(mensaje, reserva.getNombre());
    }
}
