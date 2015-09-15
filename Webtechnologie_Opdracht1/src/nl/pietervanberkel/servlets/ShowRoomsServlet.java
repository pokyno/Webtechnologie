package nl.pietervanberkel.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.pietervanberkel.model.Model;
import nl.pietervanberkel.model.Room;
import nl.pietervanberkel.model.User;

/**
 * Servlet implementation class ShowRoomsServlet
 */
@WebServlet("/ShowRoomsServlet")
public class ShowRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRoomsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if(session == null){
			response.sendRedirect("/Webtechnologie_Opdracht1/login.html");
		}
		
		String name = (String) session.getAttribute("name");
		
		Model model = (Model) request.getServletContext().getAttribute("Model");
		
		ArrayList<Room> rooms = model.getRoomsByUser(name);
		
		PrintWriter writer = response.getWriter();
		
		String roomsList = "";
		for (Room room : rooms) {
			roomsList += " <li>" + room + "</li> ";
		}

		String html = "<!DOCTYPE html>" + "<html>"
				+ " <head> <meta charset='ISO-8859-1'> <title>Webtech pieter thimo</title> </head>"
				+ " <body> <p> landLords </p> <ul>" + roomsList + "</ul><a href='/Webtechnologie_Opdracht1/addRoom.html'>add a room</a><br>"
				+ "<a href='/Webtechnologie_Opdracht1/LogoutServlet'> Logout</a> </body> " + "</html>";

		writer.println(html);
		
		
	}

}
