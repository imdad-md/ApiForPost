package com.jpacheck;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LeadController {

	@Autowired
	private LeadService leadService;

	// http://localhost:8080/view

	@RequestMapping("/view")
	public String viewLead() {

		
		return "viewlead";

	}

	

	//saving the lead
	
	// http://localhost:8080/savelead
	@PostMapping("/post")
	public void saveLead(@RequestBody Lead lead) {

		leadService.saveLeads(lead);
//		System.out.println(lead.getFirstName());
//		System.out.println(lead.getLastName());
//		model.addAttribute("saved", lead);

//		return "done";
	}

	
	//fetching all the leads
	
	//http://localhost:8080/get
	
	@GetMapping("/get")
	public List<Lead> getData(Lead lead) {

		List<Lead> allLeads = leadService.getAllLeads(lead);

//		model.addAttribute("datas", allLeads);

		return allLeads;

	}
	
	
	
//deleting all the leads
	@DeleteMapping("/delete")
	public void deleteLeads(Lead lead) {

		leadService.deleteAllLeads(lead);

	}
	
	
	//deleting the lead by id
	
	@DeleteMapping("deleteone/{id}")
	public void deleteOneLead(@PathVariable("id") int ids, Lead lead ) {
		
		
		leadService.deleteOneLead(ids);
		
		
	}
	
	//updating the lead by id

	@PutMapping("/update/{id}")
	public void updateData(@PathVariable("id") int id, @RequestBody Lead lead) {

		leadService.updateById(id,lead);

	}

}
