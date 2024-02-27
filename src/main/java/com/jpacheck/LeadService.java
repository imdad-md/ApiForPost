package com.jpacheck;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LeadService {

	@Autowired
	private LeadRepository leadRepository;

//saving the lead
	public void saveLeads(Lead lead) {

		leadRepository.save(lead);

	}

	// fetching all the leads

	public List<Lead> getAllLeads(Lead lead) {

		List<Lead> list = leadRepository.findAll();

//		for (Lead found : list) {
//
//			System.out.println(found);
//
//		}

		return list;

	}
	
	//deleting all the lead

	public void deleteAllLeads(Lead lead) {

		leadRepository.deleteAll();
	}

	
	public void deleteOneLead(int ids) {
		
		leadRepository.deleteById(ids);
		
		}
	
	
	//updating the lead by id
	public Lead updateById(int id,Lead lead)  {

		Lead leads = leadRepository.findById(id).get();
		
		leads.setId(id);
		
		

		leadRepository.save(leads);
		
		return leads;

	}

}
