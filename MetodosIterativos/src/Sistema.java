public class Sistema {
    // Matriz de coeficientes A
    public static final double[][] A = {
            {5, 1, 1},
            {1, 4, 1},
            {1, 2, 5}
    };

    // Vector independiente b
    public static final double[] b = {7, 6, 8};

    // Vector de aproximación inicial X^(0) = [0, 0, 0]^T
    public static final double[] X0 = {0, 0, 0};

    // Tolerancia de Error Establecida
    public static final double TOLERANCIA = 0.0001;
}