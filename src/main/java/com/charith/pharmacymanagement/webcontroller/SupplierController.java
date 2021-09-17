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

import com.charith.pharmacymanagement.entity.Supplier;
import com.charith.pharmacymanagement.entity.service.SupplierService;


@Controller
@RequestMapping("/suppliers")
public class SupplierController {
	
	
	
	private SupplierService supplierservice;
	
	//Dependency injection(constructor)
	@Autowired
	public SupplierController(SupplierService supplierservice) {
		this.supplierservice = supplierservice;
	}
	
	
	/*
	//expose ("/getallsuppliers");
	@GetMapping("/getallsuppliers")
	public List<Supplier> getAll(){		
		return supplierservice.getAllSuppliers();
	}
	
	//expose ("/getsupplier/{id}");
	@GetMapping("/getsupplier/{id}")
	public Supplier getById(@PathVariable int id) {
		return supplierservice.getSupplierById(id);
	}
	
	
	//expose ("/deletesupplier/{id}");
	@DeleteMapping("/deletesupplier/{id}")
	public void deleteById(@PathVariable int id) {
		supplierservice.deleteSupplier(id);
	}
	
	//expose ("/savesupplier")
	
	@PostMapping("/savesupplier")
	public void saveSupplier(@RequestBody Supplier theSupplier) {
		
		theSupplier.setId(0);
		supplierservice.saveSupplier(theSupplier);
		
		
	}
	
	
	//expose ("updatesupplier")
	@PutMapping("/updatesupplier")
	public void updateSupplier(@RequestBody Supplier updatedSupplier) {

		supplierservice.saveSupplier(updatedSupplier);
		
	}
	*/

	
	
	
	//add mapping for "/list"
	@RequestMapping("/list")
	public String getSuppliers(Model model) {
		
		//Retrive Supplier List from database
		List<Supplier> theSuppliers = supplierservice.findAllSuppliers();
		
		//add retrived employee list into model as an attribute
		model.addAttribute("suppliers",theSuppliers);
		
		//return view
		return "suppliers/supplier-list";	
		
	}
	
	//add mapping for ("/showFormForAdd")
	@GetMapping("/showFormForAdd")
	public String saveSupplier(Model theModel) {
		Supplier theSupplier = new Supplier();
		theModel.addAttribute("supplier",theSupplier);
		
		return "suppliers/supplier-form";
	}
	
	// mapping for showupdate form
	
	
	@GetMapping("/showFormForUpdate")
	public String updateEmployee(@RequestParam("supplierid") int theId  , Model theModel) {
		
		
		//get supplier from service 
		Supplier theSupplier = supplierservice.getSupplierById(theId);
		
		// set supplier as a model attribute 
		theModel.addAttribute("supplier" , theSupplier);
		
		
		//redirect to update form
		//same form for testing
		return "suppliers/supplier-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("supplierid") int theId) {
		
		
		//delete supplier
		supplierservice.deleteSupplier(theId);
		
		//redirect to supplier list
		return "redirect:/suppliers/list";
	}
	
	
	
	
	
	
	//add mapping for ("/save")
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Supplier theSupplier) {
		
		supplierservice.saveSupplier(theSupplier);
		
		return "redirect:/suppliers/list";
		
	}
	

}
