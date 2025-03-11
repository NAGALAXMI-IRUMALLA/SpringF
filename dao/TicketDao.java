package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Payment;
import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.repo.TicketRepo;

@Repository
public class TicketDao {
	@Autowired
	TicketRepo ticketRepo;
	@Autowired
	PaymentDao paymentDao;
	
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}
	public Ticket fetchTicketById(int ticketId) {
		Optional<Ticket> ticket=ticketRepo.findById(ticketId);
		if(ticket.isPresent()) {
			return ticket.get();
		}
		return null;
	}
	public Ticket updateTicketById(int oldTicketId,Ticket newTicket) {
		newTicket.setTicketId(oldTicketId);
		return ticketRepo.save(newTicket);
	}
  public Ticket deleteTicketById(int ticketId) {
	  Ticket ticket=fetchTicketById(ticketId);
	  ticketRepo.delete(ticket);
	  return ticket;
  }
  public List<Ticket> fetchAllTicket() {
	  return ticketRepo.findAll();
  }
   public Ticket addExistingPaymentToExistingTicket(int paymentId,int ticketId) {
	   Ticket ticket=fetchTicketById(ticketId);
	   Payment payment=paymentDao.fetchPaymentById(paymentId);
	   ticket.setPayment(payment);
	   return ticketRepo.save(ticket);
	   
   }
   
}
