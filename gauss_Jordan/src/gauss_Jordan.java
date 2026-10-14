public class gauss_Jordan {

    // Método principal que aplica Gauss-Jordan
    public static void resolverGaussJordan(double[][] matriz) {

        int n = matriz.length;

        // Reutiliza el método desarrollado anteriormente
        Gauss.eliminacionGaussiana(matriz);

        // Proceso de reducción hacia arriba
        for (int i = n - 1; i >= 0; i--) {

            // Obtener el pivote actual
            double pivote = matriz[i][i];

            // Convertir el pivote en 1
            for (int k = i; k <= n; k++) {
                matriz[i][k] /= pivote;
            }

            // Eliminar elementos superiores
            for (int j = i - 1; j >= 0; j--) {

                double factor = matriz[j][i];

                for (int k = i; k <= n; k++) {
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }
    }
}