public class SimpsonCompuesto {

    private static double calcularSimpson(double a, double b, int n) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException(
                    "Simpson 1/3 compuesto requiere un numero par de subintervalos.");
        }

        double h = TrapecioCompuesto.calcularH(a, b, n);
        double sumaImpares = 0.0;
        double sumaPares = 0.0;

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;

            if (k % 2 != 0) {
                sumaImpares += TrapecioCompuesto.funcion(xk);
            } else {
                sumaPares += TrapecioCompuesto.funcion(xk);
            }
        }

        double sumaTotal = TrapecioCompuesto.funcion(a)
                + 4 * sumaImpares
                + 2 * sumaPares
                + TrapecioCompuesto.funcion(b);

        return (h / 3.0) * sumaTotal;
    }

    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2;
        int iteraciones = 0;
        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = Double.POSITIVE_INFINITY;

        System.out.println("\nSIMPSON 1/3 COMPUESTO");
        System.out.printf("Inicial: n = %d, I = %.10f%n", n, integralAnterior);

        while (errorAbsoluto > tolerancia) {
            n *= 2;
            double integralNueva = calcularSimpson(a, b, n);
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