package kino.controller;

import kino.configuration.ErrorGenerator;
import kino.configuration.JsonMessageGenerator;
import kino.configuration.UserValidator;
import kino.model.ModelFactory;
import kino.model.entities.User;
import kino.model.presentation.UserViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final ModelFactory modelFactory = ModelFactory.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUsers() {
        try {
            List<User> users = modelFactory.UserRepository().findAll();
            List<UserViewModel> userViewModels = new ArrayList<>();
            for (User user : users) {
                userViewModels.add(new UserViewModel(user));
            }
            logger.info("Returning users as JSON objects.");
            return new ResponseEntity(userViewModels, HttpStatus.OK);
        } catch (NullPointerException e) {
            logger.error("Could not create UserViewModel. User is null", e);
            return new ResponseEntity(ErrorGenerator.generateError("User not found."), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unknown exception.", e);
            return new ResponseEntity(ErrorGenerator.generateError("Something unusual happened. Please try again later."), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUser(@PathVariable("id") Integer id) {
        try {
            User user = modelFactory.UserRepository().findOne(id);
            UserViewModel userViewModel = new UserViewModel(user);
            logger.info(String.format("Returning user with ID:%d as JSON object.", id));
            return new ResponseEntity(userViewModel, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            logger.error("User ID parameter type is unsupported", e);
            return new ResponseEntity(ErrorGenerator.generateError("User ID parameter type is unsupported."), HttpStatus.NOT_ACCEPTABLE);
        } catch (NullPointerException e) {
            logger.error(String.format("User not found for ID:%d.", id), e);
            return new ResponseEntity(ErrorGenerator.generateError(String.format("User not found for ID:%d.", id)), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Something unusual happened. Please try again later.", e);
            return new ResponseEntity(ErrorGenerator.generateError("Something unusual happened. Please try again later."), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping( method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity add(@RequestBody User user) {

        if(UserValidator.isInvalidUser(user)) {
            logger.error("User creation failed. Invalid user params.");
            return new ResponseEntity(ErrorGenerator.generateError("User creation failed. Invalid user params."), HttpStatus.BAD_REQUEST);
        }

        try {
            User savedUser = modelFactory.UserRepository().saveAndFlush(user);
            UserViewModel userViewModel = new UserViewModel(savedUser);
            logger.info(String.format("User successfuly created. User ID: %d", user.getId()));
            return new ResponseEntity(userViewModel, HttpStatus.OK);
        } catch (NullPointerException e) {
            logger.error("Failed to create user.", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Failed to create user."), HttpStatus.NOT_FOUND
            );
        } catch (Exception e) {
            logger.error("Error occurred: ", e);
            return new ResponseEntity(ErrorGenerator.generateError("User wasn't successfully added"), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody User newUser) {

        if(UserValidator.isInvalidUser(newUser)) {
            logger.error("User update failed. Invalid user params.");
            return new ResponseEntity(ErrorGenerator.generateError("User update failed. Invalid user params."), HttpStatus.BAD_REQUEST);
        }

        try {
            User user = modelFactory.UserRepository().findOne(id);
            user.setName(newUser.getName());
            user.setAddress(newUser.getAddress());
            user.setEmail(newUser.getEmail());
            user.setNumber(newUser.getNumber());

            modelFactory.UserRepository().save(user);
            logger.info(String.format("User with ID: %d successfully updated.", user.getId()));
            return new ResponseEntity(new UserViewModel(user), HttpStatus.OK);
        } catch (NullPointerException e) {
            logger.error("Failed to update user.", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Failed to update user."), HttpStatus.NOT_FOUND
            );
        } catch (Exception e) {
            logger.error("Error occurred: ", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Something went wrong."), HttpStatus.NOT_FOUND
            );
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id) {
        try {
            modelFactory.UserRepository().delete(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(JsonMessageGenerator.generateMessage(
                                    "Success", String.format("User wth ID: %d successfully deleted.", id))
                    );
        } catch (NullPointerException e) {
            logger.error("Failed to delete user.", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Failed to delete user."), HttpStatus.NOT_FOUND
            );
        } catch (IllegalArgumentException e) {
            logger.error("The given id must not be null", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("The given id must not be null"), HttpStatus.NOT_ACCEPTABLE
            );
        } catch (EmptyResultDataAccessException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(
                    ErrorGenerator.generateError(e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error occurred: ", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Something went wrong."), HttpStatus.NOT_FOUND
            );
        }
    }
}
