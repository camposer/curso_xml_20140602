package parsers.model;

public class Coche {
	private String matricula;
	private String marca;
	
	
	public Coche(String matricula, String marca) {
		super();
		this.matricula = matricula;
		this.marca = marca;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + "]";
	}
	
	
}
