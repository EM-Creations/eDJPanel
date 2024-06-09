package uk.co.emcreations.eDJPanel;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class EDjPanelApplication {
	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		EDjPanelApplication.context = SpringApplication.run(EDjPanelApplication.class, args);
	}
	
	public static void restart() {
		if (null == EDjPanelApplication.context) {
			log.error("Only 1 restart of the application is supported at this time, please manually restart the application if required.");
			System.exit(0);
		} else {
	        ApplicationArguments args = EDjPanelApplication.context.getBean(ApplicationArguments.class);
	
	        Thread thread = new Thread(() -> {
	        	EDjPanelApplication.context.close();
	        	EDjPanelApplication.context = SpringApplication.run(EDjPanelApplication.class, args.getSourceArgs());
	        });
	
	        thread.setDaemon(false);
	        thread.start();
		}
    }

}
