package nl.pietervanberkel.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.pietervanberkel.model.Model;

/**
 * Servlet implementation class Registreren
 */
@WebServlet("/Registreren")
public class Registreren extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registreren() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Model model = (Model)request.getSession().getAttribute("model");
		
		String username = (String)request.getParameter("User_Name");
		String name = (String) request.getParameter("Name");
		String password = (String) request.getParameter("PassWord");
		String function = (String) request.getParameter("Function");
		
		System.out.println(username);
		System.out.println(name);
		System.out.println(password);
		System.out.println(function);
		
		model.addUser(username, name, password, function);
		
		response.sendRedirect("login.html");
	}

}
