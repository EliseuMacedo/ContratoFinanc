package modelo.servicos;


import java.util.Calendar;
import java.util.Date;

import modelo.entidades.Contrato;
import modelo.entidades.Prestacao;

public class ContratoServico {
	
	private ServicoPtoOnline servicoPtoOnline;
	
	public ContratoServico(ServicoPtoOnline servicoPtoOnline) {
		this.servicoPtoOnline = servicoPtoOnline;
	}

	public void processoContrato(Contrato contrato, int meses) {
		
		ServicoPtoPaypal spp = new ServicoPtoPaypal();
		
		//casting para não retornar valor inteiro
		double valorMes = (double)contrato.getValorTotal()/meses;
		
		//trazer a data para uma variavel Date
		Date vencimento = contrato.getData();
		//Criar o tipo calendar
		Calendar cal= Calendar.getInstance();
		//inserir a data no calendar
		cal.setTime(vencimento);
		
		for (int i = 1; i <= meses; i++) {
			double parcelas = spp.txJuros(valorMes, i);
			cal.add(Calendar.MONTH, 1);
			vencimento = (Date) cal.getTime();
			Prestacao p = new Prestacao(vencimento, parcelas);
			contrato.addPrestacao(p);
		}
		
	}

}
