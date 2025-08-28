public class ContadorTest {
    public static void main(String[] args) {
        System.out.println("Acumulador inicial: " + Contador.getAcumulador());
        System.out.println("nContadores inicial: " + Contador.getNContadores());
        System.out.println("ultimoContador inicial: " + Contador.getUltimoContador());
        System.out.println();

        Contador cDefault = new Contador(); // usa VALOR_INICIAL = 10
        System.out.println("Tras crear cDefault:");
        System.out.println("  cDefault.valor = " + cDefault.getValor());
        System.out.println("  acumulador = " + Contador.getAcumulador());
        System.out.println("  nContadores = " + Contador.getNContadores());
        System.out.println("  ultimoContador = " + Contador.getUltimoContador());
        System.out.println();

        Contador cCustom = new Contador(5);
        System.out.println("Tras crear cCustom(5):");
        System.out.println("  cCustom.valor = " + cCustom.getValor());
        System.out.println("  acumulador = " + Contador.getAcumulador());
        System.out.println("  nContadores = " + Contador.getNContadores());
        System.out.println("  ultimoContador = " + Contador.getUltimoContador());
        System.out.println();

        // probar inc()
        cDefault.inc();
        cCustom.inc();
        System.out.println("Después de cDefault.inc() y cCustom.inc():");
        System.out.println("  cDefault.valor = " + cDefault.getValor());
        System.out.println("  cCustom.valor = " + cCustom.getValor());
        System.out.println("  acumulador = " + Contador.getAcumulador());
        System.out.println("  nContadores = " + Contador.getNContadores());
        System.out.println("  ultimoContador = " + Contador.getUltimoContador());
    }
}
