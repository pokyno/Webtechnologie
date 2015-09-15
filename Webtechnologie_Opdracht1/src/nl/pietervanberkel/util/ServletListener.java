 package nl.pietervanberkel.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import nl.pietervanberkel.model.Model;

@WebListener
public class ServletListener implements ServletContextListener{
	
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("Model", new Model());
	}

}
