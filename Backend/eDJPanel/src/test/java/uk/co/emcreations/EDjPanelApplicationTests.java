package uk.co.emcreations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import uk.co.emcreations.eDJPanel.EDjPanelApplication;
import uk.co.emcreations.eDJPanel.controller.HealthCheckController;

@SpringBootTest(classes = EDjPanelApplication.class)
class EDjPanelApplicationTests {

	@Autowired
	private HealthCheckController healthCheckController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(healthCheckController).isNotNull();
	}

}
