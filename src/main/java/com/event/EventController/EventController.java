package com.event.EventController;

import com.event.Entity.Eventsent;
import com.event.EventServices.EventServices;
import com.event.EventsPojo.Events;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String addNewEvent(@Valid @RequestBody Events events){
        logger.info("Responsed Reached");
        if (events.getEventName() != "")
         return eventServices.CreateEvent(events);
        else
            return "The name is empty";
    }

    @GetMapping("/listOfEvents")
    public List<Eventsent> getListOfEvent(){
        logger.info("All event details are fetched successfully");
        return eventServices.getListOfEvent();
    }

    @DeleteExchange("/deleteevents")
    public String deleteEvent(@RequestParam("id") Integer id){
        if(id != null)
            return eventServices.deleteEvent(id);
        else
            return "Event id is empty";
    }
    @PutMapping("/updatedetailes")
    public String updatedetailes(@RequestBody Events events){
        if(events.getEventID() > 0)
            return eventServices.updateEvents(events);
        else
            return "Invalid event id";
    }


}
