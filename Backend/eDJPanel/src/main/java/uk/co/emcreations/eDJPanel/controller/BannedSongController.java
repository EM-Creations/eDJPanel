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
import uk.co.emcreations.eDJPanel.facade.BannedSongFacade;
import uk.co.emcreations.eDJPanel.model.BannedSong;

@RestController
@RequestMapping("banned-song")
@Log4j2
public class BannedSongController extends AbstractController {
	@Autowired
	private BannedSongFacade bannedSongFacade;
	
	@GetMapping("/count")
	public ObjectNode count() {
		log.info("Count called.");
		return createResponseObject(Long.toString(bannedSongFacade.count()));
	}
	
	@GetMapping("/all")
	public List<BannedSong> findAll() {
		log.info("Find all called.");
		return bannedSongFacade.findAll();
	}
	
	@GetMapping("/find/{id}")
	public BannedSong findByOneId(@PathVariable long id) {
		log.info("Find called.");
		return bannedSongFacade.findOneById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable long id) {
		log.info("Delete by ID called.");
        bannedSongFacade.deleteById(id);
    }
	
}
