public class Lanzador_Gauss {
    public static void main(String[] args) {
        // 1. Mandamos llamar a la función que nos entrega la matriz aumentada [A | b]

        double[][] matriz = DefMatriz.defmatriz();
        // 2. Aplicar la eliminación gaussiana (fase de triangulación superior)
        // Convierte los elementos debajo de la diagonal principal en ceros.
        Gauss.eliminacionGaussiana(matriz);

        // 3. Obtener los resultados mediante sustitución regresiva (la bajada)
        // Despeja las incógnitas de abajo hacia arriba a partir de la matriz triangular.

        double[] soluciones = Gauss.sustitucionRegresiva(matriz);

        // 4. Imprimir resultados finales en consola de manera limpia
        System.out.println("Soluciones del sistema:");
        for (int i = 0; i < soluciones.length; i++) {
            System.out.println("x" + (i + 1) + " = " + soluciones[i]);
        }
    }
}