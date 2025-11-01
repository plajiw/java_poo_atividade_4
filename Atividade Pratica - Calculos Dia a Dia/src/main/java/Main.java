import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import Enums.Sexo;
import Enums.TipoJuros;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Calculo> calculos = new ArrayList<>();

        System.out.println("1. Calculadora de IMC");
        System.out.print("Informe o peso: ");
        double peso = scanner.nextDouble();
        System.out.print("Informe a altura: ");
        double altura = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Informe o sexo (masculino/feminino): ");
        String sexo = scanner.nextLine();
        calculos.add(new CalculadoraIMC(peso, altura, sexo));

        System.out.println("\n2. Calculadora de Salário Líquido");
        System.out.print("Informe o salário bruto: ");
        double salarioBruto = scanner.nextDouble();
        System.out.print("Informe o total de descontos: ");
        double totalDescontos = scanner.nextDouble();
        System.out.print("Informe o total de benefícios: ");
        double totalBeneficios = scanner.nextDouble();
        calculos.add(new CalculadoraSalarioLiquido(salarioBruto, totalDescontos, totalBeneficios));

        System.out.println("\n3. Conversor de Moeda");
        System.out.print("Informe o valor original: ");
        double valorOriginal = scanner.nextDouble();
        System.out.print("Informe a taxa de câmbio/cotação: ");
        double taxaCambio = scanner.nextDouble();
        calculos.add(new ConversorMoeda(valorOriginal, taxaCambio));

        System.out.println("\n4. Calculadora de Juros");
        System.out.print("Informe o capital inicial: ");
        double capitalInicial = scanner.nextDouble();
        System.out.print("Informe a taxa de juros: ");
        double taxaJuros = scanner.nextDouble();
        System.out.print("Informe o tempo: ");
        int tempo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Informe o tipo de juros (simples/composto): ");
        String tipoJuros = scanner.nextLine();
        calculos.add(new CalculadoraJuros(capitalInicial, (taxaJuros / 100.0), tempo, tipoJuros));

        System.out.println("\n5. Calculadora de Consumo de Energia");
        System.out.print("Informe o consumo em kWh: ");
        double consumoKWh = scanner.nextDouble();
        System.out.print("Informe o custo por kWh em R$: ");
        double custoPorKWh = scanner.nextDouble();
        calculos.add(new CalculadoraConsumoEnergia(consumoKWh, custoPorKWh));

        for (Calculo calc : calculos) {

            calc.calcular();

            if (calc instanceof IExibivel) {
                IExibivel exibivel = (IExibivel) calc;
                exibivel.exibirResultado();
            }
        }
    }
}