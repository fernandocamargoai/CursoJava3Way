package threeway.projeto.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import threeway.projeto.modelo.Agencia;
import threeway.projeto.modelo.Banco;
import threeway.projeto.service.DaoJPA.AgenciaDaoImpl;

public class AgenciaService implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 2646320509948935999L;

	@Inject
	private AgenciaDaoImpl dao;

	private static Agencia agenciaSistema;

	public static final Agencia agenciaSistema() {

		return agenciaSistema;
	}

	@PostConstruct
	public void inicializaAgencia() {

		List<Agencia> lista = new ArrayList<Agencia>(dao.listar());

		if (lista != null && lista.size() > 0) {

			agenciaSistema = lista.get(0);

		} else {

			Banco bancoSistema = BancoService.bancoSistema();

			Agencia agenciaSistema = new Agencia("3way NetWorks!");

			agenciaSistema.setBanco(bancoSistema);			

			dao.salvar(agenciaSistema);

			inicializaAgencia();

		}

	}
}
