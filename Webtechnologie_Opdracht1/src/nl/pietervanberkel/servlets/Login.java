package nl.pietervanberkel.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.pietervanberkel.model.Model;
import nl.pietervanberkel.model.User;
import nl.pietervanberkel.util.UserCookie;

/**
 * Servlet implementation class Login
 */
@WebServlet(description = "controls the login proces", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model model;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		model = (Model) config.getServletContext().getAttribute("Model");
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession s = request.getSession(false);
		if(s != null){
			System.out.println("authorized");
			String name = (String) s.getAttribute("name");
			if(model.getUser(name).getRol() == User.HUURDER){
				request.getServletContext().getRequestDispatcher("/WEB-INF/huurder.html").forward(request,response);
			}else if(model.getUser(name).getRol() == User.VERHUURDER){
				response.sendRedirect("/Webtechnologie_Opdracht1/ShowRoomsServlet");
			}else if(model.getUser(name).getRol() == User.ADMIN){
				response.sendRedirect("/Webtechnologie_Opdracht1/ShowPersonServlet");
			}
			
		}else{
			System.out.println("not authorized");
			response.sendRedirect("/Webtechnologie_Opdracht1/login.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("Login_Name");
		String password = request.getParameter("Password");
		
		System.out.println(name);
		System.out.println(password);
		
		//Model model = (Model) request.getServletContext().getAttribute("Model");
		
		User user = model.getUser(name);
		if(user != null){
			if(user.getPassword().equals(password)){
			
				HttpSession session = request.getSession();
				if(!session.isNew()){
					session.invalidate();
					session = request.getSession();
				}
				
				for (Cookie cookie : request.getCookies()){
					if (cookie.getName().equals(user.getName())){
						cookie.setValue(null);
					}
				}


				session.setAttribute("name", name);
				
				if(user.getRol() == User.ADMIN){
					response.sendRedirect("/Webtechnologie_Opdracht1/ShowPersonServlet");
				}else if(user.getRol() == User.HUURDER){
					request.getServletContext().getRequestDispatcher("/WEB-INF/huurder.html").forward(request,response);
				}else if(user.getRol() == User.VERHUURDER){
					response.sendRedirect("/Webtechnologie_Opdracht1/ShowRoomsServlet");
				}
			}
		}else{
			request.getServletContext().getRequestDispatcher("/WEB-INF/fouteInlog.html").forward(request,response);
		}
		
		System.out.println(model == null);
		
		System.out.println(model.getUsers());
		
		
		
		
	}

}
