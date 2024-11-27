package edu.csula.cysun.jpa.repository;

import edu.csula.cysun.jpa.model.GuestBookEntry;
import org.springframework.data.repository.CrudRepository;

public interface GuestBookEntryRepo extends CrudRepository<GuestBookEntry, Integer> {
}
