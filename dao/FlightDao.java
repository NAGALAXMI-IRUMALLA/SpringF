package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Airhostess;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.dto.Passenger;
import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.repo.FlightRepo;
@Repository
public class FlightDao {
	@Autowired
	FlightRepo flightRepo;
	@Autowired
	PilotDao pilotDao;
	@Autowired
	AirhostessDao airhostessDao;
	@Autowired
	PassengerDao passengerDao;
	public Flight saveFlight(Flight flight) {
		return flightRepo.save(flight);
	}
	public Flight fetchFlightById(int flightId) {
		Optional<Flight> flight=flightRepo.findById(flightId);
				if(flight.isPresent()) {
					return flight.get();
				}
				else {
					return null;
				}
	}
	public Flight updateFlightById(int oldFlightId,Flight newFlight) {
		newFlight.setFlightId(oldFlightId);
		return flightRepo.save(newFlight);
	}
	public Flight deleteFlightById(int flightId) {
		Flight flight=fetchFlightById(flightId);
		flightRepo.delete(flight);
		return flight;
	}
	public List<Flight> fetchAllFlights(){
		return flightRepo.findAll();
	}
	public Flight addExistingPilotToExistingFlight(int pilotId,int flightId) {
		Flight flight=fetchFlightById(flightId);
		Pilot pilot=pilotDao.fetchPilotById(pilotId);
		List<Pilot> list=flight.getPilots();
		list.add(pilot);
		flight.setPilots(list);
		return flightRepo.save(flight);
	}
	
	public Flight addNewPilotToExistingFlight(int flightId,Pilot newPilot) {
		Flight flight=fetchFlightById(flightId);
		List<Pilot> list=flight.getPilots();
		list.add(newPilot);
		flight.setPilots(list);
		return saveFlight(flight);
	}
	public Flight addExistingAirhostessToExistingFlight(int airhostessId,int flightId) {
		Flight flight=fetchFlightById(flightId);
		Airhostess airhostess=airhostessDao.fetchAirhostessById(airhostessId);
		List<Airhostess> list=flight.getAirhostesses();
		list.add(airhostess);
		flight.setAirhostesses(list);
		return flightRepo.save(flight);
	}
	public Flight addNewAirhostessToExistingFlight(int flightId,Airhostess newAirhostess) {
		Flight flight=fetchFlightById(flightId);
		List<Airhostess> list=flight.getAirhostesses();
		list.add(newAirhostess);
		flight.setAirhostesses(list);
		return flightRepo.save(flight);
	}
	
	public Flight addExistingPassengerToExistingFlight(int passengerId,int flightId) {
		Flight flight=fetchFlightById(flightId);
		Passenger passenger=passengerDao.fetchPassengerById(passengerId);
		List<Passenger> list=flight.getPassengers();
		list.add(passenger);
		flight.setPassengers(list);
		return flightRepo.save(flight);
	}
	public Flight addNewPassengerToExistingFlight(int flightId,Passenger newPassenger){
		Flight flight=fetchFlightById(flightId);
		List<Passenger> list=flight.getPassengers();
		list.add(newPassenger);
		flight.setPassengers(list);
		return flightRepo.save(flight);
	}
	
	
	

}
