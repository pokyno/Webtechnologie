package nl.pietervanberkel.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.pietervanberkel.model.Model;
import nl.pietervanberkel.model.Room;
import nl.pietervanberkel.model.User;
import nl.pietervanberkel.util.UserCookie;

/**
 * Servlet implementation class ShowPersonServlet
 */
@WebServlet("/ShowPersonServlet")
public class ShowPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowPersonServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession(false);
		if (s == null) {
			response.sendRedirect("/Webtechnologie_Opdracht1/login.html");
		}

		Model model = (Model) request.getServletContext().getAttribute("Model");

		ArrayList<User> landLords = model.getLandlords();
		ArrayList<User> renters = model.getRenters();
		PrintWriter writer = response.getWriter();

		String landLordList = "";
		for (User u : landLords) {
			landLordList += " <li>" + u + "</li> ";
		}

		String rentersList = "";
		Cookie[] cookies = request.getCookies();
		
		//TEMP
		for(Cookie c : cookies){
			System.out.println(c.getName() + " ::: " + c.getValue());
		}
		//TEMP
		
		for (User u : renters) {
			String[] dates = new String[0];
			for(Cookie c : cookies){
				if (c.getName().equals(u.getName())){
					dates = c.getValue().split(",");
				}
			}
			if (dates.length != 0){
				rentersList += " <li>" + u + " Login times: " + dates.length + " Last Login " + new Date(Long.parseLong(dates[dates.length - 1])) + "</li> ";
			} else {
				rentersList += " <li>" + u + " Login times: 0" + "</li> ";
			}
		}
		
		String adminLogin = "last login was at: ";
		
		for(Cookie c : cookies){
			if (c.getName().equals(request.getSession().getAttribute("name"))){
				adminLogin += new Date(Long.parseLong(c.getValue()))
								+ " logged in " 
								+ c.getValue().split(",").length
								+ " times.";
			}
		}
		
		String html = "<!DOCTYPE html>" + "<html>"
				+ " <head> <meta charset='ISO-8859-1'> <title>Webtech pieter thimo</title> </head>"
				+ " <body> "
				+ " <p> " + adminLogin + " </p>"
				+ "<p> landLords </p> <ul>" + landLordList + "</ul> <p> renters </p> <ul>" + rentersList
				+ "</ul> <a href='/Webtechnologie_Opdracht1/LogoutServlet'> Logout</a> </body> " + "</html>";

		writer.println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
