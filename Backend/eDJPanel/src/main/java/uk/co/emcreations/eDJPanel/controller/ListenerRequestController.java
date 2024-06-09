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
import uk.co.emcreations.eDJPanel.facade.ListenerRequestFacade;
import uk.co.emcreations.eDJPanel.model.ListenerRequest;

@RestController
@RequestMapping("listener-request")
@Log4j2
public class ListenerRequestController extends AbstractController {
	@Autowired
	private ListenerRequestFacade listenerRequestFacade;
	
	@GetMapping("/count")
	public ObjectNode count() {
		log.info("Count called.");
		return createResponseObject(Long.toString(listenerRequestFacade.count()));
	}
	
	@GetMapping("/all")
	public List<ListenerRequest> findAll() {
		log.info("Find all called.");
		return listenerRequestFacade.findAll();
	}
	
	@GetMapping("/find/{id}")
	public ListenerRequest findByOneId(@PathVariable long id) {
		log.info("Find called.");
		return listenerRequestFacade.findOneById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable long id) {
		log.info("Delete by ID called.");
        listenerRequestFacade.deleteById(id);
    }
	
}
