package uk.co.emcreations.eDJPanel.business;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.model.RadioInfo;
import uk.co.emcreations.eDJPanel.persistence.RadioInfoRepository;

@Service
@Log4j2
public class RadioInfoService {
	@Autowired
	private RadioInfoRepository radioInfoRepository;
	
	public List<RadioInfo> findAll() {
		log.trace("Find all called.");
		Iterable<RadioInfo> it = radioInfoRepository.findAll();
		
		return StreamSupport.stream(it.spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public RadioInfo findOneById(long id) {
		log.trace("Find by one called.");
		Optional<RadioInfo> radioInfo = radioInfoRepository.findById(id);
		
		return radioInfo.orElse(new RadioInfo());
	}
	
	public long count() {
		log.trace("Count called.");
		return radioInfoRepository.count();
	}
	
	public void deleteById(long id) {
		log.trace("Delete by ID called.");
        radioInfoRepository.deleteById(id);
    }
}
