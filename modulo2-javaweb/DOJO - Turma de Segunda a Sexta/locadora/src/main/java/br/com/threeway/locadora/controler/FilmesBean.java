package br.com.threeway.locadora.controler;

import br.com.threeway.locadora.dao.FilmeDao;
import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.domain.TipoFilme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.view.ViewScoped;
import java.util.List;

@Controller
@ViewScoped
public class FilmesBean  {

	@Autowired
	private FilmeDao filmeDao;
	private Filme filme = new Filme();
	private String busca = "";

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public List<Filme> getFilmes(){
		return filmeDao.findByNomeStartingWithIgnoreCase(busca);
	}

	public TipoFilme[] getTipos() {
		return TipoFilme.values();
	}

	public void salvar() {
		filmeDao.save(filme);
		filme = new Filme();
	}

	public void deletar(Filme filme) {
		filmeDao.delete(filme);
		filme = new Filme();
	}


}
