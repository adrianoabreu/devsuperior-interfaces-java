package cominterfaces.model.entidades;

public class NotaDePagamento {
	
	private Double pagamentoBasico;
	private Double imposto;
	
	public NotaDePagamento() {
		
	}

	public NotaDePagamento(Double pagamentoBasico, Double imposto) {
		this.pagamentoBasico = pagamentoBasico;
		this.imposto = imposto;
	}

	public Double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(Double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public Double getImposto() {
		return imposto;
	}

	public void setImposto(Double imposto) {
		this.imposto = imposto;
	}
	
	public Double getPagamentoTotal() {
		return getPagamentoBasico() + getImposto();
	}
}
