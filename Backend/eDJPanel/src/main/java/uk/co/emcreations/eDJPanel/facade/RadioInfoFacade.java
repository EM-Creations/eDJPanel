package uk.co.emcreations.eDJPanel.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.emcreations.eDJPanel.business.RadioInfoService;
import uk.co.emcreations.eDJPanel.model.RadioInfo;

@Component
public class RadioInfoFacade {
	@Autowired
	private RadioInfoService radioInfoService;
	
	public List<RadioInfo> findAll() {
		return radioInfoService.findAll();
	}
	
	public RadioInfo findOneById(long id) {
		return radioInfoService.findOneById(id);
	}
	
	public long count() {
		return radioInfoService.count();
	}
	
	public void deleteById(Long id) {
        radioInfoService.deleteById(id);
    }

}
