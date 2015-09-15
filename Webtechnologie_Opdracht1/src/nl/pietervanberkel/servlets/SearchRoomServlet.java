package nl.pietervanberkel.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.pietervanberkel.model.Model;
import nl.pietervanberkel.model.Room;

/**
 * Servlet implementation class Huurder
 */
@WebServlet("/SearchRoomServlet")
public class SearchRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRoomServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model = (Model) request.getServletContext().getAttribute("Model");
		try{
			int monthlyPrice =  Integer.parseInt(request.getParameter("monthlyPrice"));
			int distanceFromCurrentLocation = Integer.parseInt(request.getParameter("distance"));
			int surface = Integer.parseInt(request.getParameter("surfaceArea"));
			
			ArrayList<Room> rooms = model.getRooms(monthlyPrice, distanceFromCurrentLocation, surface);
			
			PrintWriter  writer = response.getWriter();
	
			String roomlist = "";
			if(!rooms.isEmpty()){
				for(Room room : rooms){
					roomlist += " <li>"+room+"</li> ";
				}
			}else{
				roomlist += "<li> no rooms found</li>";
			}
			
			
			String html = "<!DOCTYPE html>"
					+ "<html>"
					+ " <head> <meta charset='ISO-8859-1'> <title>Webtech pieter thimo</title> </head>"
					+ " <body> <ul>"+roomlist+"</ul> <br><a href=\"/Webtechnologie_Opdracht1\">go back</a><br>"
					+ "<a href=\"/Webtechnologie_Opdracht1/LogoutServlet\">Logout</a> </body> "
					+ "</html>";
			
			writer.println(html);
			
		}catch(Exception e){
			response.sendRedirect("/Webtechnologie_Opdracht1");
		}
		
		
	}
}
