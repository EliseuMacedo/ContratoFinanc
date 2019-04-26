package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.Contrato;
import modelo.entidades.Prestacao;
import modelo.servicos.ContratoServico;
import modelo.servicos.ServicoPtoPaypal;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);
		System.out.println("Dados do contrado");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor do contrato: ");
		double valorTotal = sc.nextDouble();

		Contrato contrato = new Contrato(numero, data, valorTotal);

		System.out.print("Numero de parcelas: ");
		int meses = sc.nextInt();

		System.out.println("\nRESUMO DO CONTRATO:");

		ContratoServico cs = new ContratoServico(new ServicoPtoPaypal());
		cs.processoContrato(contrato, meses);

		for (Prestacao x : contrato.getPrestacoes() ) {
			
			System.out.println(x);

		}
		sc.close();

	}

}
