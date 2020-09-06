package com.ticket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.ticket.constants.EnumConstants;
import com.ticket.constants.ResponseConstants;
import com.ticket.dto.TicketDto;
import com.ticket.exceptions.ValidationException;
import com.ticket.request.TicketRequest;
import com.ticket.response.BaseResponse;
import com.ticket.service.TicketingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketServicesApplicationTest {

	@Autowired
	private TicketingService ticketService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateTicketWithAllValidParams() {

		TicketRequest ticketRequest = new TicketRequest();
		ticketRequest.setTicketType(EnumConstants.TicketType.TICKET);
		ticketRequest.setDescription("Test Create Ticket With All valid Params");

		BaseResponse response = ticketService.create(ticketRequest);
		assertNotNull(response.getData());
		assertEquals(ResponseConstants.SUCCESS, response.getStatus());
	}

	@Test(expected = ValidationException.class)
	public void testCreateTicketWithUnsupportedTicketType() {

		TicketRequest ticketRequest = new TicketRequest();
		ticketRequest.setTicketType(EnumConstants.TicketType.UNSUPPORTED);
		ticketRequest.setDescription("Test Create Ticket With UNSUPPORTED ticket type");
		ticketService.create(ticketRequest);
	}

	@Test
	public void testGetTicketWithAllValidParams() {

		TicketRequest ticketRequest = new TicketRequest();
		ticketRequest.setTicketType(EnumConstants.TicketType.TICKET);
		ticketRequest.setDescription("Test Ticket With All valid Params For Get Test");
		BaseResponse response = ticketService.create(ticketRequest);
		TicketDto ticketDto = (TicketDto) response.getData();

		BaseResponse getResponse = ticketService.get(EnumConstants.TicketType.TICKET, 1);
		assertNotNull(getResponse.getData());
		assertEquals(ResponseConstants.SUCCESS, getResponse.getStatus());
		assertEquals(ticketDto.getId(), ((TicketDto) getResponse.getData()).getId());

	}

	@Test
	public void testDeleteTicketWithAllValidParams() {

		TicketRequest ticketRequest = new TicketRequest();
		ticketRequest.setTicketType(EnumConstants.TicketType.TICKET);
		ticketRequest.setDescription("Test Ticket With All valid Params For Delete Test");
		BaseResponse response = ticketService.create(ticketRequest);
		TicketDto ticketDto = (TicketDto) response.getData();

		BaseResponse deleteResponse = ticketService.delete(EnumConstants.TicketType.TICKET, ticketDto.getId());
		assertNull(deleteResponse.getData());
		assertEquals(ResponseConstants.SUCCESS, deleteResponse.getStatus());
	}

}
