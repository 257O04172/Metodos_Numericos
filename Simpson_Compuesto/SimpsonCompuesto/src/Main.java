public class Main {
    public static void main(String[] args) {
        double a = 0.0;
        double b = 2.0;
        double tolerancia = 0.0001;
        double valorExacto = 8.0 / 3.0;

        System.out.println("Comparacion de integracion numerica");
        System.out.println("f(x) = x^2");
        System.out.printf("Intervalo: [%.1f, %.1f]%n", a, b);
        System.out.printf("Tolerancia: %.6f%n", tolerancia);
        System.out.printf("Valor exacto: %.10f%n", valorExacto);

        double trapecio = TrapecioCompuesto.integrarConTolerancia(a, b, tolerancia);
        double simpson = SimpsonCompuesto.integrarConTolerancia(a, b, tolerancia);

        System.out.println("\nRESULTADOS FINALES");
        System.out.printf("Trapecio compuesto: %.10f | error real = %.10f%n",
                trapecio, Math.abs(valorExacto - trapecio));
        System.out.printf("Simpson 1/3 compuesto: %.10f | error real = %.10f%n",
                simpson, Math.abs(valorExacto - simpson));
    }
}