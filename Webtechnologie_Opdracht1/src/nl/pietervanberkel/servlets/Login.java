package nl.pietervanberkel.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.pietervanberkel.model.Model;
import nl.pietervanberkel.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet(description = "controls the login proces", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String TESTNAME = "pieter";
	private static final String TESTPASSWORD = "test";
	private static final int VERHUURDER = 0, HUURDER = 1;
	private static final int ROLE = HUURDER;
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */	 
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//hier kunnen we wat doen met data ophalen als het moet
		
		
	}

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("Login_Name");
		String password = request.getParameter("Password");
		
		System.out.println(name);
		System.out.println(password);
		
		Model model = (Model) request.getServletContext().getAttribute("Model");
		
//		for(User user : model.getUsers()){
//			if(name.equals(user.getNaam()) && password.equals(user.getPassword())){
//				if (user.getRol() == User.HUURDER){
					request.getServletContext().getRequestDispatcher("/WEB-INF/huurder.html").forward(request,response);
//				} else if (user.getRol() == User.VERHUURDER){
//					//stuur door naar verhuurder pagina
//				} else {
//					System.out.println("an user has a wrong role int : " + user.getRol());
//				}
//			}else{
//				request.getServletContext().getRequestDispatcher("/WEB-INF/fouteInlog.html").forward(request,response);
//				
//			}
//		}
		
		
	}

}
