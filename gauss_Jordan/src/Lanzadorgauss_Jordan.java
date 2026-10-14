public class Lanzadorgauss_Jordan {

    public static void main(String[] args) {

        // Recuperar la matriz aumentada
        double[][] matriz = DefMatriz.defmatriz();

        // Mostrar mensaje inicial
        System.out.println("Aplicando el método de Gauss-Jordan...");

        // Resolver sistema de ecuaciones
        gauss_Jordan.resolverGaussJordan(matriz);

        int n = matriz.length;

        // Imprimir resultados obtenidos
        System.out.println("\nSoluciones encontradas:");

        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + matriz[i][n]);
        }
    }
}