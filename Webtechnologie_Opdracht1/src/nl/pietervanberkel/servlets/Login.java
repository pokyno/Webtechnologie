package nl.pietervanberkel.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.pietervanberkel.model.Model;

/**
 * Servlet implementation class Login
 */
@WebServlet(description = "controls the login proces", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String TESTNAME = "pieter";
	private static final String TESTPASSWORD = "test"; 
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession s = request.getSession();
		if (!s.isNew()) {
		   s.invalidate();
		   s = request.getSession(); 
		}
		Model model = new Model(); // the data is consistend over all instances to simulate a data base
		s.setAttribute("model", model);
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model = (Model)request.getSession().getAttribute("model");
		
		String name = request.getParameter("Login_Name");
		String password = request.getParameter("PassWord");
		
		System.out.println(name);
		System.out.println(password);
		
		if(model.checkUserNameWithPassword(name, password)){
			//maak achterliggende systeem oftuwel maak een webpagina voor dit
			System.out.println("logged in");
		}else{
			request.getServletContext().getRequestDispatcher("/WEB-INF/fouteInlog.html").forward(request,response);
			//response.sendRedirect("fouteInlog.html");
			
		}
		
	}

}
