package uk.co.emcreations.eDJPanel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.EDjPanelApplication;

@RestController
@RequestMapping("health-check")
@Log4j2
public class HealthCheckController {
	
	@GetMapping("/restart")
    public void restart() {
		log.info("Restart called.");
		EDjPanelApplication.restart();
    }

}
