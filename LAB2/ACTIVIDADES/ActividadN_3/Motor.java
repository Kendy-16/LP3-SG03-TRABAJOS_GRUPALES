package L2;

public class Motor {
	
	//Atributos
	private int numMotor;
	private int revolucionesPorMin;
	
	public Motor() {
		this.numMotor = 0;
		this.revolucionesPorMin = 0;		
	}
	
	public Motor(int numMotor, int revolucionesPorMin) {
		this.setNumMotor(numMotor);
		this.setRevolucionesPorMin(revolucionesPorMin);
	}

	protected int getNumMotor() {
		return numMotor;
	}

	protected void setNumMotor(int numMotor) {
		this.numMotor = numMotor;
	}

	protected int getRevolucionesPorMin() {
		return revolucionesPorMin;
	}

	protected void setRevolucionesPorMin(int revolucionesPorMin) {
		this.revolucionesPorMin = revolucionesPorMin;
	}
	
	public String toString() {
        return "Información del motor\n" + "Números de motores: "+ numMotor + "/nRevoluciones por minuto: " + revolucionesPorMin;

	}

}//Fin clase Motor
