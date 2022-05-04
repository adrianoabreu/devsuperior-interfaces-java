package cominterfaces.model.servicos;

import cominterfaces.model.entidades.AluguelDeCarro;
import cominterfaces.model.entidades.NotaDePagamento;

public class ServicoDeAluguel {
	
	private Double precoPorDia;
	private Double precoPorHora;
	
	//Associação de classes e objetos:
	//private ServicoDeImpostoBrasil servicoDeImpostoBrasil;
	private ServicoDeImposto servicoDeImposto;

	public ServicoDeAluguel() {
		
	}
	
	public ServicoDeAluguel(Double precoPorDia, Double precoPorHora, ServicoDeImposto servicoDeImposto) {
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.servicoDeImposto = servicoDeImposto;
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
		
		double imposto = servicoDeImposto.calcularImposto(pagamentoBasico);
		
		aluguelDeCarro.setNotaDePagamento(new NotaDePagamento(pagamentoBasico, imposto));
	}
	
}
