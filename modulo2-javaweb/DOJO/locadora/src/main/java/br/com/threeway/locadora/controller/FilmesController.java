package br.com.threeway.locadora.controller;

import br.com.threeway.locadora.dao.FilmeDAO;
import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.domain.TipoFilme;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by fernandocamargo on 08/07/17.
 */
@WebServlet(name = "FilmesController", value = {"/filmes","/"})
public class FilmesController extends HttpServlet {
	FilmeDAO dao = new FilmeDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Filme filme = new Filme();

		String id = request.getParameter("id");

		filme.setNome(request.getParameter("nome"));
		filme.setTipo(TipoFilme.valueOf(request.getParameter("tipo")));
		if(id != null && !id.isEmpty()){
			filme.setId(Long.parseLong(id));

				dao.update(filme);

		}else {
			dao.cadastro(filme);
		}

		abraFilmes(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String id = request.getParameter("id");
		if(id != null){
			if(request.getParameter("deletar") != null){
				dao.delete(Long.parseLong(id));
			}else{
				request.setAttribute("filme", dao.find(Long.parseLong(id)));
			}
		}

		abraFilmes(request, response);
	}

	private void abraFilmes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Filme> filmes = dao.findAll();

		request.setAttribute("filmes", filmes);
		request.getRequestDispatcher("filmes.jsp").forward(request, response);
	}


}
