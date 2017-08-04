package br.com.threeway.locadora.managedbean;

import br.com.threeway.locadora.domain.TipoFilme;
import br.com.threeway.locadora.service.TipoFilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.view.ViewScoped;
import java.util.List;

@Controller
@ViewScoped
public class TiposBean {

	@Autowired
	private TipoFilmeService tipoFilmeService;

	private TipoFilme tipoFilme = new TipoFilme();

	public TipoFilme getTipoFilme() {
		return tipoFilme;
	}

	public void setTipoFilme(TipoFilme tipoFilme) {
		this.tipoFilme = tipoFilme;
	}

	public void save(){
		tipoFilmeService.save(tipoFilme);
		tipoFilme = new TipoFilme();
	}

	public void delete(TipoFilme tipoFilme){
		tipoFilmeService.delete(tipoFilme);
	}

	public List<TipoFilme> getTipos(){
		return tipoFilmeService.list();
	}

}
