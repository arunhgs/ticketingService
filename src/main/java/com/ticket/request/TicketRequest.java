package com.ticket.request;

import javax.validation.constraints.NotBlank;

import com.ticket.constants.EnumConstants.TicketType;

public class TicketRequest {

	private Integer ticketId;

	private Integer taskId;

	@NotBlank // TODO: use custom enum validator
	public TicketType ticketType;

	@NotBlank
	public String description;

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
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

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

}
