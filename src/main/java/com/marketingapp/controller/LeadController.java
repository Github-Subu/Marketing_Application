package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadData;
import com.marketingapp.entites.Lead;
import com.marketingapp.services.LeadService;


@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;

	@RequestMapping("/viewLeadPage")
	public String viewCreateLeadPage() {
		return "Create_Lead";
	}

	@RequestMapping(value = "/saveLead", method = RequestMethod.POST)
	public String saveLead(@ModelAttribute("lead") Lead l,ModelMap Model){
		leadService.saveOneLead(l);
		Model.addAttribute("savemessage","record is save...");
		
		return "Create_Lead";

	}
//	@RequestMapping(value = "/saveLead", method = RequestMethod.POST)
	// public String saveLead(LeadData data) {
	// Lead l = new Lead();
	// l.setFirstName(data.getFirstName());
	// l.setLastName(data.getLasttName());
	// l.setEmail(data.getEmail());
	// l.setMobile(data.getEmail());
	// leadService.saveOneLead(l);

	// return "Create_Lead";

//}
	
	@RequestMapping("/listAll")
	public String listOneLeads(ModelMap Model) {
		List<Lead> leads = leadService.listAllLead();
		Model.addAttribute("leads",leads);
		return "Lead_List";
	}
	@RequestMapping("/deleteLead")
	public String deleteLead(@RequestParam("id")long id, ModelMap Model) {
		leadService.deleteOneLead(id);
		List<Lead> leads = leadService.listAllLead();
		Model.addAttribute("leads",leads);
		return "Lead_List";
	}
	@RequestMapping("/getLead")
	public String getLead(@RequestParam("id")long id, ModelMap Model) {
		Lead lead = leadService.getOneLead(id);
		
		Model.addAttribute("lead",lead);
		return "get_Lead";
	
	}
	@RequestMapping("/updateLead")
	public String updateLead(@ModelAttribute("lead") Lead l,ModelMap Model) {
		leadService.saveOneLead(l);
		List<Lead> leads = leadService.listAllLead();
		Model.addAttribute("leads",leads);
		
		return "Lead_List";
	}
	
	
//	@RequestMapping(value = "/saveLead", method = RequestMethod.POST)
//	public String saveLead(@RequestParam("firstName") String fname, @RequestParam("lastName") String lname,  @RequestParam("email") String email,  @RequestParam("mobile") String mobile) {
//		Lead leads = new Lead();
//		leads.setFirstName(fname);
//		leads.setLastName(lname);
//		leads.setEmail(email);
//		leads.setMobile(mobile);
//		leadService.saveOneLead(leads);
//		return "Create_Lead";
//
//	}
		
	
	}

	
