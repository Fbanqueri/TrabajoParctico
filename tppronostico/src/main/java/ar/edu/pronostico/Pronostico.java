package ar.edu.pronostico;

public class Pronostico {
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;

	public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
		super();
		this.partido = partido;
		this.equipo = equipo;
		this.resultado = resultado;
	}

	public Partido getPartido() {
		return this.partido;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public ResultadoEnum getResultado() {
		return this.resultado;
	}

	public int puntos() {
		
		ResultadoEnum res = this.partido.resultado(this.equipo);
		if (this.resultado.equals(res)) {
			return 1;
		} else {
			return 0;
		}
		
		

	}
}
