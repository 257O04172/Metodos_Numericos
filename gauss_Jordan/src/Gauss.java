public class Gauss {

    // Realiza la fase de eliminación gaussiana
    public static void eliminacionGaussiana(double[][] matriz) {

        int n = matriz.length;

        // Recorrido de cada pivote
        for (int i = 0; i < n; i++) {

            // Eliminación de elementos debajo del pivote
            for (int j = i + 1; j < n; j++) {

                // Cálculo del factor multiplicador
                double factor = matriz[j][i] / matriz[i][i];

                // Actualización de la fila correspondiente
                for (int k = i; k <= n; k++) {
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }
    }
}