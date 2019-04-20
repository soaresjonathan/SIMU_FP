public class Carga {
	
	public Carga() { //CONSTRUTOR
		
	}
	private String nome;
	private Integer potencia;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPotencia() {
		return potencia;
	}
	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}
	/*		
	@Override
	public String toString() {
		return "Nome: " + nome + "" + "\n" + "Potência: " + potencia + " W" + "\n";
	}*/
}