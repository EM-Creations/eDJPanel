package uk.co.emcreations.eDJPanel.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.business.ListenerRequestService;
import uk.co.emcreations.eDJPanel.model.ListenerRequest;

@Component
@Log4j2
public class ListenerRequestFacade {
	@Autowired
	private ListenerRequestService listenerRequestService;
	
	public List<ListenerRequest> findAll() {
		log.trace("Find all called.");
		return listenerRequestService.findAll();
	}
	
	public ListenerRequest findOneById(long id) {
		log.trace("Find by one called.");
		return listenerRequestService.findOneById(id);
	}
	
	public long count() {
		log.trace("Count called.");
		return listenerRequestService.count();
	}
	
	public void deleteById(long id) {
		log.trace("Delete by ID called.");
        listenerRequestService.deleteById(id);
    }

}
