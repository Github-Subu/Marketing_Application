package com.marketingapp.services;

import java.util.List;

import com.marketingapp.entites.Lead;






public interface LeadService {
	
	public void saveOneLead(Lead l);

	public List<Lead> listAllLead();

	public void deleteOneLead(long id);
	public Lead getOneLead(long id);
	
	

}