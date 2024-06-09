package uk.co.emcreations.eDJPanel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.facade.RuleFacade;
import uk.co.emcreations.eDJPanel.model.Rule;

@RestController
@RequestMapping("rule")
@Log4j2
public class RuleController extends AbstractController {
	@Autowired
	private RuleFacade ruleFacade;
	
	@GetMapping("/count")
	public ObjectNode count() {
		log.info("Count called.");
		return createResponseObject(Long.toString(ruleFacade.count()));
	}
	
	@GetMapping("/all")
	public List<Rule> findAll() {
		log.info("Find all called.");
		return ruleFacade.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Rule findByOneId(@PathVariable long id) {
		log.info("Find called.");
		return ruleFacade.findOneById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable long id) {
		log.info("Delete by ID called.");
        ruleFacade.deleteById(id);
    }
	
}
