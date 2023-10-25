package com.wipro.Customer.Service;


import com.wipro.Customer.Model.Customer;
import com.wipro.Customer.Model.CustomerCreationStatus;

public interface CustomerService {
	public CustomerCreationStatus saveCustomerDetails(Customer customer);
	public Customer getCustomerDetails(Long customerId);
}
