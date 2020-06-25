package sof302.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sof302.assignment.entities.User;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    User findByUsernameAndPassword(String username, String password);
}
