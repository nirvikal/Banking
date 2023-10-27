package com.wipro.Customer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wipro.Customer.Model.AccountCreationStatus;
import com.wipro.Customer.Model.Customer;
import com.wipro.Customer.Model.CustomerCreationStatus;
import com.wipro.Customer.Service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	String accountUrl="http://localhost:8081/account";
	@Autowired
	CustomerServiceImpl custService;
	
	@PostMapping("/createCustomer")
	public CustomerCreationStatus saveCustomerDetails(@RequestBody Customer customer) {
		RestTemplate template = new RestTemplate();
		CustomerCreationStatus custStatus = custService.saveCustomerDetails(customer);
		AccountCreationStatus accStatus = template.postForObject(accountUrl+"/createAccount",custStatus.getCustomerId(),AccountCreationStatus.class );
		return accStatus!=null?custStatus:null;
	}
	
	@GetMapping("/getCustomerDetails")
	public Customer getCustomerDetails(@RequestParam(value="customerId") Long customerId) {
		return custService.getCustomerDetails(customerId);
	}

}
