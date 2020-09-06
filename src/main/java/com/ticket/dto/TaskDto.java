package com.ticket.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.ticket.model.Task;

public class TaskDto {

	private Integer id;
	private Integer ticketId;
	private String description;

	public static TaskDto createTaskDto(Task task) {
		TaskDto dto = new TaskDto();
		dto.setId(task.getId());
		dto.setTicketId(task.getTicketId());
		dto.setDescription(task.getDescription());
		return dto;
	}
	
	public static List<TaskDto> createTaskDto(List<Task> tasks) {
		return tasks.stream().map(task -> createTaskDto(task)).collect(Collectors.toList());
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

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

}
