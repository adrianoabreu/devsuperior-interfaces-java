package seminterfaces.model.servicos;

import seminterfaces.model.entidades.AluguelDeCarro;
import seminterfaces.model.entidades.NotaDePagamento;

public class ServicoDeAluguel {
	
	private Double precoPorDia;
	private Double precoPorHora;
	
	//Associação de classes e objetos:
	private ServicoDeImpostoBrasil servicoDeImpostoBrasil;

	public ServicoDeAluguel() {
		
	}
	
	public ServicoDeAluguel(Double precoPorDia, Double precoPorHora, ServicoDeImpostoBrasil servicoDeImpostoBrasil) {
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.servicoDeImpostoBrasil = servicoDeImpostoBrasil;
	}
	
	public void processarNotaDePagamento(AluguelDeCarro aluguelDeCarro) {
		long t1 = aluguelDeCarro.getDataInicio().getTime();
		long t2 = aluguelDeCarro.getDataFim().getTime();
		double horas = (double)(t2 - t1) / 1000 / 60 / 60;
		
		double pagamentoBasico;
		if(horas <= 12.0) {
			pagamentoBasico = Math.ceil(horas) * precoPorHora;
		}else {
			pagamentoBasico = Math.ceil(horas / 24) * precoPorDia;
		}
		
		double imposto = servicoDeImpostoBrasil.calcularImposto(pagamentoBasico);
		
		aluguelDeCarro.setNotaDePagamento(new NotaDePagamento(pagamentoBasico, imposto));
	}
	
}
