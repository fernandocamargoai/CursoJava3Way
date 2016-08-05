package simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MinhaPropriaSimpleTag extends SimpleTagSupport{
	
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().write("Essa é minha nova TAG");
	}

}
