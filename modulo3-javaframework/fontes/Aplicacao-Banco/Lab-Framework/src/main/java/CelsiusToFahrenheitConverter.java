import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("celsiusToFahrenheitConverter")
public class CelsiusToFahrenheitConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Float resultado = 0F;
		try {
			Float celsius = Float.parseFloat(value);
			resultado = (celsius * 9/5) + 32;
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Erro de conversão em celsiusToFahrenheitConverter", "Entrada inválida, tente novamente.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			
			throw new ConverterException(msg);			
		}
		return resultado;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return value.toString();
	}
	

}
