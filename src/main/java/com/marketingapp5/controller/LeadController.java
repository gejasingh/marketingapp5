package com.marketingapp5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp5.entities.Lead;
import com.marketingapp5.service.LeadService;
import com.marketingapp5.utility.EmailService;

@Controller
public class LeadController {
@Autowired
 private LeadService leadservice;
	@Autowired
	private EmailService emailService;
	//http://localhost:9090/create
		@RequestMapping("/create")
		public String viewCreateLead() {
			return "create_lead";//this works as request dispatcher here
		}

		@RequestMapping("/saveLead")
		public String saveLead(@ModelAttribute Lead lead,Model model) {
			leadservice.saveLead(lead);
			emailService.sendEmail(lead.getEmail(), "Test", "Welcome");
			model.addAttribute("msg","Record is saved!!");
			return "create_lead";
		}
		//@RequestMapping("/saveLead")
		//public String saveLead(
			//	@RequestParam("firstName")String firstName,
				//@RequestParam("lastName")String lastName,
				//@RequestParam("email")String email,
				//@RequestParam("mobile")Long mobile
				//) {
			//Lead lead=new Lead();
			//lead.setFirstName(firstName);
			//lead.setLastName(lastName);
			//lead.setEmail(email);
			//lead.setMobile(mobile);
			//leadservice.saveLead(lead);
			//return "create_lead";
		//}
	//@RequestMapping("/saveLead")
	//public String saveLead(LeadDto leadDto) {
	//	Lead lead=new Lead();
	//lead.setFirstName(leadDto.getFirstName());	
	//lead.setLastName(leadDto.getLastName());
	//lead.setEmail(leadDto.getEmail());
	//lead.setMobile(leadDto.getMobile());
	//leadservice.saveLead(lead);
	//return "create_lead";
	//}
	
	//http://localhost:9090/listall
	@RequestMapping("/listall")
	public String getAllLeads(Model model) {
		List<Lead> leads = leadservice.getAllLeads();
		model.addAttribute("leads",leads);
	return"search_result";
	}
@RequestMapping("/delete")
public String deleteLeadById(@RequestParam("id") long id,Model model) {
	leadservice.deleteLeadById(id);
	List<Lead> leads = leadservice.getAllLeads();
	model.addAttribute("leads",leads);
	return"search_result";
}

@RequestMapping("/update")
public String getLeadById(@RequestParam("id")long id,Model model) {
	Lead lead=leadservice.findLeadById(id);
	model.addAttribute("lead",lead);
	return"update_lead";
}
@RequestMapping("/updateLead")
public String updateLead(LeadDto dto,Model model) {
	Lead l=new Lead();
	l.setId(dto.getId());
	l.setFirstName(dto.getFirstName());
	l.setLastName(dto.getLastName());
	l.setEmail(dto.getEmail());
	l.setMobile(dto.getMobile());
	leadservice.saveLead(l);
	List<Lead> leads = leadservice.getAllLeads();
	model.addAttribute("leads",leads);
	return"search_result";
}
}
	
	
	
	
		

