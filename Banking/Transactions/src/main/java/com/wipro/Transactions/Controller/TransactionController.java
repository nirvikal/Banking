package com.wipro.Transactions.Controller;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wipro.Transactions.Model.Account;
import com.wipro.Transactions.Model.RuleStatus;
import com.wipro.Transactions.Model.TransactionStatus;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	public static final String accountUrl="http://localhost:8081/account/";
	public static final String ruleUrl="http://localhost:8082/rules/";
	@PostMapping("/deposit")
	public TransactionStatus deposit(@RequestParam(value="accountId") Long accountId,@RequestParam(value="amount") Double amount) {
		RestTemplate template = new RestTemplate();
		MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();
		map.add("accountId", accountId);
	    map.add("amount", amount);
		TransactionStatus status = template.postForObject(accountUrl+"deposit",map,TransactionStatus.class);
		return status;
	}
	
	
	@PostMapping("/withdraw")
	public TransactionStatus withdraw(@RequestParam(value="accountId") Long accountId,@RequestParam(value="amount") Double amount) {
		String getAccUrl="getAccount?accountId="+accountId;
		TransactionStatus status;
		RestTemplate template = new RestTemplate();
		MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();
		map.add("accountId", accountId);
	    Account account = template.getForObject(accountUrl+getAccUrl,Account.class);
	    Double finalamount = account.getBalance()-amount;
	    map.add("amount",finalamount);
	    String getEvalUrl="evaluateMinBal?balance="+finalamount+"&accountId="+accountId;
	    RuleStatus ruleStatus = template.getForObject(ruleUrl+getEvalUrl,RuleStatus.class);
	    if(ruleStatus.getStatus().equals("Allowed"))
	    	return status = template.postForObject(accountUrl+"withdraw",map, TransactionStatus.class);
	    else
	         return new TransactionStatus(accountId,"Declined",0.0,account.getBalance());
	}
	
	@PostMapping("/transfer")
	public TransactionStatus transfer(@RequestParam(value="sourceAccountId") Long srcAccountId,@RequestParam(value="destinationAccountId") Long dstAccountId,
			@RequestParam(value="amount") Double amount) {
		TransactionStatus source = withdraw(srcAccountId,amount);
		TransactionStatus destination = null;
		if(source.getMessage().equals("Successful")) { 
			destination = deposit(dstAccountId,amount);
			return new TransactionStatus(srcAccountId,"Successful",source.getDestinationBalance(),destination.getDestinationBalance());
		}else
			return new TransactionStatus(srcAccountId,"Declined",source.getDestinationBalance(),00.00);
	}
	
	
//	@GetMapping("/getTransactions")
	

}
