package threeway.projeto.modelo;

import java.util.Date;

import threeway.projeto.modelo.util.UtilData;

public class Log implements Entidade {

	
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

		
	
}
