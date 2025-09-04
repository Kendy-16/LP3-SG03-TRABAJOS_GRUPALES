public class Main {
    public static void main(String[] args) {
        // Creamos las instancias concretas (los especialistas)
        EmailManager emailManager = new EmailManager();
        SMSManager smsManager = new SMSManager();
        WspManager wspManager = new WspManager();

        // Inyectamos las dependencias en NotificationManager
        NotificationManager notifier = new NotificationManager(emailManager, smsManager, wspManager);

        // Usamos NotificationManager: el cliente sólo pide notificaciones, no sabe ni cómo ni quién las envía.
        notifier.sendEmail("Hola, este es un correo de prueba.");
        notifier.sendSMS("Hola, este es un SMS de prueba.");
        notifier.sendWhatsApp("Hola, este es un WhatsApp de prueba.");
    }
