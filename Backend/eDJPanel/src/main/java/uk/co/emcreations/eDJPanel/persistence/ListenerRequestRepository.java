package uk.co.emcreations.eDJPanel.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.co.emcreations.eDJPanel.model.ListenerRequest;

@Repository
public interface ListenerRequestRepository extends CrudRepository<ListenerRequest, Long> {

}
