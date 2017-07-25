package br.com.threeway.locadora.bean;

import br.com.threeway.locadora.dao.FilmeDAO;
import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.domain.TipoFilme;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "filmesBeans")
@ViewScoped
public class FilmesBean implements Serializable {

	private Filme filme = new Filme();
	private FilmeDAO filmeDAO = new FilmeDAO();

	public TipoFilme[] getTiposFilme() {
		return TipoFilme.values();
	}

	public void cadastrar() {
		if (filme.getId() != null) {
			filmeDAO.update(filme);
		} else {
			filmeDAO.cadastro(filme);
		}
		filme = new Filme();

	}

	public void deletar(Filme filme){

		filmeDAO.delete(filme.getId());

	}

	public List<Filme> getFilmes() {
		return filmeDAO.findAll();
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}
