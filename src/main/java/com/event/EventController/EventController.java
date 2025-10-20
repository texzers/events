package com.event.EventController;

import com.event.Entity.Eventsent;
import com.event.EventServices.EventServices;
import com.event.EventsPojo.Events;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventServices eventServices;

    @PostMapping("/create")
    public ResponseEntity<Object> addNewEvent(@Valid @RequestBody Events events){
        logger.info("Responsed Reached");
        return eventServices.CreateEvent(events);
    }

    @GetMapping("/listOfEvents")
    public List<Eventsent> getListOfEvent(){
        logger.info("All event details are fetched successfully");
        return eventServices.getListOfEvent();
    }

    @DeleteExchange("/deleteevents")
    public ResponseEntity<Object> deleteEvent(@RequestParam("id") Integer id){
        return eventServices.deleteEvent(id);
    }

    @PutMapping("/updatedetailes")
    public String updatedetailes(@RequestBody Events events){
        if(events.getEventId() > 0)
            return eventServices.updateEvents(events);
        else
            return "Invalid event id";
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<Object> getByID(@PathVariable("eventId") Integer id) {
            return ResponseEntity.ok(eventServices.getEvent(id));
    }


}
