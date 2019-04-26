package modelo.servicos;

public class ServicoPtoPaypal implements ServicoPtoOnline {

	public double txPagamento(double quantia) {
		return quantia + quantia * 0.02;
	}

	public double txJuros(double quantia, int meses) {

		quantia += quantia * 0.01 * meses;
		return txPagamento(quantia);
		
	}
}
