package L2;

public class EjemploCarro { 

        public static void main(String[] args) {
            Motor m1 = new Motor(1, 5000);
            Motor m2 = new Motor(2, 6000);
        
            Automovil auto = new Automovil("V6O-671", 4, "Toyota", "Serie3", m1); 
            auto.agregarMotor(m1);
            auto.agregarMotor(m2);
        
            System.out.println(auto); // muestra datos del auto con su motor principal
        
            Motor elegido = auto.testAgregacion(); // pide al usuario seleccionar
            if (elegido != null) {
                System.out.println("Motor seleccionado:");
                System.out.println(elegido);
            }
        }
    
}
   
    
