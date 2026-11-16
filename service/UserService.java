
package com.example.usermanagement.service;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.exception.UserNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // Create user
    public User createUser(User user) {

        if (repository.existsByEmail(user.getEmail())) {
            throw new DataIntegrityViolationException(
                "Email already exists"
            );
        }

        return repository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // Get user by ID
    public User getUserById(Long id) {
        return repository.findById(id)
            .orElseThrow(() ->
                new UserNotFoundException(
                    "User not found with ID: " + id
                )
            );
    }

    // Update user
    public User updateUser(Long id, User updatedUser) {

        User existingUser = getUserById(id);

        repository.findByEmail(updatedUser.getEmail())
            .filter(user -> !user.getId().equals(id))
            .ifPresent(user -> {
                throw new DataIntegrityViolationException(
                    "Email already exists"
                );
            });

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setDepartment(updatedUser.getDepartment());

        return repository.save(existingUser);
    }

    // Delete user
    public void deleteUser(Long id) {
        User user = getUserById(id);
        repository.delete(user);
    }
}
