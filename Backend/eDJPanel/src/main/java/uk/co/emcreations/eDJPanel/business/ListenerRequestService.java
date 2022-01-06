package uk.co.emcreations.eDJPanel.business;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.model.ListenerRequest;
import uk.co.emcreations.eDJPanel.persistence.ListenerRequestRepository;

@Service
@Log4j2
public class ListenerRequestService {
	@Autowired
	private ListenerRequestRepository listenerRequestRepository;
	
	public List<ListenerRequest> findAll() {
		log.trace("Find all called.");
		Iterable<ListenerRequest> it = listenerRequestRepository.findAll();
		
		return StreamSupport.stream(it.spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public ListenerRequest findOneById(long id) {
		log.trace("Find by one called.");
		Optional<ListenerRequest> listenerRequest = listenerRequestRepository.findById(id);
		
		return listenerRequest.orElse(new ListenerRequest());
	}
	
	public long count() {
		log.trace("Count called.");
		return listenerRequestRepository.count();
	}
	
	public void deleteById(long id) {
		log.trace("Delete by ID called.");
		listenerRequestRepository.deleteById(id);
    }
}
