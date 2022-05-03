package seminterfaces.model.servicos;

public class ServicoDeImpostoBrasil {

	public Double calcularImposto(Double valor) {
		if(valor <= 100.0) {
			return valor * 0.2;
		}else {
			return valor * 0.15;
		}
	}
}
