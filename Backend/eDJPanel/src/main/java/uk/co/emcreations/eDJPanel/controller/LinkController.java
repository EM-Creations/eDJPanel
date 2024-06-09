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
import uk.co.emcreations.eDJPanel.facade.LinkFacade;
import uk.co.emcreations.eDJPanel.model.Link;

@RestController
@RequestMapping("link")
@Log4j2
public class LinkController extends AbstractController {
	@Autowired
	private LinkFacade linkFacade;
	
	@GetMapping("/count")
	public ObjectNode count() {
		log.info("Count called.");
		return createResponseObject(Long.toString(linkFacade.count()));
	}
	
	@GetMapping("/all")
	public List<Link> findAll() {
		log.info("Find all called.");
		return linkFacade.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Link findByOneId(@PathVariable long id) {
		log.info("Find called.");
		return linkFacade.findOneById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable long id) {
		log.info("Delete by ID called.");
        linkFacade.deleteById(id);
    }
	
}
