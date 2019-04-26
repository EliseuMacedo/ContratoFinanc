package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestacao {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dtVencimento;
	private Double quantia;
	
	//construc padrão
	public Prestacao() {
	}

	public Prestacao(Date dtVencimento, Double quantia) {
		super();
		this.dtVencimento = dtVencimento;
		this.quantia = quantia;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public Double getQuantia() {
		return quantia;
	}

	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}
	
	@Override
	public String toString() {
		return sdf.format(dtVencimento) + " - " + String.format("%.2f", quantia);
 	}
	
	
}
