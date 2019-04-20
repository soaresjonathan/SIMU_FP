import java.util.concurrent.ThreadLocalRandom;

public class SomaPotencia {
	

	private Integer somaPotencias = 0;

	public Integer getSomaPotencias() {
		return this.somaPotencias;
	}

	public Integer setSomaPotencias(Integer somaPotencias) {
		return this.somaPotencias = somaPotencias;
	}
	
	public Integer randonSomaPotencia() {
		somaPotencias = somaPotencias + ThreadLocalRandom.current().nextInt(-5, 1);
		return somaPotencias;
	}

	
}
