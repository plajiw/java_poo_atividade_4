import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Calculadora de IMC");
        double peso = scanner.nextDouble();
        double altura = scanner.nextDouble();
        scanner.nextLine();
        String sexo = scanner.nextLine();
        var imc = new CalculadoraIMC(peso, altura, sexo);
        imc.calcular();
        imc.exibirResultado();
    }
}