package uk.co.emcreations.eDJPanel.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.EDjPanelApplication;

@RestController
@RequestMapping("health-check")
@Log4j2
public class HealthCheckController extends AbstractController {
	@Value("${eDJPanel.env.name:default}")
	private String environment;
	
	@Value("${eDJPanel.version:unknown}")
	private String version;
	
	@GetMapping("/restart")
    public void restart() {
		log.info("Restart called.");
		if ("dev".equals(this.environment)) {
			EDjPanelApplication.restart();
		} else {
			log.warn("Restarting unavailable for this environment.");
		}
    }
	
	@GetMapping("/version")
	public ObjectNode version() {
		log.info("Version called.");
		return createResponseObject(this.version);
	}
	
	@GetMapping("/ping")
	public ObjectNode ping() {
		log.info("Ping called.");
		
		String dateTime = localeDateTimeFormat.format(new Date());
		String message = "eDJPanel is up and running at " + dateTime + " on version: " + this.version;
		return createResponseObject(message);
	}

}
