package threeway.projeto.modelo;

import java.io.Serializable;
import java.util.Date;

import threeway.projeto.modelo.util.UtilData;

public class Log implements Entidade, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String descricao;
	
	private Date data;

	//Crie os getters e setters
	
	public String getDataFormatada(){
		
		return UtilData.formatarDataHora(data);
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public Long getIdentificador() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

		
	
}
