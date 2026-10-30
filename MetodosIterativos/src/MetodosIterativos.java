import java.util.Arrays;

public class MetodosIterativos {

    // Método para calcular el Error bajo la Norma Infinito (Máxima Diferencia Absoluta)
    private static double calcularError(double[] actual, double[] anterior) {
        double maxError = 0;
        for (int i = 0; i < actual.length; i++) {
            double diff = Math.abs(actual[i] - anterior[i]);
            if (diff > maxError)
            {
                maxError = diff;
            }
        }
        return maxError;
    }

    // --- MÉTODO DE JACOBI ---
    public static void resolverJacobi(double[][] A, double[] b, double[] X0,
                                      double tolerancia) {
        int n = b.length;
        double[] xAnterior = Arrays.copyOf(X0, n);
        double[] xActual = new double[n];
        int iteraciones = 0;
        double error = Double.MAX_VALUE;

        System.out.println("\n--- ITERACIONES - MÉTODO DE JACOBI ---");
        System.out.printf("%-5s %-12s %-12s %-12s %-12s\n", "Iter", "x", "y",
                "z", "Error");

        while (error > tolerancia && iteraciones < 100) {
            iteraciones++;

            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma += A[i][j] * xAnterior[j];
                    }
                }
                xActual[i] = (b[i] - suma) / A[i][i];
            }

            error = calcularError(xActual, xAnterior);
            System.out.printf("%-5d %-12.6f %-12.6f %-12.6f %-12.6f\n",
                    iteraciones, xActual[0], xActual[1], xActual[2], error);

            xAnterior = Arrays.copyOf(xActual, n);
        }
        System.out.printf("\nJacobi convergió en %d iteraciones.\n Solución: %s\n",
                iteraciones, Arrays.toString(xActual));
    }

    // --- MÉTODO DE GAUSS-SEIDEL ---
    public static void resolverGaussSeidel(double[][] A, double[] b, double[]
            X0, double tolerancia) {
        int n = b.length;
        double[] xActual = Arrays.copyOf(X0, n);
        double[] xAnterior = new double[n];
        int iteraciones = 0;
        double error = Double.MAX_VALUE;

        System.out.println("\n--- ITERACIONES - MÉTODO DE GAUSS-SEIDEL -- ");
        System.out.printf("%-5s %-12s %-12s %-12s %-12s\n", "Iter", "x", "y", "z", "Error");

        while (error > tolerancia && iteraciones < 100) {
            iteraciones++;
            xAnterior = Arrays.copyOf(xActual, n); // Guardar estado para calcularel error.

            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j)
                    {
                        suma += A[i][j] * xActual[j]; // Usa valores actualizados inmediatamente.
                    }
                }
                xActual[i] = (b[i] - suma) / A[i][i];
            }

            error = calcularError(xActual, xAnterior);
            System.out.printf("%-5d %-12.6f %-12.6f %-12.6f %-12.6f\n",
                    iteraciones, xActual[0], xActual[1], xActual[2], error);
        }
        System.out.printf("\nGauss-Seidel convergió en %d iteraciones.\n Solución: %s\n", iteraciones, Arrays.toString(xActual));
    }
}