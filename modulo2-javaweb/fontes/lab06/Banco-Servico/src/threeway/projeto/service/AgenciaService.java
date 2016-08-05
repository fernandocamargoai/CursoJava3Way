package threeway.projeto.service;

import threeway.projeto.modelo.Agencia;
import threeway.projeto.modelo.Banco;

public class AgenciaService {

	public static final Agencia agenciaSistema() {

		Banco bancoSistema = BancoService.bancoSistema();

		Agencia agenciaSistema = new Agencia("3way NetWorks!");

		agenciaSistema.setBanco(bancoSistema);

		bancoSistema.getAgencias().add(agenciaSistema);

		return agenciaSistema;
	}
}
