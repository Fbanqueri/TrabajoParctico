package Grupo2;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class Partido{

	private int golesEquipo1;
	private int golesEquipo2;
	private Equipo equipo1;
	private Equipo equipo2;

public ResultadoEnum resultado (Equipo equipo) {
	
		ResultadoEnum resultadoEquipo1;
		ResultadoEnum resultadoEquipo2;
		if(golesEquipo1 > golesEquipo2) {
			resultadoEquipo1=ResultadoEnum.GANADOR;
			resultadoEquipo2=ResultadoEnum.PERDEDOR;
			
		}	else if(golesEquipo1 < golesEquipo2) {
			resultadoEquipo2=ResultadoEnum.GANADOR;
			resultadoEquipo1=ResultadoEnum.PERDEDOR;
		}   else {
			return ResultadoEnum.EMPATE;
			
}
			if(equipo.getNombre().equals(equipo1.getNombre())) {
					return resultadoEquipo1;
			}	else{
					return resultadoEquipo2;
			}

}	

}
