package com.charith.pharmacymanagement.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.charith.pharmacymanagement.entity.Medicine;
import com.charith.pharmacymanagement.entity.service.MedicineService;

@Controller
@RequestMapping("/medicine")
public class MedicineController {
	
	
	private MedicineService medicineservice;
	
	//Dependency injection(Constructor)
	@Autowired
	public MedicineController(MedicineService medicineservice) {
		this.medicineservice = medicineservice;
	}
	
	//add mapping for "/list"
			@RequestMapping("/list")
			public String getMedicine(Model model) {
				
				//Retrive Medicine List from database
				List<Medicine> theMedicine = medicineservice.findAllMedicine();
				
				//add retrived Medicine list into model as an attribute
				model.addAttribute("medicine",theMedicine);
				
				//return view
				return "medicine/medicine-list";	
				
			}
			
			//add mapping for ("/showFormForAdd")
			@GetMapping("/showFormForAdd")
			public String saveMedicine(Model theModel) {
				Medicine theMed = new Medicine();
				theModel.addAttribute("med",theMed);
				
				return "medicine/medicine-form";
			}
			
			// mapping for showupdate form
			@GetMapping("/showFormForUpdate")
			public String updatePharmacist(@RequestParam("medicineid") int theId  , Model theModel) {
				
				
				//get Medicine from service 
				Medicine theMed = medicineservice.getMedicineById(theId);
				
				// set med as a model attribute 
				theModel.addAttribute("med" , theMed);
				
				
				//redirect to update form
				//same form for testing
				return "medicine/medicine-form";
				
			}
			
			@GetMapping("/delete")
			public String deleteEmployee(@RequestParam("medicineid") int theId) {
				
				
				//delete medicine
				medicineservice.deleteMedicine(theId);
				
				//redirect to pharmacist list
				return "redirect:/medicine/list";
			}
			
	
			//add mapping for ("/save")
			@PostMapping("/save")
			public String saveEmployee(@ModelAttribute("medicine") Medicine theMedicine) {
				
				medicineservice.saveMedicine(theMedicine);
				
				return "redirect:/medicine/list";
				
			}
		
	
	
	
	
	

}
