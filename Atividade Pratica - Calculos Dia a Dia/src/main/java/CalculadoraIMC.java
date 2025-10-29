import Enums.Sexo;

public class CalculadoraIMC extends Calculo implements IExibivel {
    private double peso;
    private double altura;
    private Sexo sexo;
    private double resultadoIMC;
    private String categoria;

    public CalculadoraIMC(double peso, double altura, String sexo) {
        setPeso(peso);
        setAltura(altura);
        setSexo(sexo);
    }

    @Override
    public double calcular() {
        resultadoIMC = peso / (altura * altura);
        obterClassificacao();
        return resultadoIMC;
    }

    @Override
    public void exibirResultado() {
        System.out.printf("Peso: %.2f\n", this.peso);
        System.out.printf("Altura: %.2f\n", this.altura);
        System.out.println("Sexo: " + this.sexo);
        System.out.printf("IMC: %.2f\n", this.resultadoIMC);
        System.out.println("Classificação: " + this.categoria);
    }

    private void obterClassificacao() {
        if (this.resultadoIMC < 18.5) {
            this.categoria = "Abaixo do peso";
        }
        else if (this.resultadoIMC < 24.9) {
            this.categoria = "Peso normal";
        }
        else if (this.resultadoIMC < 29.9) {
            this.categoria = "Sobrepeso";
        }
        else if (this.resultadoIMC < 34.9) {
            this.categoria = "Obesidade (Grau I)";
        }
        else if (this.resultadoIMC < 39.9) {
            this.categoria = "Obesidade (Grau II)";
        }
        else {
            this.categoria = "Obesidade (Grau III)";
        }
    }

    private String normalizarString(String texto) {
        return texto.toLowerCase().trim();
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            System.out.println("Valor de peso inválido. Deve ser maior que 0.");
            return;
        }
        this.peso = peso;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            System.out.println("Valor de altura inválido. Deve ser maior que 0.");
            return;
        }
        this.altura = altura;
    }

    public void setSexo(String sexo) {
        sexo = normalizarString(sexo);

        if (sexo.equals("feminino")) {
            this.sexo = Sexo.FEMININO;
        }
        else if (sexo.equals("masculino")) {
            this.sexo = Sexo.MASCULINO;
        }
        else {
            System.out.println("Valor inválido. Deve ser \"feminino\" ou \"masculino\"");
        }
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }
}