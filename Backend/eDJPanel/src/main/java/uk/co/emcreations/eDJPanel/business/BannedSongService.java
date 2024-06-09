package uk.co.emcreations.eDJPanel.business;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.model.BannedSong;
import uk.co.emcreations.eDJPanel.persistence.BannedSongRepository;

@Service
@Log4j2
public class BannedSongService {
	@Autowired
	private BannedSongRepository bannedSongRepository;
	
	public List<BannedSong> findAll() {
		log.trace("Find all called.");
		Iterable<BannedSong> it = bannedSongRepository.findAll();
		
		return StreamSupport.stream(it.spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public BannedSong findOneById(long id) {
		log.trace("Find by one called.");
		Optional<BannedSong> bannedSong = bannedSongRepository.findById(id);
		
		return bannedSong.orElse(new BannedSong());
	}
	
	public long count() {
		log.trace("Count called.");
		return bannedSongRepository.count();
	}
	
	public void deleteById(long id) {
		log.trace("Delete by ID called.");
		bannedSongRepository.deleteById(id);
    }
}
