package sof302.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sof302.assignment.entities.User;
import sof302.assignment.repository.IUserRepository;

import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepo;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }

    @Override
    public User findById(String username) {
        Optional<User> user = userRepo.findById(username);
        if(user.isPresent()){
            User userOut = user.get();
            return userOut;
        }
        return null;
    }

    @Override
    public void saveOrUpdate(User user) {
        userRepo.save(user);
    }
}
