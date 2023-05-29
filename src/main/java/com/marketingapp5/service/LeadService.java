package com.marketingapp5.service;

import java.util.List;

import com.marketingapp5.entities.Lead;

public interface LeadService {
public void saveLead(Lead lead);
public List<Lead> getAllLeads();
public void deleteLeadById(long id);
public Lead findLeadById(long id);
}
