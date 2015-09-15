package nl.pietervanberkel.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.pietervanberkel.model.Model;

/**
 * Servlet implementation class AddRoom
 */
@WebServlet("/AddRoom")
public class AddRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null){ //used for unauthorized entry
			response.sendRedirect("/Webtechnologie_Opdracht1/login.html"); 
		}
		
		Model model = (Model)request.getServletContext().getAttribute("Model");
		
		int id = Integer.parseInt(request.getParameter("r-id"));
		int price = Integer.parseInt(request.getParameter("r-price"));
		int	distance = Integer.parseInt(request.getParameter("r-distance"));
		int surface = Integer.parseInt(request.getParameter("r-surface"));
		String city = request.getParameter("r-city");
		String owner =(String) session.getAttribute("name");
		
		model.addRoom(id, price, distance, surface, city, owner);
		
		System.out.println("room added");
		
		response.sendRedirect("/Webtechnologie_Opdracht1/ShowRoomsServlet");
	}

}
