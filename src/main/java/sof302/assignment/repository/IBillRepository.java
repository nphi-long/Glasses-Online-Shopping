package sof302.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sof302.assignment.entities.Bill;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer> {
    @Query("delete from Bill b where b.status = 'U'")
    void deleteBill();
}
