package Ajuste_de_Funciones;

/**
 * Clase que implementa el calculo de Regresion Lineal Simple
 * utilizando el metodo de Minimos Cuadrados, incluyendo Pearson y R2.
 */
public class RegresionLineal {

    /**
     * 1. MÉTODO DE CÁLCULO
     * Calcula la regresion y retorna los coeficientes (beta0, beta1, r, r2).
     */
    public static double[] calcularMinimosCuadrados(double[] x, double[] y) {
        if (x.length != y.length || x.length == 0) {
            System.out.println("Error: Los arreglos deben tener el mismo tamano y no estar vacios.");
            return new double[]{0.0, 0.0, 0.0, 0.0};
        }

        int n = x.length;
        double sumX = 0, sumY = 0, sumX2 = 0, sumY2 = 0, sumXY = 0;

        // Acumulamos las sumatorias necesarias
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumX2 += x[i] * x[i];
            sumY2 += y[i] * y[i];
            sumXY += x[i] * y[i];
        }

        // Formulas oficiales de Minimos Cuadrados
        double beta1 = (n * sumXY - sumX * sumY) / (n * sumX2 - (sumX * sumX));
        double beta0 = (sumY - beta1 * sumX) / n;

        // Implementacion del calculo de Pearson (r) y el coeficiente de determinacion (r2)
        double denominadorPearson = Math.sqrt((n * sumX2 - (sumX * sumX)) * (n * sumY2 - (sumY * sumY)));
        double pearsonR = 0.0;
        if (denominadorPearson != 0) {
            pearsonR = (n * sumXY - sumX * sumY) / denominadorPearson;
        }
        double r2 = pearsonR * pearsonR;

        // Impresion de resultados en consola
        System.out.println("--- RESULTADOS DE MINIMOS CUADRADOS Y CORRELACION ---");
        System.out.printf("Sumatorias: n=%d, X=%.1f, Y=%.1f, X2=%.1f, Y2=%.1f, XY=%.1f%n", n, sumX, sumY, sumX2, sumY2, sumXY);
        System.out.printf("Pendiente (beta1): %.4f%n", beta1);
        System.out.printf("Ordenada al origen (beta0): %.4f%n", beta0);
        System.out.printf("Modelo obtenido: Y = %.4f + %.4f * X%n", beta0, beta1);
        System.out.printf("Coeficiente de Pearson (r): %.4f%n", pearsonR);
        System.out.printf("Coeficiente de Determinacion (r2): %.4f%n", r2);

        return new double[]{beta0, beta1, pearsonR, r2};
    }

    /**
     * 2. MÉTODO DE PREDICCIÓN
     * Realiza una estimacion evaluando el modelo con un valor de X.
     */
    public static double predecir(double beta0, double beta1, double xValor) {
        return beta0 + beta1 * xValor;
    }

    /**
     * 3. MÉTODO PRINCIPAL (MAIN)
     * Punto de ejecución y pruebas en consola.
     */
    public static void main(String[] args) {
        // Datos de prueba estándar
        double[] x = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] y = {2.0, 4.0, 5.0, 4.0, 5.0};

        // Ejecutamos el cálculo
        double[] resultados = calcularMinimosCuadrados(x, y);

        // Probamos una predicción con X = 6.0
        double xPrueba = 6.0;
        double yPredicha = predecir(resultados[0], resultados[1], xPrueba);
        System.out.printf("Prediccion para X = %.1f -> Y = %.4f%n", xPrueba, yPredicha);
    }
}