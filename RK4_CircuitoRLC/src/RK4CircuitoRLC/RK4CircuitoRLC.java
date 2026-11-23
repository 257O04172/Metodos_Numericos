public class RK4CircuitoRLC {

    // Vector de derivadas F(t, Y) donde Y[0] = y1 (carga) e Y[1] = y2 (corriente)
    public static double[] evaluarSistema(double t, double[] Y) {
        double y1 = Y[0];
        double y2 = Y[1];

        // Expresiones para dy1/dt y dy2/dt según el sistema equivalente
        double dy1 = y2;
        double dy2 = -0.4 * y2 - y1;

        return new double[] { dy1, dy2 };
    }

    // Suma vectorial escalada: res[i] = A[i] + factor * B[i]
    public static double[] sumaEscalada(double[] A, double factor, double[] B) {
        int n = A.length;
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            res[i] = A[i] + factor * B[i];
        }
        return res;
    }

    // Solución analítica exacta para comparar resultados
    public static double solucionExacta(double t) {
        double wd = Math.sqrt(0.96); // ~0.979796
        return Math.exp(-0.2 * t) * (Math.cos(wd * t) + (0.2 / wd) * Math.sin(wd * t));
    }

    public static void main(String[] args) {
        double t0 = 0.0;
        double h = 0.2;       // Variar este valor en sus experimentos (ej. 0.2, 0.1, 0.05)
        int nPuntos = 25;     // Cantidad de puntos a calcular después del punto inicial

        double[] Y = { 1.0, 0.0 }; // Condiciones iniciales: q(0) = 1.0, q'(0) = 0.0
        double t = t0;

        // Encabezado con columnas requeridas para la Actividad 3
        System.out.println("n\t t_n\t y1 (Carga)\t y2 (Corr)\t q_exacta\t Error Abs");
        System.out.println("--------------------------------------------------------------------------");

        double qExacta0 = solucionExacta(t);
        double error0 = Math.abs(qExacta0 - Y[0]);
        System.out.printf("%d\t %.2f\t %.6f\t %.6f\t %.6f\t %.6e\n", 0, t, Y[0], Y[1], qExacta0, error0);

        for (int i = 0; i < nPuntos; i++) {
            double[] k1 = evaluarSistema(t, Y);
            double[] k2 = evaluarSistema(t + h / 2.0, sumaEscalada(Y, h / 2.0, k1));
            double[] k3 = evaluarSistema(t + h / 2.0, sumaEscalada(Y, h / 2.0, k2));

            // Calcula el vector pendiente k4
            double[] k4 = evaluarSistema(t + h, sumaEscalada(Y, h, k3));

            // Actualiza cada componente de Y[j] usando la fórmula ponderada de RK4
            for (int j = 0; j < Y.length; j++) {
                Y[j] = Y[j] + (h / 6.0) * (k1[j] + 2.0 * k2[j] + 2.0 * k3[j] + k4[j]);
            }

            t += h;

            double qExacta = solucionExacta(t);
            double errorAbs = Math.abs(qExacta - Y[0]);

            System.out.printf("%d\t %.2f\t %.6f\t %.6f\t %.6f\t %.6e\n", (i + 1), t, Y[0], Y[1], qExacta, errorAbs);
        }
    }
}