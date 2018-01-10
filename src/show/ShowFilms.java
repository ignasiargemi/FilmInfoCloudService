package show;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Domain.Film;
import Repository.FilmDAO;

import java.util.*;

@SuppressWarnings("serial")
public class ShowFilms extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pragma", "no-cache");
    List<Film> films = FilmDAO.getAllFilms();
    request.setAttribute("films", films);
    String format = request.getParameter("format");
    String opt = "show";
    opt = request.getParameter("opt");
    String outputPage;
    if (opt.equalsIgnoreCase("createFilms")){
    	FilmDAO.createAllFilms();
    }
    else {
		if ("xml".equals(format)) {
		  response.setContentType("text/xml");
		  outputPage = "/WEB-INF/results/films-xml.jsp";
		} else if ("string".equals(format)) {
			response.setContentType("text/plain");
			outputPage = "/WEB-INF/results/films-string.jsp";
		} else {
		  response.setContentType("application/json");
		  outputPage = "/WEB-INF/results/films-json.jsp";
		}
		
		RequestDispatcher dispatcher =
		  request.getRequestDispatcher(outputPage);
		dispatcher.include(request, response);
    }
  }
}

