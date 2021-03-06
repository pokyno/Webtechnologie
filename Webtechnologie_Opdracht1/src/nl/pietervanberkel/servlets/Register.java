package nl.pietervanberkel.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.pietervanberkel.model.Model;
import nl.pietervanberkel.model.User;
import nl.pietervanberkel.util.UserCookie;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model = (Model) request.getServletContext().getAttribute("Model");
		
		String password = request.getParameter("Password");
		String name = request.getParameter("Login_Name");
		String selectedRol = request.getParameter("Rol");
		
		if(name.isEmpty() || password.isEmpty()){
			System.out.println("pass of name may not be empty");
			response.sendRedirect("/Webtechnologie_Opdracht1/register.html");
		}else if(model.getUser(name) != null){
			System.out.println("name may not excist already");
			response.sendRedirect("/Webtechnologie_Opdracht1/register.html");
		}else{
			int rol = 0;
			
			if(selectedRol.equals("huurder")){
				rol = User.HUURDER;
			} else if(selectedRol.equals("verhuurder")){
				rol = User.VERHUURDER;
			}
			
			model.addUser(name, password, rol);
			
			UserCookie cookie = new UserCookie(name,null);
			cookie.setMaxAge(999999);
			
			System.out.println("account aangemaakt");
			
			response.addCookie(cookie);
			response.sendRedirect("/Webtechnologie_Opdracht1/login.html");
		}
	
		
		
	}

}
