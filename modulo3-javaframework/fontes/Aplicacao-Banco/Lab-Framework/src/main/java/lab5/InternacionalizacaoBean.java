package lab5;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class InternacionalizacaoBean implements Serializable {
	
	private static final long serialVersionUID = -471741447662426081L;
	
	private Locale currentLocale = new Locale("pt", "BR");
	
	public void englishLocale() {
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		currentLocale = Locale.US;
		viewRoot.setLocale(currentLocale);
	}
	
	public void portugueseLocale() {
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		currentLocale = new Locale("pt", "BR");
		viewRoot.setLocale(currentLocale);		
	}
	
	public Locale getCurrentLocale() {
		return currentLocale;
	}

}
