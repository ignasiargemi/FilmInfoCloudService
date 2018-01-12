package show;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Domain.Film;
import Repository.FilmDAO;

import java.util.*;

/**
 * Web Servlet to show films with a certain title from the DB
 */
@SuppressWarnings("serial")
public class showFindFilm extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pragma", "no-cache");
    String filmTitle = request.getParameter("filmTitle");
    List<Film> films = FilmDAO.getFilmByTitle(filmTitle);
    request.setAttribute("films", films);
    String format = request.getParameter("format");
    String outputPage;
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