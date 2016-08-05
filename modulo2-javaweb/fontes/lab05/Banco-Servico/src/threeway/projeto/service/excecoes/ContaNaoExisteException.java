package threeway.projeto.service.excecoes;

public class ContaNaoExisteException extends Exception{

	private static final long serialVersionUID = -2692264935862218672L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public ContaNaoExisteException() {

		super("Conta não existe.");
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 */
	public ContaNaoExisteException(String mensagem) {

		super(mensagem);
	}
}
