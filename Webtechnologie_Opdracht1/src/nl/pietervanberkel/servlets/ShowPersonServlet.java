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
		for (User u : renters) {
			rentersList += " <li>" + u + "</li> ";
		}

		String html = "<!DOCTYPE html>" + "<html>"
				+ " <head> <meta charset='ISO-8859-1'> <title>Webtech pieter thimo</title> </head>"
				+ " <body> <p> landLords </p> <ul>" + landLordList + "</ul> <p> renters </p> <ul>" + rentersList
				+ "</ul> </body> " + "</html>";

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
