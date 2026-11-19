public class MetodoEuler {

    private static double x;

    public static double evaluarFuncion(double x, double y) {
        // Implementación de la función f(x, y) = 2x - 6y
        return 2 * x - 6 * y;
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.01;
        double xFinal = 0.3;

        // Criterio de paro (número total de pasos N)
        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        System.out.println("n\t x_n\t y_n (Euler)");
        System.out.println("--------------------------------");
        System.out.printf("%d\t %.4f\t %.4f\n", 0, x, y);

        for (int i = 0; i < nPasos; i++) {
            // 1. Calcular la pendiente en el punto actual (x_n, y_n)
            double pendiente = evaluarFuncion(x, y);

            // 2. Actualizar el valor de y usando la fórmula: y_{n+1} = y_n + h * f(x_n, y_n)
            y = y + h * pendiente;

            // 3. Avanzar x un paso h: x_{n+1} = x_n + h
            x = x + h;

            // 4. Imprimir los resultados de la iteración actual (i + 1)
            System.out.printf("%d\t %.4f\t %.4f\n", (i + 1), x, y);
        }
    }
}