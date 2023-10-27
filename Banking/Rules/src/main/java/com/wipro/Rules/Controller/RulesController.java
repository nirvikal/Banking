package com.wipro.Rules.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.Rules.Model.RuleStatus;
import com.wipro.Rules.Service.RulesServiceImpl;

@RestController
@RequestMapping("/rules")
public class RulesController {
	
	@Autowired
	RulesServiceImpl service;
	
	@GetMapping("/evaluateMinBal")
	public RuleStatus evaluateMinBal(@RequestParam(value="balance") Double balance, @RequestParam(value="accountId") Long accountId) {
		return service.evaluateMinBal(balance, accountId);
	}
	
	@GetMapping("/getServiceCharge")
	public Float getServiceCharges() {
		return service.getServiceCharge();
	}

}
