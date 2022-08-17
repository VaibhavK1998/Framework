package log4jStructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jFile {
	static Logger logger=LogManager.getLogger(Log4jFile.class);
	public static void main(String[] args) {
		
		System.out.println("lets start");
		logger.info("this is info of class");
		logger.error("this is error");
		logger.warn("warning");
		logger.fatal("fatal msg");
		
	}

}
