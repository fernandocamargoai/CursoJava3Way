import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean(name="conversoresBean")
@ViewScoped
public class ConversoresBean implements Serializable{
	
	private static final long serialVersionUID = -900381764696451448L;
	
	private Date dataNascimento;
	private Integer peso;
	private String celsiusToFahrenheit;
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Integer getPeso() {
		return peso;
	}
	
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
	public String getCelsiusToFahrenheit() {
		return celsiusToFahrenheit;
	}
	
	public void setCelsiusToFahrenheit(String celsiusToFahrenheit) {
		this.celsiusToFahrenheit = celsiusToFahrenheit;
	}

}
