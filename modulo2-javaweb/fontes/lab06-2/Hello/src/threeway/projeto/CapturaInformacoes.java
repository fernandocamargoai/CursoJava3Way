package threeway.projeto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CapturaInformacoes
 */
@WebServlet("/CapturaInformacoes")
public class CapturaInformacoes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapturaInformacoes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Informação de requerimento</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Informação de requerimento</h3>");
		out.println("Method: " + request.getMethod() + "<br>");
		out.println("Request URI: " + request.getRequestURI() + "<br>");
		out.println("Protocol: " + request.getProtocol() + "<br>");
		out.println("PathInfo: " + request.getPathInfo() + "<br>");
		out.println("Remote Address: " + request.getRemoteAddr() + "<br>");
		out.println("<h3> AuthType </h3>");
		out.println("AuthType = " + request.getAuthType() + "<br>");
		out.println("<h3> HTTP Method </h3>");
		out.println("HTTP Method = " + request.getMethod() + "<br>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
