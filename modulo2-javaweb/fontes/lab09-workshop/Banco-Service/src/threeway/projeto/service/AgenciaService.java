package threeway.projeto.service;

import threeway.projeto.modelo.Agencia;
import threeway.projeto.modelo.Banco;
import threeway.projeto.service.Dao.AgenciaDao;

public class AgenciaService {

	static AgenciaDao dao = new AgenciaDao();

	public static final Agencia agenciaSistema() {

		Agencia ag = dao.obter(new Long(1));
		
		if(ag == null){
			
			inicializaAgencia();
			
			ag = dao.obter(new Long(1));
		}
		
		return ag;
	}

	public static void inicializaAgencia() {

		Banco bancoSistema = BancoService.bancoSistema();

		Agencia agenciaSistema = new Agencia("3way NetWorks!");

		agenciaSistema.setBanco(bancoSistema);

		dao.salvar(agenciaSistema);
		
		System.out.println(dao.listar());

	}
}
