package by.bsu.textparcer.launcher;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Launcher {

	private static final Logger LOG = Logger.getLogger(Launcher.class);

	static {
		PropertyConfigurator.configure(Launcher.class.getResourceAsStream("/logconfig.properties"));
	}

	public static void main(String[] args) {

		LOG.error("Hello world");
	}
}
