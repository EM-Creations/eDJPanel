package uk.co.emcreations.eDJPanel.business;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.model.Staff;
import uk.co.emcreations.eDJPanel.persistence.StaffRepository;

@Service
@Log4j2
public class StaffService {
	@Autowired
	private StaffRepository staffRepository;
	
	public List<Staff> findAll() {
		log.trace("Find all called.");
		Iterable<Staff> it = staffRepository.findAll();
		
		return StreamSupport.stream(it.spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Staff findOneById(long id) {
		log.trace("Find by one called.");
		Optional<Staff> staff = staffRepository.findById(id);
		
		return staff.orElse(new Staff());
	}
	
	public long count() {
		log.trace("Count called.");
		return staffRepository.count();
	}
	
	public void deleteById(long id) {
		log.trace("Delete by ID called.");
		staffRepository.deleteById(id);
    }
}
