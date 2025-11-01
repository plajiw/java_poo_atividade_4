public class CalculadoraSalarioLiquido extends Calculo implements IExibivel {
    private double salarioBruto;
    private double totalDescontos;
    private double totalBeneficios;
    private double salarioLiquido;

    public CalculadoraSalarioLiquido(double salarioBruto, double totalDescontos, double totalBeneficios) {
        setSalarioBruto(salarioBruto);
        setTotalDescontos(totalDescontos);
        setTotalBeneficios(totalBeneficios);
    }

    @Override
    public double calcular() {
        this.salarioLiquido = this.salarioBruto - this.totalDescontos + this.totalBeneficios;
        return this.salarioLiquido;
    }

    @Override
    public void exibirResultado() {
        System.out.printf("Salário Bruto: R$ %.2f\n", this.salarioBruto);
        System.out.printf("Total de Descontos: R$ %.2f\n", this.totalDescontos);
        System.out.printf("Total de BenefícioS: R$ %.2f\n", this.totalBeneficios);
        System.out.printf("Salário Líquido: R$ %.2f\n", this.salarioLiquido);
    }

    public void setSalarioBruto(double salarioBruto) {
        if (salarioBruto < 0) {
            System.out.println("Valor de salário bruto inválido. Usando 0.");
            this.salarioBruto = 0;
        } else {
            this.salarioBruto = salarioBruto;
        }
    }

    public void setTotalDescontos(double totalDescontos) {
        if (totalDescontos < 0) {
            System.out.println("Valor de desconto inválido. Deve ser maior que 0.");
            this.totalDescontos = 0;
        } else {
            this.totalDescontos = totalDescontos;
        }
    }

    public void setTotalBeneficios(double totalBeneficios) {
        if (totalBeneficios < 0) {
            System.out.println("Valor de benefício inválido. Deve ser maior que 0.");
            this.totalBeneficios = 0;
        } else {
            this.totalBeneficios = totalBeneficios;
        }
    }
}