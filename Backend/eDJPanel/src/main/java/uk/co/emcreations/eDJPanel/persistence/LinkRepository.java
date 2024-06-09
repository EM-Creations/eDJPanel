package uk.co.emcreations.eDJPanel.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.co.emcreations.eDJPanel.model.Link;

@Repository
public interface LinkRepository extends CrudRepository<Link, Long> {

}
