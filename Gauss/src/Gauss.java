public class Gauss {


    /**
     * Método que realiza la triangulación de la matriz usando Eliminación Gaussiana simple.
     * @param matriz Matriz aumentada [A | b] que será modificada directamente en memoria.
     */
    public static void eliminacionGaussiana(double[][] matriz) {
        int n = matriz.length; // Obtiene el tamaño del sistema (número de filas)

        // CICLO 1 (i): Selecciona el renglón pivote actual (la diagonal principal)
        for (int i = 0; i < n; i++) {

            // CICLO 2 (j): Recorre todos los renglones que están ABAJO del pivote actual
            for (int j = i + 1; j < n; j++) {

                // Calcula el factor de proporción para anular el coeficiente de esta columna
                double factor = matriz[j][i] / matriz[i][i];

                // CICLO 3 (k): Recorre COLUMNA POR COLUMNA la fila completa
                // para aplicar la operación matemática: R_j = R_j - (factor * R_i)
                for (int k = i; k <= n; k++) {
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }
    }

    /**
     * Método que realiza la sustitución regresiva (la bajada) para despejar las variables.
     * @param matriz Matriz ya convertida en triangular superior.
     * @return Un arreglo unidimensional con los valores de las soluciones (x1, x2, x3...).
     */
    public static double[] sustitucionRegresiva(double[][] matriz) {
        int n = matriz.length;
        double[] x = new double[n]; // Arreglo para almacenar las respuestas

        // Recorre los renglones de ABAJO hacia ARRIBA (del último al primero)
        for (int i = n - 1; i >= 0; i--) {
            double suma = 0;

            // Suma los valores de las incógnitas que ya conocemos en este renglón
            for (int j = i + 1; j < n; j++) {
                suma += matriz[i][j] * x[j];
            }

            // Despeja la incógnita actual: (Lado derecho - suma acumulada) / coeficiente del pivote
            x[i] = (matriz[i][n] - suma) / matriz[i][i];
        }

        return x; // Regresa el arreglo con todas las soluciones calculadas
    }
}