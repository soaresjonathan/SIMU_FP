import java.util.concurrent.ThreadLocalRandom;

public class SimuGrandEletrica {	

	private Double fatorVariacaoMax = 1.0;
	private Double fatorVariacaoMin = -5.0;

	private Double tensaoTrifasica = 380.00;

	private Double tensaoMonofasica = tensaoTrifasica / Math.sqrt(3);

	private Double fatorDePotenciaIdealMinima = 0.92;
	private Double fatorDePotenciaIdealMaxima = 0.99999;

	private Double fatorDePotenciaRuimMinima = 0.5;
	private Double fatorDePotenciaRuimMaxima = 0.91999;

	// ***************************************************************************************************

	public Double randonTensaoMonofasica() {
		tensaoMonofasica = tensaoMonofasica
				+ ThreadLocalRandom.current().nextDouble(fatorVariacaoMin, fatorVariacaoMax);
		return tensaoMonofasica;
	}

	public Double randonTensaoTrifasica() {
		tensaoTrifasica = tensaoTrifasica + ThreadLocalRandom.current().nextDouble(fatorVariacaoMin, fatorVariacaoMax);
		return tensaoTrifasica;
	}

	public Double randonFatorDePotenciaBaixo() {
		return ThreadLocalRandom.current().nextDouble(fatorDePotenciaRuimMinima,fatorDePotenciaRuimMaxima);
	}

	public Double randonFatorDePotenciaAlto() {
		return ThreadLocalRandom.current().nextDouble(fatorDePotenciaIdealMinima,fatorDePotenciaIdealMaxima);

	}

}
