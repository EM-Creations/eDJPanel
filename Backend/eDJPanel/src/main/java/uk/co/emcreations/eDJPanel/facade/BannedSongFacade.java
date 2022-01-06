package uk.co.emcreations.eDJPanel.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.business.BannedSongService;
import uk.co.emcreations.eDJPanel.model.BannedSong;

@Component
@Log4j2
public class BannedSongFacade {
	@Autowired
	private BannedSongService bannedSongService;
	
	public List<BannedSong> findAll() {
		log.trace("Find all called.");
		return bannedSongService.findAll();
	}
	
	public BannedSong findOneById(long id) {
		log.trace("Find by one called.");
		return bannedSongService.findOneById(id);
	}
	
	public long count() {
		log.trace("Count called.");
		return bannedSongService.count();
	}
	
	public void deleteById(long id) {
		log.trace("Delete by ID called.");
        bannedSongService.deleteById(id);
    }

}
