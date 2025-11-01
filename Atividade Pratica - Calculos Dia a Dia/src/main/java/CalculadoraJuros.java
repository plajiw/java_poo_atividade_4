import Enums.TipoJuros;

public class CalculadoraJuros extends Calculo implements IExibivel {
    private double capitalInicial;
    private double taxaJuros;
    private int tempo;
    private TipoJuros tipoJuros;
    private double montanteFinal;

    public CalculadoraJuros(double capitalInicial, double taxaJuros, int tempo, String tipoJuros) {
        setCapitalInicial(capitalInicial);
        setTaxaJuros(taxaJuros);
        setTempo(tempo);
        setTipoJuros(tipoJuros);
    }

    @Override
    public double calcular() {
        if (this.tipoJuros == TipoJuros.SIMPLES) {
            this.montanteFinal = this.capitalInicial * (1 + this.taxaJuros * this.tempo);
        } else if (this.tipoJuros == TipoJuros.COMPOSTO) {
            this.montanteFinal = this.capitalInicial * Math.pow((1 + this.taxaJuros), this.tempo);
        }
        return this.montanteFinal;
    }

    @Override
    public void exibirResultado() {
        System.out.printf("Capital Inicial: R$ %.2f\n", this.capitalInicial);
        System.out.printf("Taxa de Juros: %.2f%% por período\n", this.taxaJuros * 100);
        System.out.printf("Tempo: %d períodos\n", this.tempo);
        System.out.println("Tipo de Juros: " + this.tipoJuros);
        System.out.printf("Montante Final: R$ %.2f\n", this.montanteFinal);
    }

    private String normalizarString(String texto) {
        return texto.toLowerCase().trim();
    }

    public void setCapitalInicial(double capitalInicial) {
        if (capitalInicial < 0) {
            System.out.println("Capital inicial não pode ser negativo. Usando 0.");
            this.capitalInicial = 0;
        } else {
            this.capitalInicial = capitalInicial;
        }
    }

    public void setTaxaJuros(double taxaJuros) {
        if (taxaJuros < 0) {
            System.out.println("Taxa de juros não pode ser negativa. Usando 0.");
            this.taxaJuros = 0;
        } else {
            this.taxaJuros = taxaJuros;
        }
    }

    public void setTempo(int tempo) {
        if (tempo <= 0) {
            System.out.println("Tempo deve ser positivo. Usando 1 período.");
            this.tempo = 1;
        } else {
            this.tempo = tempo;
        }
    }
    // Setter para o Enum (baseado no seu setSexo)
    public void setTipoJuros(String tipo) {
        tipo = normalizarString(tipo);
        if (tipo.equals("simples")) {
            this.tipoJuros = TipoJuros.SIMPLES;
        } else if (tipo.equals("composto")) {
            this.tipoJuros = TipoJuros.COMPOSTO;
        } else {
            System.out.println("Tipo de juros inválido ('" + tipo + "'). Usando SIMPLES como padrão.");
            this.tipoJuros = TipoJuros.SIMPLES;
        }
    }
}