package com.ticket.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ticket.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

	List<Task> findByTicketId(Integer id);

}
