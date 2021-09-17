package com.charith.pharmacymanagement.webcontroller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.charith.pharmacymanagement.entity.Pharmacist;
import com.charith.pharmacymanagement.entity.service.PharmacistService;

@Controller
@RequestMapping("/pharmacists")
public class PharmacistController {
	
	private PharmacistService pharmacistservice;
	
	//Dependency injection(Constructor)
	public PharmacistController(PharmacistService pharmacistservice) {
		this.pharmacistservice = pharmacistservice;
	}
	
	//add mapping for "/list"
		@RequestMapping("/list")
		public String getPharmacist(Model model) {
			
			//Retrive Pharmacists List from database
			List<Pharmacist> thePharmacists = pharmacistservice.findAllPharmacists();
			
			//add retrived Pharmacists list into model as an attribute
			model.addAttribute("pharmacists",thePharmacists);
			
			//return view
			return "pharmacists/pharmacist-list";	
			
		}
		
		//add mapping for ("/showFormForAdd")
		@GetMapping("/showFormForAdd")
		public String savePharmacist(Model theModel) {
			Pharmacist thePharmacist = new Pharmacist();
			theModel.addAttribute("pharmacist",thePharmacist);
			
			return "pharmacists/pharmacist-form";
		}
		
		// mapping for showupdate form
		@GetMapping("/showFormForUpdate")
		public String updatePharmacist(@RequestParam("pharmacistid") int theId  , Model theModel) {
			
			
			//get pharmacist from service 
			Pharmacist thePharmacist = pharmacistservice.getPharmacistById(theId);
			
			// set pharmacist as a model attribute 
			theModel.addAttribute("pharmacist" , thePharmacist);
			
			
			//redirect to update form
			//same form for testing
			return "pharmacists/pharmacist-form";
			
		}
		
		@GetMapping("/delete")
		public String deleteEmployee(@RequestParam("pharmacistid") int theId) {
			
			
			//delete supplier
			pharmacistservice.deletePharmacist(theId);
			
			//redirect to pharmacist list
			return "redirect:/pharmacists/list";
		}
		
		
		
		
		
		
		//add mapping for ("/save")
		@PostMapping("/save")
		public String saveEmployee(@ModelAttribute("pharmacist") Pharmacist thePharmacist) {
			
			pharmacistservice.savePharmacist(thePharmacist);
			
			return "redirect:/pharmacists/list";
			
		}
	
	
	

}
