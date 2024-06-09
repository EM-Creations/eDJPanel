package uk.co.emcreations.eDJPanel.business;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.model.Rule;
import uk.co.emcreations.eDJPanel.persistence.RuleRepository;

@Service
@Log4j2
public class RuleService {
	@Autowired
	private RuleRepository ruleRepository;
	
	public List<Rule> findAll() {
		log.trace("Find all called.");
		Iterable<Rule> it = ruleRepository.findAll();
		
		return StreamSupport.stream(it.spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Rule findOneById(long id) {
		log.trace("Find by one called.");
		Optional<Rule> rule = ruleRepository.findById(id);
		
		return rule.orElse(new Rule());
	}
	
	public long count() {
		log.trace("Count called.");
		return ruleRepository.count();
	}
	
	public void deleteById(long id) {
		log.trace("Delete by ID called.");
		ruleRepository.deleteById(id);
    }
}
