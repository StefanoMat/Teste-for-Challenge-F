package challenge;

import challenge.essencial.Jogador;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	private final List<Jogador> jogadoresList;

	public Main() {
		jogadoresList = new ArrayList<>();
		try {
			Jogador.carregarJogador(jogadoresList);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		return jogadoresList.stream().collect(Collectors.groupingBy(Jogador::getNationality)).size();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		return jogadoresList.stream().collect(Collectors.groupingBy(Jogador::getClub)).size();
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		return jogadoresList.stream().map(Jogador::getFullName).limit(20).collect(Collectors.toList());
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		return jogadoresList.stream().sorted(Comparator.comparingDouble(Jogador::getBuyRealese).reversed()).limit(10).map(Jogador::getFullName).collect(Collectors.toList());
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		return jogadoresList.stream().sorted(Comparator.comparingInt(Jogador::getAge)).sorted(Comparator.comparing(Jogador::getBirthDate)).limit(10).map(Jogador::getFullName).collect(Collectors.toList());

	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {

		Map<Integer, Integer> lista = new HashMap<>();

		jogadoresList.parallelStream().map(Jogador::getAge).distinct().forEach(key -> lista.put(key, jogadoresList.parallelStream()
				.map(Jogador::getAge).filter(age -> age.equals(key))
				.mapToInt(age -> 1).sum()));

		return lista;
	}



}
