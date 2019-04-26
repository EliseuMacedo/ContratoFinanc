package modelo.servicos;

public interface ServicoPtoOnline {
	
	public double txPagamento(double quantia);
	public double txJuros(double quantia, int meses);

}
