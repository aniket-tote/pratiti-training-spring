package com.pratiti.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratiti.modal.Passenger;
import com.pratiti.modal.Passenger.Status;
import com.pratiti.modal.Passenger.Gender;
import com.pratiti.modal.Pnr;

@RestController
@CrossOrigin
public class PnrController {

	@GetMapping("/status")
	public Pnr checkStatus(@RequestParam("pnr2") int inputPnr) {
		
		Pnr pnr = new Pnr();
		pnr.setPnrNo(inputPnr);
		pnr.setTrainNo(12345);
		pnr.setTravelDate(LocalDate.of(2023, 3, 10));
		
		List<Passenger> passengers = new ArrayList<>();
		
		Passenger passenger1 = new Passenger();
		passenger1.setName("Harry");
		passenger1.setGender(Gender.MALE);
		passenger1.setStatus(Status.RAC);
		passengers.add(passenger1);
		
		Passenger passenger2 = new Passenger();
		passenger2.setName("Hermoine");
		passenger2.setGender(Gender.FEMALE);
		passenger2.setStatus(Status.RAC);
		passengers.add(passenger2);
		
		pnr.setPassengers(passengers);
		
		return pnr;
	}
}
