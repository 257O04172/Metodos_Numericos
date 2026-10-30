public class Main {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE ECUACIONES A RESOLVER:");
        System.out.println("5x +  y +  z = 7");
        System.out.println(" x + 4y +  z = 6");
        System.out.println(" x + 2y + 5z = 8");
        System.out.println("Aproximación inicial: [0.0, 0.0, 0.0]");
        System.out.println("Tolerancia: " + Sistema.TOLERANCIA);

        // Ejecución del Método de Jacobi 
        MetodosIterativos.resolverJacobi(Sistema.A, Sistema.b, Sistema.X0,
                Sistema.TOLERANCIA);

        // Ejecución del Método de Gauss-Seidel 
        MetodosIterativos.resolverGaussSeidel(Sistema.A, Sistema.b,
                Sistema.X0, Sistema.TOLERANCIA);
    }
}