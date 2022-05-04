package cominterfaces.model.servicos;

// Esta classe se tornou um subtipo da Interface ServicoDeImposto.
public class ServicoDeImpostoBrasil implements ServicoDeImposto{

	public double calcularImposto(double valor) {
		if(valor <= 100.0) {
			return valor * 0.2;
		}else {
			return valor * 0.15;
		}
	}
}
