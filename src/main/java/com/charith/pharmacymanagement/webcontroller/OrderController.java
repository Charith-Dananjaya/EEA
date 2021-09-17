package com.charith.pharmacymanagement.webcontroller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.charith.pharmacymanagement.entity.Order;
import com.charith.pharmacymanagement.entity.service.OrderService;



@Controller
@RequestMapping()
public class OrderController {
	
	
	private OrderService orderservice;
	
	public OrderController(OrderService orderservice) {
		this.orderservice = orderservice;
	}
	
	
	
	//add mapping for "/list"
			@RequestMapping("/list")
			public String getOrders(Model model) {
				
				//Retrive Orders List from database
				List<Order> theOrders = orderservice.findAllOrders();
				
				//add retrived Orders list into model as an attribute
				model.addAttribute("orders",theOrders);
				
				//return view
				return "orders/order-list";	
				
			}
			
			//add mapping for ("/showFormForAdd")
			@GetMapping("/showFormForAdd")
			public String saveOrder(Model theModel) {
				Order theOrder = new Order();
				theModel.addAttribute("order",theOrder);
				
				return "orders/order-form";
			}
			
			// mapping for showupdate form
			@GetMapping("/showFormForUpdate")
			public String updatePharmacist(@RequestParam("pharmacistid") int theId  , Model theModel) {
				
				
				//get Order from service 
				Order theOrder = orderservice.getOrderById(theId);
				
				// set Order as a model attribute 
				theModel.addAttribute("order" , theOrder);
				
				
				//redirect to update form
				//same form for testing
				return "orders/order-form";
				
			}
			
			@GetMapping("/delete")
			public String deleteEmployee(@RequestParam("pharmacistid") int theId) {
				
				
				//delete supplier
				orderservice.deleteOrder(theId);
				
				//redirect to pharmacist list
				return "redirect:/orders/list";
			}
			
			
			
			
			
			
			//add mapping for ("/save")
			@PostMapping("/save")
			public String saveEmployee(@ModelAttribute("order") Order theOrder) {
				
				orderservice.saveOrder(theOrder);
				
				return "redirect:/pharmacists/list";
				
			}
		

}
