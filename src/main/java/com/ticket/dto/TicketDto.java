package com.ticket.dto;

import java.util.List;

import com.ticket.dto.TaskDto;
import com.ticket.model.Ticket;

public class TicketDto {

	private Integer id;
	private String description;
	private List<TaskDto> tasks;

	public static TicketDto createTicketDto(Ticket ticket) {
		TicketDto dto = new TicketDto();
		dto.setId(ticket.getId());
		dto.setDescription(ticket.getDescription());
		return dto;

	}

	public static TicketDto createTicketDto(Ticket ticket, List<TaskDto> tasks) {
		TicketDto dto = createTicketDto(ticket);
		dto.setTasks(tasks);
		return dto;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TaskDto> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskDto> tasks) {
		this.tasks = tasks;
	}

}
