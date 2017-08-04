package br.com.threeway.locadora.managedbean;

import br.com.threeway.locadora.dao.FilmeDao;
import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.domain.TipoFilme;
import br.com.threeway.locadora.service.FilmeService;
import br.com.threeway.locadora.service.TipoFilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.view.ViewScoped;
import java.util.List;

@Controller
@ViewScoped
public class FilmesBean  {

	@Autowired
	private FilmeService filmeService;
	@Autowired
	private TipoFilmeService tipoFilmeService;

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
		return filmeService.search(busca);
	}

	public List<TipoFilme> getTipos() {
		return tipoFilmeService.list();
	}

	public void salvar() {
		filmeService.save(filme);
		filme = new Filme();
	}

	public void deletar(Filme filme) {
		filmeService.delete(filme);
	}


}
