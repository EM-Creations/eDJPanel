package uk.co.emcreations.eDJPanel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.facade.RadioInfoFacade;
import uk.co.emcreations.eDJPanel.model.RadioInfo;

@RestController
@RequestMapping("radio-info")
@Log4j2
public class RadioInfoController extends AbstractController {
	@Autowired
	private RadioInfoFacade radioInfoFacade;
	
	@GetMapping("/count")
	public ObjectNode count() {
		log.info("Count called.");
		return createResponseObject(Long.toString(radioInfoFacade.count()));
	}
	
	@GetMapping("/findAll")
	public List<RadioInfo> findAll() {
		log.info("Find all called.");
		return radioInfoFacade.findAll();
	}
	
}
