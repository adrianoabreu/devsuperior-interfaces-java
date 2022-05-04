package cominterfaces.model.entidades;

import java.util.Date;

public class AluguelDeCarro {
	
	private Date dataInicio;
	private Date dataFim;
	
	//Associações de classes e objetos:
	private Veiculo veiculo;
	private NotaDePagamento notaDePagamento;
	
	public AluguelDeCarro() {
		
	}

	public AluguelDeCarro(Date dataInicio, Date dataFim, Veiculo veiculo) {
		this.dataInicio = dataInicio;
		this.dataFim    = dataFim;
		this.veiculo    = veiculo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public NotaDePagamento getNotaDePagamento() {
		return notaDePagamento;
	}

	public void setNotaDePagamento(NotaDePagamento notaDePagamento) {
		this.notaDePagamento = notaDePagamento;
	}
	
	
	
}
