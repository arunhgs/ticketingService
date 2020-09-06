package com.ticket.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ticket.constants.EnumConstants.TicketType;
import com.ticket.constants.ResponseConstants;
import com.ticket.dto.TaskDto;
import com.ticket.dto.TicketDto;
import com.ticket.exceptions.ValidationException;
import com.ticket.model.Task;
import com.ticket.model.Ticket;
import com.ticket.repository.TaskRepository;
import com.ticket.repository.TicketRepository;
import com.ticket.request.TicketRequest;
import com.ticket.response.BaseResponse;
import com.ticket.service.TicketingService;

@Service
public class TicketingServiceImpl implements TicketingService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public BaseResponse create(TicketRequest request) {
		Object responseData = null;
		if (TicketType.TICKET.equals(request.getTicketType())) {
			Ticket ticket = new Ticket();
			ticket.setDescription(request.getDescription());
			ticketRepository.save(ticket);
			responseData = TicketDto.createTicketDto(ticket);
		} else if (TicketType.TASK.equals(request.getTicketType())) {
			Task task = new Task();
			task.setTicketId(request.getTicketId());
			task.setDescription(request.getDescription());
			taskRepository.save(task);
			responseData = TaskDto.createTaskDto(task);
		} else {
			throw new ValidationException(ResponseConstants.UNSUPPORTED_TICKET_TYPE);
		}
		return BaseResponse.success(responseData);
	}

	@Override
	public BaseResponse get(TicketType ticketType, Integer id) {
		if (TicketType.TICKET.equals(ticketType)) {
			Optional<Ticket> ticket = ticketRepository.findById(id);
			TicketDto ticketDto = TicketDto.createTicketDto(ticket.get());
			List<Task> tasks = taskRepository.findByTicketId(ticketDto.getId());
			ticketDto.setTasks(TaskDto.createTaskDto(tasks));
			return BaseResponse.success(ticketDto);
		} else if (TicketType.TASK.equals(ticketType)) {
			Optional<Task> task = taskRepository.findById(id);
			return BaseResponse.success(TaskDto.createTaskDto(task.get()));
		} else {
			throw new ValidationException(ResponseConstants.UNSUPPORTED_TICKET_TYPE);
		}

	}

	@Override
	public BaseResponse delete(TicketType ticketType, Integer id) {

		if (TicketType.TICKET.equals(ticketType)) {
			ticketRepository.deleteById(id);
		} else if (TicketType.TASK.equals(ticketType)) {
			taskRepository.deleteById(id);
		} else {
			throw new ValidationException(ResponseConstants.UNSUPPORTED_TICKET_TYPE);
		}
		return BaseResponse.success();
	}

}
