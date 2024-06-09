package uk.co.emcreations.eDJPanel.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.business.RadioInfoService;
import uk.co.emcreations.eDJPanel.model.RadioInfo;

@Component
@Log4j2
public class RadioInfoFacade {
	@Autowired
	private RadioInfoService radioInfoService;
	
	public List<RadioInfo> findAll() {
		log.trace("Find all called.");
		return radioInfoService.findAll();
	}
	
	public RadioInfo findOneById(long id) {
		log.trace("Find by one called.");
		return radioInfoService.findOneById(id);
	}
	
	public long count() {
		log.trace("Count called.");
		return radioInfoService.count();
	}
	
	public void deleteById(long id) {
		log.trace("Delete by ID called.");
        radioInfoService.deleteById(id);
    }

}
