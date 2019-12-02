package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Person;
import models.PersonDAO;

/**
 * Servlet implementation class UpdatePersonController
 */
@WebServlet("/updatePerson")
public class UpdatePersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		PersonDAO personDAO = new PersonDAO();
		Person person = personDAO.getPerson(id);
		session.setAttribute("person", person);
		response.sendRedirect("update.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int age = Integer.parseInt(request.getParameter("age"));
		HttpSession session = request.getSession();
		Person person = (Person) session.getAttribute("person");
		person.setNom(nom);
		person.setPrenom(prenom);
		person.setAge(age);
		
		PersonDAO personDAO = new PersonDAO();
		personDAO.updatePerson(person);
		
		response.sendRedirect("persons");
	}

}
