package uk.co.emcreations.eDJPanel.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.co.emcreations.eDJPanel.model.RadioInfo;

@Repository
public interface RadioInfoRepository extends CrudRepository<RadioInfo, Long> {

}
