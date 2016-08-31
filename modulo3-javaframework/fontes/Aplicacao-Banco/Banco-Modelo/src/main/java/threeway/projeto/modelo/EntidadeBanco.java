package threeway.projeto.modelo;

import java.io.Serializable;


public abstract class EntidadeBanco implements Entidade, Serializable{

	private static final long serialVersionUID = -4307119879184010166L;

	public abstract Long getIdentificador();

}
