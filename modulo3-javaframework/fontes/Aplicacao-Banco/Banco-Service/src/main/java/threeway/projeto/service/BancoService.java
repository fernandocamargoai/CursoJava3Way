package threeway.projeto.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import threeway.projeto.modelo.Banco;
import threeway.projeto.service.DaoJPA.BancoDaoImpl;

public class BancoService implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 8507462341844071183L;

	@Inject
	private BancoDaoImpl dao;

	private static Banco bancoSistema;

	public static final Banco bancoSistema() {

		return bancoSistema;
	}

	@PostConstruct
	public void inicializaBanco() {

		List<Banco> lista = new ArrayList<Banco>(dao.listar());

		if (lista != null && lista.size() > 0) {

			bancoSistema = lista.get(0);

		} else {

			Banco bancoSistema = new Banco(1);

			bancoSistema.setNome("Banco Java Brasil");

			dao.salvar(bancoSistema);

			inicializaBanco();

		}

	}
}
