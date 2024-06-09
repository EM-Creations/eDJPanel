package uk.co.emcreations.eDJPanel.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import uk.co.emcreations.eDJPanel.business.RuleService;
import uk.co.emcreations.eDJPanel.model.Rule;

@Component
@Log4j2
public class RuleFacade {
	@Autowired
	private RuleService ruleService;
	
	public List<Rule> findAll() {
		log.trace("Find all called.");
		return ruleService.findAll();
	}
	
	public Rule findOneById(long id) {
		log.trace("Find by one called.");
		return ruleService.findOneById(id);
	}
	
	public long count() {
		log.trace("Count called.");
		return ruleService.count();
	}
	
	public void deleteById(long id) {
		log.trace("Delete by ID called.");
        ruleService.deleteById(id);
    }

}
