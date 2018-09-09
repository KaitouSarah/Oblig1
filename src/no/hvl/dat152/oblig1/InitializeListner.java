package no.hvl.dat152.oblig1;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializeListner implements ServletContextListener {

	@Override
	public final void contextInitialized(final ServletContextEvent sce) {
		try {
			Main.initializeDatabase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
