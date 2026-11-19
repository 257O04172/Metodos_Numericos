public class MetodoRungeKutta {

    public static double evaluarFuncion(double x, double y) {
        // Implementación de la función f(x, y) = 2x - 6y
        return 2 * x - 6 * y;
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1;
        double xFinal = 0.3;

        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        System.out.println("n\t x_n\t y_n (RK4)");
        System.out.println("--------------------------------");
        System.out.printf("%d\t %.4f\t %.4f\n", 0, x, y);

        for (int i = 0; i < nPasos; i++) {
            // 1. Calcular las 4 pendientes (k1, k2, k3, k4)
            double k1 = evaluarFuncion(x, y);
            double k2 = evaluarFuncion(x + 0.5 * h, y + 0.5 * h * k1);
            double k3 = evaluarFuncion(x + 0.5 * h, y + 0.5 * h * k2);
            double k4 = evaluarFuncion(x + h, y + h * k3);

            // 2. Actualizar y con el promedio ponderado de las pendientes
            y = y + (h / 6.0) * (k1 + 2.0 * k2 + 2.0 * k3 + k4);

            // 3. Avanzar x un paso h
            x = x + h;

            // 4. Imprimir los resultados de la iteración actual
            System.out.printf("%d\t %.4f\t %.4f\n", (i + 1), x, y);
        }
    }
}