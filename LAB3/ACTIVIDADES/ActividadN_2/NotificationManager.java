public class NotificationManager {
    private final EmailManager emailManager; 
    private final SMSManager smsManager;   
    private final WspManager wspManager;   

    public NotificationManager(EmailManager emailManager, SMSManager smsManager, WspManager wspManager) {
        this.emailManager = emailManager;
        this.smsManager = smsManager;
        this.wspManager = wspManager;
    }

    // Cada método delega la acción al gestor correspondiente
    public void sendEmail(String message) {
        emailManager.SendEmail(message);
    }

    public void sendSMS(String message) {
        smsManager.SendSMS(message);
    }

    public void sendWhatsApp(String message) {
        wspManager.SendWsp(message);
    }
}
