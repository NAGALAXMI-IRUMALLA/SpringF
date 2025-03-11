package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.dto.Food;
import com.project.flight_management_system.dto.Passenger;
import com.project.flight_management_system.dto.Passport;
import com.project.flight_management_system.dto.Seat;
import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.repo.PassengerRepo;
@Repository
public class PassengerDao {
	@Autowired
	PassengerRepo passengerRepo;
	
	@Autowired
	SeatDao seatDao;
	@Autowired
	PassportDao passportDao;
	
	@Autowired
	AddressDao addressDao;
	@Autowired
	TicketDao ticketDao;
	@Autowired
	FoodDao foodDao;
	public Passenger savePassenger(Passenger passenger) {
		return passengerRepo.save(passenger);
	}
	public Passenger fetchPassengerById(int passengerId) {
		Optional<Passenger> passenger=passengerRepo.findById(passengerId);
		if(passenger.isPresent()) {
		return passenger.get();
		}
		else {
			return null;
		}
	}
	public Passenger updatePassengerById(int oldPassengerId,Passenger newPassenger) {
		newPassenger.setPassengerId(oldPassengerId);
		return passengerRepo.save(newPassenger);
	}
	public Passenger deletePassengerById(int passengerId) {
		Passenger passenger=fetchPassengerById(passengerId);
		passengerRepo.delete(passenger);
		return passenger;
	}
	public List<Passenger> fetchAllPassenger(){
		return passengerRepo.findAll();
	}
	
	public Passenger addExistingSeatToExistingPassenger(int seatId,int passengerId) {
		Passenger passenger=fetchPassengerById(passengerId);
		Seat seat=seatDao.fetchSeatById(seatId);
		passenger.setSeat(seat);
		return passengerRepo.save(passenger);
		
	}
	public Passenger addExistingAddressToExistingPassenger(int addressId,int passengerId) {
		Passenger passenger=fetchPassengerById(passengerId);
		Address address=addressDao.fetchAddressById(addressId);
		passenger.setAddress(address);
		return passengerRepo.save(passenger);
	}
	
	public Passenger addExistingPassportToExistingPassenger(int passportId,int passengerId) {
		Passenger passenger=fetchPassengerById(passengerId);
		Passport passport=passportDao.fetchPassportById(passportId);
		passenger.setPassport(passport);
		return passengerRepo.save(passenger);
	}
	public Passenger addExistingTicketToExistingPassenger(int ticketId,int passengerId) {
		Passenger passenger=fetchPassengerById(passengerId);
		Ticket ticket=ticketDao.fetchTicketById(ticketId);
		List<Ticket> list=passenger.getTickets();
		list.add(ticket);
		passenger.setTickets(list);
		return passengerRepo.save(passenger);
	}
	public Passenger addNewTicketToExistingPassenger(int passengerId ,Ticket newTicket) {
		Passenger passenger=fetchPassengerById(passengerId);
	     List<Ticket> list=passenger.getTickets();
	     list.add(newTicket);
	     passenger.setTickets(list);
		return passengerRepo.save(passenger);
	}
	public Passenger addExistingFoodToExistingPassenger(int foodId,int passengerId) {
		Passenger passenger=fetchPassengerById(passengerId);
		Food food=foodDao.fetchFoodById(foodId);
		List<Food> list=passenger.getFoods();
		list.add(food);
		passenger.setFoods(list);
		return passengerRepo.save(passenger);
	}
	public Passenger addNewFoodToExistingPassenger(int passengerId,Food newFood) {
		Passenger passenger=fetchPassengerById(passengerId);
		List<Food> list=passenger.getFoods();
		list.add(newFood);
		passenger.setFoods(list);
		return passengerRepo.save(passenger);
	}
	
	
	
	
	

}
