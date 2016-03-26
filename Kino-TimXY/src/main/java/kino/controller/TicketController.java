package kino.controller;

import kino.configuration.ErrorGenerator;
import kino.configuration.JsonMessageGenerator;
import kino.model.ModelFactory;
import kino.model.entities.Ticket;
import kino.model.entities.User;
import kino.model.presentation.TicketViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final ModelFactory modelFactory = ModelFactory.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getTickets() {
        try {
            List<Ticket> tickets  = modelFactory.TicketRepository().findAll();
            final List<TicketViewModel> ticketViewModels = new ArrayList<>();
            for(Ticket ticket : tickets) {
                ticketViewModels.add(new TicketViewModel(ticket));
            }
            logger.info("Returning tickets as JSON objects.");
            return new ResponseEntity(ticketViewModels, HttpStatus.OK);
        } catch (NullPointerException e) {
            logger.error("Could not create TicketViewModel. Ticket is null", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Could not create TicketViewModel. Ticket is null"), HttpStatus.NOT_FOUND
            );
        } catch (Exception e) {
            logger.error("Unknown exception.", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Something went wrong. Try later."), HttpStatus.NOT_FOUND
            );
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getTicket(@PathVariable("id") Integer id) {
        try {
            Ticket ticket = modelFactory.TicketRepository().findOne(id);
            TicketViewModel ticketViewModel = new TicketViewModel(ticket);

            logger.info(String.format("Returning ticket with ID:%d as JSON object.", id));

            return new ResponseEntity(ticketViewModel, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            logger.error("Ticket ID parameter type is unsupported.", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Ticket ID parameter type is unsupported."), HttpStatus.NOT_ACCEPTABLE
            );
        } catch (NullPointerException e) {
            logger.error(String.format("Ticket not found for ID:%d.", id), e);
            return new ResponseEntity(
                    ErrorGenerator.generateError(String.format("Ticket not found for ID:%d.", id)), HttpStatus.NOT_FOUND
            );
        } catch (Exception e) {
            logger.error("Something unusual happened. Please try again later.", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Something unusual happened. Please try again later."), HttpStatus.NOT_FOUND
            );
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Ticket ticket) {
        try {
            modelFactory.TicketRepository().saveAndFlush(ticket);

            logger.info(String.format("Ticket successfully created. Ticket ID:%d", ticket.getId()));
            return new ResponseEntity(new TicketViewModel(ticket), HttpStatus.OK);
        } catch (NullPointerException e) {
            logger.error("Failed to create ticket.", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Failed to create ticket."), HttpStatus.NOT_FOUND
            );
        } catch (Exception e) {
            logger.error("Something unusual happened. Please try again later.", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Something unusual happened. Please try again later."), HttpStatus.NOT_FOUND
            );
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody Ticket newTicket) {
        try {
            Ticket ticket = modelFactory.TicketRepository().findOne(id);

            ticket.setUser(newTicket.getUser());
            ticket.setSeatX(newTicket.getSeatX());
            ticket.setSeatY(newTicket.getSeatY());

            modelFactory.TicketRepository().save(ticket);

            logger.info(String.format("Ticket with ID:&d successfully updated.", ticket.getId()));
            return new ResponseEntity(new TicketViewModel(ticket), HttpStatus.OK);
        } catch (NullPointerException e) {
            logger.error("Failed to update ticket.", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Failed to update ticket."), HttpStatus.NOT_FOUND
            );
        } catch (Exception e) {
            logger.error("Something unusual happened. Please try again later.", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Something unusual happened. Please try again later."), HttpStatus.NOT_FOUND
            );
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        try {
            modelFactory.TicketRepository().delete(id);

            logger.info(String.format("Ticket with ID:%d successfully deleted", id));

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(JsonMessageGenerator.generateMessage(
                            "Success", String.format("Ticket with ID:%d successfully deleted", id)
                    ));
        } catch (NullPointerException e) {
            logger.error("Failed to delete ticket.", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Failed to delete ticket."), HttpStatus.NOT_FOUND
            );
        } catch (IllegalArgumentException e) {
            logger.error("The given id must not be null", e);

            return new ResponseEntity(
                    ErrorGenerator.generateError("The given id must not be null"), HttpStatus.NOT_ACCEPTABLE
            );
        } catch (EmptyResultDataAccessException e) {
            logger.error(e.getMessage());

            return new ResponseEntity(
                    ErrorGenerator.generateError(e.getMessage()), HttpStatus.NOT_FOUND
            );
        } catch (Exception e) {
            logger.error("Something unusual happened. Please try again later.", e);
            return new ResponseEntity(
                    ErrorGenerator.generateError("Something unusual happened. Please try again later."), HttpStatus.NOT_FOUND
            );
        }
    }

}
