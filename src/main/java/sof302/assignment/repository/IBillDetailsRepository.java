package sof302.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sof302.assignment.entities.Billdetails;

@Repository
public interface IBillDetailsRepository extends JpaRepository<Billdetails, Billdetails.Pk> {
}
