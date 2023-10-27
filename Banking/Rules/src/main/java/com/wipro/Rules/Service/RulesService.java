package com.wipro.Rules.Service;


import com.wipro.Rules.Model.RuleStatus;

public interface RulesService {
	public RuleStatus evaluateMinBal(Double balance,Long accountId);
	public Float getServiceCharge();
}
