public class TrapecioCompuesto {
    public static double funcion(double x) {
        return x * x;
    }

    public static double calcularH(double a, double b, int n) {
        return (b - a) / n;
    }

    private static double calcularTrapecio(double a, double b, int n) {
        double h = calcularH(a, b, n);
        double sumaInteriores = 0.0;

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;
            sumaInteriores += funcion(xk);
        }

        double sumaTotal = funcion(a) + 2 * sumaInteriores + funcion(b);
        return (h / 2.0) * sumaTotal;
    }

    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2;
        int iteraciones = 0;
        double integralAnterior = calcularTrapecio(a, b, n);
        double errorAbsoluto = Double.POSITIVE_INFINITY;

        System.out.println("\nTRAPECIO COMPUESTO");
        System.out.printf("Inicial: n = %d, I = %.10f%n", n, integralAnterior);

        while (errorAbsoluto > tolerancia) {
            n *= 2;
            double integralNueva = calcularTrapecio(a, b, n);
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);
            iteraciones++;

            System.out.printf("Iteracion %d: n = %d, I = %.10f, error = %.10f%n",
                    iteraciones, n, integralNueva, errorAbsoluto);

            integralAnterior = integralNueva;
        }

        System.out.printf("Convergencia: %d iteraciones, n = %d%n", iteraciones, n);
        return integralAnterior;
    }
}