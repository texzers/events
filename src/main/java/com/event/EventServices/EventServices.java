package com.event.EventServices;

import com.event.Entity.Eventsent;
import com.event.ErrorClass.InvalidUserId;
import com.event.ErrorClass.NotFoundException;
import com.event.ErrorClass.UserAlreadyExist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.event.EventsPojo.Events;
import com.event.Repository.Repo;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class EventServices {
    @Autowired
    private Repo repo;

    Logger logger = LoggerFactory.getLogger(EventServices.class);

   public Eventsent setEntity(Events events){
        Eventsent eventsent = new Eventsent(events.getEventId(),events.getEventName(),
                events.getDate(), events.getLocation(), events.getOrganizer());
        return eventsent;
    }

    public ResponseEntity<Object> CreateEvent(Events events){
       Eventsent eventsent = setEntity(events);
       if(!repo.existsById(eventsent.getEventID())){
           if (repo.save(eventsent) != null) {
               logger.info("Event detaile getting inserted");
               return ResponseEntity.ok("New Event is created successfully");
           }
       }
           throw new UserAlreadyExist("This event is already Exist");
    }

    public List<Eventsent> getListOfEvent() {
        return repo.findAll();
    }

    public ResponseEntity<Object> deleteEvent(Integer id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok("The event is deleted");
        }
         throw  new NotFoundException("Event does not exist");
    }

    public String updateEvents(Events events) {
        if(repo.existsById(events.getEventId())){
            if(repo.save(setEntity(events)) != null){
                logger.info("Event detailes getting updated");
                return "Success";
            }
            else{
                return "Failed";
            }
        }
        return "This" + events.getEventName() +"event not found";
    }

    public ResponseEntity<Object> getEvent(Integer id) {
        Optional<Eventsent> byId = repo.findById(id);
        if (byId.isPresent()){
            return ResponseEntity.ok(byId.get());
        }
        logger.error("The file is missing from db");
        throw new NotFoundException("The File is not Found "+id+" Here");

    }

}
