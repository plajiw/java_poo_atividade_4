public class CalculadoraConsumoEnergia extends Calculo implements IExibivel {
    private double consumoKWh;
    private double custoPorKWh;
    private double custoTotal;

    public CalculadoraConsumoEnergia(double consumoKWh, double custoPorKWh) {
        setConsumoKWh(consumoKWh);
        setCustoPorKWh(custoPorKWh);
    }

    @Override
    public double calcular() {
        this.custoTotal = this.consumoKWh * this.custoPorKWh;
        return this.custoTotal;
    }

    @Override
    public void exibirResultado() {
        System.out.printf("Consumo: %.2f kWh\n", this.consumoKWh);
        System.out.printf("Custo por kWh: R$ %.4f\n", this.custoPorKWh);
        System.out.printf("Custo Total da Fatura: R$ %.2f\n", this.custoTotal);
    }

    public void setConsumoKWh(double consumoKWh) {
        if (consumoKWh < 0) {
            System.out.println("Consumo não pode ser negativo. Usando 0.");
            this.consumoKWh = 0;
        } else {
            this.consumoKWh = consumoKWh;
        }
    }

    public void setCustoPorKWh(double custoPorKWh) {
        if (custoPorKWh < 0) {
            System.out.println("Custo por kWh não pode ser negativo. Usando 0.");
            this.custoPorKWh = 0;
        } else {
            this.custoPorKWh = custoPorKWh;
        }
    }
}