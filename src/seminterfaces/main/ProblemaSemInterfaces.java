package seminterfaces.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import seminterfaces.model.entidades.AluguelDeCarro;
import seminterfaces.model.entidades.Veiculo;
import seminterfaces.model.servicos.ServicoDeAluguel;
import seminterfaces.model.servicos.ServicoDeImpostoBrasil;

public class ProblemaSemInterfaces {
	/*
	 * Uma locadora brasileira de carros cobra um valor por hora para locações de até
	 * 12 horas. Porém, se a duração da locação ultrapassar 12 horas, a locação será
	 * cobrada com base em um valor diário. Além do valor da locação, é acrescido no
	 * preço o valor do imposto conforme regras do país que, no caso do Brasil, é 20%
	 * para valores até 100.00, ou 15% para valores acima de 100.00. Fazer um
	 * programa que lê os dados da locação (modelo do carro, instante inicial e final da
	 * locação), bem como o valor por hora e o valor diário de locação. O programa
	 * deve então gerar a nota de pagamento (contendo valor da locação, valor do
	 * imposto e valor total do pagamento) e informar os dados na tela. Veja os
	 * exemplos.
	 */
	public static void main(String[] args) throws ParseException{
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Entre com os dados do Aluguel:");
		System.out.print("Modelo do Carro: ");;
		String modeloCarro = sc.nextLine();
		System.out.print("Data da Retirada  (dd/MM/yyyy HH:ss): ");
		Date dataRetirada = sdf.parse(sc.nextLine());
		System.out.print("Data da Devolução (dd/MM/yyyy HH:ss): ");
		Date dataDevolucao = sdf.parse(sc.nextLine());
		
		AluguelDeCarro ac = new AluguelDeCarro(dataRetirada,dataDevolucao,new Veiculo(modeloCarro));
		
		System.out.print("Digite o preco por hora: ");
		Double precoPorHora = sc.nextDouble();
		System.out.print("Digiteo preco por dia: ");
		Double precoPorDia = sc.nextDouble();
		
		ServicoDeAluguel servicoDeAluguel = new ServicoDeAluguel(precoPorDia, precoPorHora, new ServicoDeImpostoBrasil());
		
		servicoDeAluguel.processarNotaDePagamento(ac);
		
		System.out.println("NOTA DE PAGAMENTO:");
		System.out.println("Pagamento Básico: " + String.format("%.2f", ac.getNotaDePagamento().getPagamentoBasico()));
		System.out.println("Imposto:          " + String.format("%.2f", ac.getNotaDePagamento().getImposto()));
		System.out.println("Pagamento Total:  " + String.format("%.2f", ac.getNotaDePagamento().getPagamentoTotal()));		
		
		sc.close();
	}

}
