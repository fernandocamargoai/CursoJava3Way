package lab4;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;


@ManagedBean(name="navegacaoBean")
@ViewScoped
public class NavegacaoBean implements Serializable {
	
	private static final long serialVersionUID = -7622250974049755899L;
	
	public String navegacaoDinamicaImplicitaIndex() {
		return "index";
	}
	
	public String navegacaoDinamicaImplicitaPagina1() {
		return "pagina1";
	}
	
	public String navegacaoDinamicaExplicitaIndex() {
		return "NavegacaoExplicitaIndex";
	}
	
	public String navegacaoDinamicaExplicitaPagina1() {
		return "navegacaoExplicitaPagina1";
	}

}
