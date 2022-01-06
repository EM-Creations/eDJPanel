package uk.co.emcreations.eDJPanel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.facade.StaffFacade;
import uk.co.emcreations.eDJPanel.model.Staff;

@RestController
@RequestMapping("staff")
@Log4j2
public class StaffController extends AbstractController {
	@Autowired
	private StaffFacade staffFacade;
	
	@GetMapping("/count")
	public ObjectNode count() {
		log.info("Count called.");
		return createResponseObject(Long.toString(staffFacade.count()));
	}
	
	@GetMapping("/all")
	public List<Staff> findAll() {
		log.info("Find all called.");
		return staffFacade.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Staff findByOneId(@PathVariable long id) {
		log.info("Find called.");
		return staffFacade.findOneById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable long id) {
		log.info("Delete by ID called.");
        staffFacade.deleteById(id);
    }
	
}
