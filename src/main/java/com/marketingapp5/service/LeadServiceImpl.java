package com.marketingapp5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp5.Repository.Leadrepository;
import com.marketingapp5.entities.Lead;
@Service
public class LeadServiceImpl implements LeadService {
	
	
	
	@Autowired
	private Leadrepository leadRepo;

	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);

	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
	
		return leads;
	}

	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
		
	}

	@Override
	public Lead findLeadById(long id) {
		Optional<Lead>findById=leadRepo.findById(id);
		return findById.get();
	}

}
