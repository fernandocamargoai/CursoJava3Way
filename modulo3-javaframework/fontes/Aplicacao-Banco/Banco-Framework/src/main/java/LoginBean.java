import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import threeway.projeto.modelo.Agencia;
import threeway.projeto.service.AgenciaService;

@Named
@RequestScoped
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private AgenciaService agenciaService;
	
	private Agencia agenciaSistema;
	
	private String login;
	private String senha;
	
	@SuppressWarnings("static-access")
	@PostConstruct
	public void inicializaAgencia() {
		this.agenciaSistema = agenciaService.agenciaSistema();
	}
	
	public String realizarLogin() {
		//System.out.println("return manterCliente");

		if (this.getLogin().equals("admin") && this.getSenha().equals("admin")) {
			HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(false);			
			
			session.setAttribute("usuario", this.getLogin());
			return "manterCliente";
		}
		
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Login ou Senha Incorretos!"));
		
		return "login";
	}
	
	public String realizarLogout() {
		
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		
		session.setAttribute("usuario", null);
		
		return "login";
	}
	
	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		
		return FacesContext.getCurrentInstance();
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Agencia getAgenciaSistema() {

		return agenciaSistema;
	}
	
	

}
