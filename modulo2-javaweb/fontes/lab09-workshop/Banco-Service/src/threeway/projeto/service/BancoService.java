package threeway.projeto.service;

import threeway.projeto.modelo.Banco;
import threeway.projeto.service.Dao.BancoDao;

public class BancoService {

	static BancoDao dao = new BancoDao();
	
	public static final Banco bancoSistema() {

		Banco banco = dao.obter(new Long(1));
		
		if(banco == null){
			
			inicializaBanco();
			
			banco = dao.obter(new Long(1));
		}
		
		return banco;

	}
	
	public static void inicializaBanco() {
		
		Banco bancoSistema = new Banco(1);

		bancoSistema.setNome("Banco Java Brasil");
		
		dao.salvar(bancoSistema);
		
		System.out.println(dao.listar());
	}
}
