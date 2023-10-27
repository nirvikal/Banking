package com.wipro.Rules.Service;

import org.springframework.stereotype.Service;

import com.wipro.Rules.Model.RuleStatus;

@Service
public class RulesServiceImpl implements RulesService {
	public static final Double minBalance=500.00;
	@Override
	public RuleStatus evaluateMinBal(Double balance, Long accountId) {
		if(balance>=minBalance)
			return new RuleStatus("Allowed");
		else
			return new RuleStatus("Denied");
	}

	@Override
	public Float getServiceCharge() {
		return 25.00F;
	}
	
}
