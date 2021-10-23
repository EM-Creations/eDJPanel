package uk.co.emcreations.eDJPanel.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.EDjPanelApplication;

@RestController
@RequestMapping("health-check")
@Log4j2
public class HealthCheckController {
	@Value( "${eDJPanel.env.name:default}" )
	private String environment;
	
	@GetMapping("/restart")
    public void restart() {
		log.info("Restart called.");
		if ("dev".equals(environment)) {
			EDjPanelApplication.restart();
		} else {
			log.warn("Restarting unavailable for this environment.");
		}
    }

}
