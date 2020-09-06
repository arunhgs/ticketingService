package com.ticket.service;

import com.ticket.constants.EnumConstants.TicketType;
import com.ticket.request.TicketRequest;
import com.ticket.response.BaseResponse;

public interface TicketingService {

	public BaseResponse create(TicketRequest ticketRequest);

	public BaseResponse get(TicketType ticketType, Integer id);

	public BaseResponse delete(TicketType type, Integer id);

}
