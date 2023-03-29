package com.aspire.customer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aspire.customer.model.Customer;
import com.aspire.customer.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService service;

	@GetMapping("/list")
	public String customer() {
		return "customer";
	}

//	@GetMapping("/")
//	public String home(Model model) {
//		List<Customer> pelanggan = service.listAll();
//		model.addAttribute("customers", pelanggan);
//		return "display";
//	}
//	
//	@GetMapping("/display")
//	public String display(Model model) {
//		List<Customer> pelanggan = service.listAll();
//		model.addAttribute("customers", pelanggan);
//		return "display";
//	}
//	
//	@GetMapping("/new")
//	public String newCustForm(Map<String, Object> model) {
//		model.put("customer", new Customer());
//		return "insert-form";
//	}
//	
//	@PostMapping("/save")
//	public String saveCust(@ModelAttribute("customer") Customer customer) {
//		service.save(customer);
//		return "redirect:/display";
//	}
//	
//	@GetMapping("/edit/{id}")
//	public String editCust(@PathVariable (value = "id") int id, Model model) {
//		Customer customer = service.get(id);
//		model.addAttribute("customer", customer);
//		return "update-form";
//	}
//	
//	@GetMapping("/delete/{id}")
//	public String delete(@PathVariable (value = "id") int id) {
//		this.service.delete(id);
//		return "redirect:/display";
//	}
//	
//	@GetMapping("/search")
//	public String search(@RequestParam String keyword, Model model) {
//		List<Customer> result = service.search(keyword);
//		model.addAttribute("result", result);
//		return "search";
//	}
//	
//	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, @RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model) {
//		int pageSize = 5;
//		
////		Page<Customer> page = service
//		
//		return "display";
//	}
}
