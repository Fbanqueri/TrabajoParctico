package ar.edu.pronostico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Collection<Partido> partidos = new ArrayList<Partido>();
		Path pathResultado = Paths.get(args[0]);
		List<String> lineasResultados = null;
		try {
			lineasResultados = Files.readAllLines(pathResultado);
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean fil1 = true;
		for (String lineasResultado : lineasResultados) {
			if (fil1) {
				fil1 = false;
			} else {
				String[] campos = lineasResultado.split(",");
				Equipo equipo1 = new Equipo(campos[0]);
				Equipo equipo2 = new Equipo(campos[3]);
				Partido partido = new Partido(equipo1, equipo2);
				partido.setGolEquipo1(Integer.parseInt(campos[1]));
				partido.setGolEquipo2(Integer.parseInt(campos[2]));
				partidos.add(partido);

			}

		}
		int puntos = 0;
		Path pathPronostico = Paths.get(args[1]);
		List<String> lineasPronostico = null;
		try {
			lineasPronostico = Files.readAllLines(pathPronostico);
		} catch (IOException e) {
			e.printStackTrace();
		}
		fil1 = true;
		for (String lineasPronosticos : lineasPronostico) {
			if (fil1) {
				fil1 = false;
			} else {
				String[] campos = lineasPronosticos.split(",");
				Equipo equipo1 = new Equipo(campos[0]);
				Equipo equipo2 = new Equipo(campos[4]);
				Partido partido = null;
				for (Partido partidoCol : partidos) {
					if (partidoCol.getEquipo1().getNombre().equals(equipo1.getNombre())
							&& partidoCol.getEquipo2().getNombre().equals(equipo2.getNombre())) {
						partido = partidoCol;

					}

				}
				Equipo equipo = null;
				ResultadoEnum resultado = null;
				if ("X".equals(campos[1])) {
					equipo = equipo1;
					resultado = ResultadoEnum.GANADOR;

				}
				if ("X".equals(campos[2])) {
					equipo = equipo1;
					resultado = ResultadoEnum.EMPATE;
				}
				if ("X".equals(campos[3])) {
					equipo = equipo1;
					resultado = ResultadoEnum.PERDEDOR;
				}
				
				Pronostico pronostico = new Pronostico(partido, equipo, resultado);
				puntos += pronostico.puntos();
				

			}

		}
		System.out.println(puntos);

	}

}
