package uk.co.emcreations.eDJPanel.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.co.emcreations.eDJPanel.model.Staff;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long> {

}
