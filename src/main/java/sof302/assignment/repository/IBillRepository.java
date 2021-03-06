package sof302.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sof302.assignment.entities.Bill;
import sof302.assignment.entities.Product;
import sof302.assignment.entities.User;

import java.util.List;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer> {
}
