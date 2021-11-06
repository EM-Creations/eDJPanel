package uk.co.emcreations.eDJPanel.business;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.emcreations.eDJPanel.model.RadioInfo;
import uk.co.emcreations.eDJPanel.persistence.RadioInfoRepository;

@Service
public class RadioInfoService {
	@Autowired
	private RadioInfoRepository radioInfoRepository;
	
	public List<RadioInfo> findAll() {
		Iterable<RadioInfo> it = radioInfoRepository.findAll();
		
		return StreamSupport.stream(it.spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public RadioInfo findOneById(long id) {
		Optional<RadioInfo> radioInfo = radioInfoRepository.findById(id);
		
		return radioInfo.orElse(new RadioInfo());
	}
	
	public long count() {
		return radioInfoRepository.count();
	}
	
	public void deleteById(Long id) {
        radioInfoRepository.deleteById(id);
    }
}
