package sof302.assignment.service;

import sof302.assignment.entities.User;

public interface IUserService {
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    void saveOrUpdate(User user);
}
