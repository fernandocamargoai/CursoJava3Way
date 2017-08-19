package br.com.threeway.locadora.bean;

import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.domain.TipoFilme;
import br.com.threeway.locadora.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class FilmesBean implements Serializable {

	@Autowired
	private FilmeService filmeService;

	private Filme filme = new Filme();

	public TipoFilme[] getTiposFilme() {
		return TipoFilme.values();
	}

	public void cadastrar() {
		filmeService.save(filme);

		filme = new Filme();

	}

	public void deletar(Filme filme) {
		filmeService.delete(filme.getId());
	}

	public List<Filme> getFilmes() {
		return filmeService.findAll();
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}
