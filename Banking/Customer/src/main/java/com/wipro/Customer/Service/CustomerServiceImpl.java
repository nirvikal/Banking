package com.wipro.Customer.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.Customer.Model.Customer;
import com.wipro.Customer.Model.CustomerCreationStatus;
import com.wipro.Customer.Repository.CustomerCreationStatusRepository;
import com.wipro.Customer.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository custRepo;
	@Autowired
	CustomerCreationStatusRepository statusRepo;

	@Override
	public CustomerCreationStatus saveCustomerDetails(Customer customer) {
		if(customer.equals(custRepo.save(customer))) 
			return statusRepo.save(new CustomerCreationStatus("Customer Details Created Successfully",customer.getCustomerId()));
		else
			return statusRepo.save(new CustomerCreationStatus("Customer Details Not Created",customer.getCustomerId()));
	}

	@Override
	public Customer getCustomerDetails(Long customerId) {
		Optional<Customer> data = custRepo.findById(customerId);
		if(data.isPresent())
			return data.get();
		else
			return null;
	}

}
