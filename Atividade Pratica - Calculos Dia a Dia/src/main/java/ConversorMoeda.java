public class ConversorMoeda extends Calculo implements IExibivel {
    private double valorOriginal;
    private double taxaCambio;
    private double valorConvertido;

    public ConversorMoeda(double valorOriginal, double taxaCambio) {
        setValorOriginal(valorOriginal);
        setTaxaCambio(taxaCambio);
    }

    @Override
    public double calcular() {
        this.valorConvertido = this.valorOriginal * this.taxaCambio;
        return this.valorConvertido;
    }

    @Override
    public void exibirResultado() {
        System.out.printf("Valor Original: %.2f\n", this.valorOriginal);
        System.out.printf("Taxa de Câmbio: %.4f\n", this.taxaCambio);
        System.out.printf("Valor Convertido: %.2f\n", this.valorConvertido);
    }

    public void setValorOriginal(double valorOriginal) {
        if (valorOriginal < 0) {
            System.out.println("\"Valor inválido. Deve ser maior que 0.\"");
            this.valorOriginal = 0;
        } else {
            this.valorOriginal = valorOriginal;
        }
    }

    public void setTaxaCambio(double taxaCambio) {
        if (taxaCambio <= 0) {
            System.out.println("Valor de taca inválido. Deve ser maior ou igual a 0.");
            this.taxaCambio = 1.0;
        } else {
            this.taxaCambio = taxaCambio;
        }
    }
}