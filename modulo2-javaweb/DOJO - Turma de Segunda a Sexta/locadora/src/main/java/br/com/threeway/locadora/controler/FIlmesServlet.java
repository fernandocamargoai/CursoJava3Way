package br.com.threeway.locadora.controler;

import br.com.threeway.locadora.dao.FilmeDao;
import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.domain.TipoFilme;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/", "/filmes"})
public class FIlmesServlet extends HttpServlet {
	FilmeDao dao = new FilmeDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null) {
			if (req.getParameter("deletar") != null) {
				dao.delete(Long.valueOf(id));
			} else {
				Filme filme = dao.pegueFilme(Long.valueOf(id));
				req.setAttribute("filme", filme);
			}

		}
		mostreFilmes(req, resp);


	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FilmeDao dao = new FilmeDao();
		Filme filme = new Filme();

		String nome = req.getParameter("nome");
		String tipo = req.getParameter("tipo");
		String id = req.getParameter("id");


		filme.setNome(nome);
		filme.setTipo(TipoFilme.valueOf(tipo));
		if (id != null && !id.isEmpty()) {
			filme.setId(Long.valueOf(id));
			dao.atualize(filme);
		} else {
			dao.insira(filme);
		}


		mostreFilmes(req, resp);

	}

	private void mostreFilmes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("tipos", TipoFilme.values());
		req.setAttribute("filmes", dao.listeFilmes());

		req.getRequestDispatcher("WEB-INF/locadora.jsp").forward(req, resp);

	}
}
