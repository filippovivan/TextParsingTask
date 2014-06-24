package textparcer;

import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

public class Test {
	static {
		new DOMConfigurator().doConfigure("resourses/logconfig.xml",
				LogManager.getLoggerRepository());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
