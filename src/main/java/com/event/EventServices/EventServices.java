package com.event.EventServices;

import com.event.Entity.Eventsent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.event.EventsPojo.Events;
import com.event.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServices {
    @Autowired
    private Repo repo;

    public Eventsent setEntity(Events events){
        Eventsent eventsent = new Eventsent(events.getEventID(),events.getEventName(),
                events.getDate(), events.getLocation(), events.getOrganizer());
        return eventsent;
    }

    private final static Logger logger = LoggerFactory.getLogger(EventServices.class);
    public String CreateEvent(Events events){
        if(repo.save(setEntity(events)) != null){
            logger.info("Event detailes getting inserted");
            return "Success";
        }
        else{
            return "Failed";
        }

    }

    public List<Eventsent> getListOfEvent() {
        return repo.findAll();
    }

    public String deleteEvent(Integer id) {
         repo.deleteById(id);
         return "Success";
    }

    public String updateEvents(Events events) {
        if(repo.existsById(events.getEventID())){
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
}
