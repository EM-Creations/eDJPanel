package uk.co.emcreations.eDJPanel.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.business.LinkService;
import uk.co.emcreations.eDJPanel.model.Link;

@Component
@Log4j2
public class LinkFacade {
	@Autowired
	private LinkService linkService;
	
	public List<Link> findAll() {
		log.trace("Find all called.");
		return linkService.findAll();
	}
	
	public Link findOneById(long id) {
		log.trace("Find by one called.");
		return linkService.findOneById(id);
	}
	
	public long count() {
		log.trace("Count called.");
		return linkService.count();
	}
	
	public void deleteById(long id) {
		log.trace("Delete by ID called.");
        linkService.deleteById(id);
    }

}
