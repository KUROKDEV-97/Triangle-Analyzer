import java.util.Scanner;

public class TriangleAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Presentación del programa
        System.out.println("=== TriangleAnalyzer ===");
        System.out.println("Este programa determina el tipo de triángulo, calcula sus ángulos y su área.\n");

        // Entrada de datos
        System.out.print("Ingrese el lado a: ");
        double a = scanner.nextDouble();
        System.out.print("Ingrese el lado b: ");
        double b = scanner.nextDouble();
        System.out.print("Ingrese el lado c: ");
        double c = scanner.nextDouble();
        System.out.print("Ingrese la altura h (relacionada con la base): ");
        double h = scanner.nextDouble();

        String tipoTriangulo = "";

        // Determinar el tipo de triángulo usando if / else if
        if (a == b && b == c) {
            tipoTriangulo = "equilatero";
            System.out.println("El triángulo es equilátero.");
        } else if (a == b || a == c || b == c) {
            tipoTriangulo = "isosceles";
            System.out.println("El triángulo es isósceles.");
        } else {
            tipoTriangulo = "escaleno";
            System.out.println("El triángulo es escaleno.");
        }

        // Calcular los ángulos usando switch según el tipo de triángulo
        switch (tipoTriangulo) {
            case "equilatero":
                // Todos los ángulos en un triángulo equilátero miden 60°
                System.out.println("Ángulo A: 60.00°");
                System.out.println("Ángulo B: 60.00°");
                System.out.println("Ángulo C: 60.00°");
                break;

            case "isosceles":
            case "escaleno":
                // Nota importante:
                // En esta versión utilice la fórmula correcta del Teorema del Coseno:
                // cos A = (b^2 + c^2 - a^2) / (2bc)
                // Esta fórmula es estándar para calcular ángulos en cualquier triángulo.
                double anguloA = calcularAngulo(b, c, a);
                double anguloB = calcularAngulo(a, c, b);
                double anguloC = calcularAngulo(a, b, c);

                System.out.printf("Ángulo A: %.2f°\n", anguloA);
                System.out.printf("Ángulo B: %.2f°\n", anguloB);
                System.out.printf("Ángulo C: %.2f°\n", anguloC);
                break;

            default:
                System.out.println("Tipo de triángulo no reconocido.");
                break;
        }

        // Calcular el área (usando base y altura)
        double area = (c * h) / 2;
        System.out.printf("El área del triángulo es: %.2f\n", area);

        scanner.close();
    }

    // Método para calcular un ángulo en grados usando el Teorema del Coseno
    public static double calcularAngulo(double lado1, double lado2, double ladoOpuesto) {
        double numerador = Math.pow(lado1, 2) + Math.pow(lado2, 2) - Math.pow(ladoOpuesto, 2);
        double denominador = 2 * lado1 * lado2;
        double cosAngulo = numerador / denominador;
        return Math.toDegrees(Math.acos(cosAngulo));
    }
}
