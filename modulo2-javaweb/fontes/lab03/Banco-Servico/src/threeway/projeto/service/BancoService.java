package threeway.projeto.service;

import threeway.projeto.modelo.Banco;

public class BancoService {

	public static final Banco bancoSistema() {

		Banco bancoSistema = new Banco(1);

		bancoSistema.setNome("Banco Java Brasil");

		return bancoSistema;
	}
}
