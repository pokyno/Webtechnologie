package nl.pietervanberkel.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import nl.pietervanberkel.model.Model;

public class ServletListener implements ServletContextListener{
	
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("Model", new Model());
		
	}

}
