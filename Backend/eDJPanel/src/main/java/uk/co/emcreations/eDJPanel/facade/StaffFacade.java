package uk.co.emcreations.eDJPanel.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.business.StaffService;
import uk.co.emcreations.eDJPanel.model.Staff;

@Component
@Log4j2
public class StaffFacade {
	@Autowired
	private StaffService staffService;
	
	public List<Staff> findAll() {
		log.trace("Find all called.");
		return staffService.findAll();
	}
	
	public Staff findOneById(long id) {
		log.trace("Find by one called.");
		return staffService.findOneById(id);
	}
	
	public long count() {
		log.trace("Count called.");
		return staffService.count();
	}
	
	public void deleteById(long id) {
		log.trace("Delete by ID called.");
        staffService.deleteById(id);
    }

}
