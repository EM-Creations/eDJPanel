package uk.co.emcreations.eDJPanel.business;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.model.Link;
import uk.co.emcreations.eDJPanel.persistence.LinkRepository;

@Service
@Log4j2
public class LinkService {
	@Autowired
	private LinkRepository LinkRepository;
	
	public List<Link> findAll() {
		log.trace("Find all called.");
		Iterable<Link> it = LinkRepository.findAll();
		
		return StreamSupport.stream(it.spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Link findOneById(long id) {
		log.trace("Find by one called.");
		Optional<Link> link = LinkRepository.findById(id);
		
		return link.orElse(new Link());
	}
	
	public long count() {
		log.trace("Count called.");
		return LinkRepository.count();
	}
	
	public void deleteById(long id) {
		log.trace("Delete by ID called.");
		LinkRepository.deleteById(id);
    }
}
