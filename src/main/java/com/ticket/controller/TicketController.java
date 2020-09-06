package com.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.constants.EnumConstants.TicketType;
import com.ticket.request.TicketRequest;
import com.ticket.response.BaseResponse;
import com.ticket.service.TicketingService;

@RestController
@RequestMapping("/ticketservice")
public class TicketController {

	@Autowired
	private TicketingService ticketingService;

	@PostMapping("/create")
	public BaseResponse create(@RequestBody TicketRequest ticketRequest) {
		return ticketingService.create(ticketRequest);
	}

	@GetMapping("/get")
	public BaseResponse get(@RequestParam("ticketType") TicketType ticketType, @RequestParam("id") Integer id) {
		return ticketingService.get(ticketType, id);
	}

	@DeleteMapping("/delete")
	public BaseResponse delete(@RequestParam("ticketType") TicketType ticketType, @RequestParam("id") Integer id) {
		return ticketingService.delete(ticketType, id);
	}

}
