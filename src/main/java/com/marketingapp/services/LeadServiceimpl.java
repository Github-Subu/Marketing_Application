package com.marketingapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.entites.Lead;
import com.marketingapp.repository.LeadRepository;


@Service
public class LeadServiceimpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveOneLead(Lead l) {
		leadRepo.save(l);

	}

	@Override
	public List<Lead> listAllLead() {
		List<Lead> lead = leadRepo.findAll();
	
		return lead;
	}
	
	public void deleteOneLead(long id) {
		leadRepo.deleteById(id);
	}

	@Override
	public Lead getOneLead(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		
		return lead;
	}




}
