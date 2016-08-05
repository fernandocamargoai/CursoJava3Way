package threeway.projeto.service.excecoes;

public class CamposObrigatoriosException extends Exception {

	private static final long serialVersionUID = -5487345156293002556L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public CamposObrigatoriosException() {

		super("Por Favor preencha todos campos obrigátorios!");
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 */
	public CamposObrigatoriosException( String mensagem ) {

		super(mensagem);
	}

}
