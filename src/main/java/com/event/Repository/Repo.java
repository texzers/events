package com.event.Repository;
import com.event.Entity.Eventsent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo  extends JpaRepository<Eventsent, Integer> {

}
