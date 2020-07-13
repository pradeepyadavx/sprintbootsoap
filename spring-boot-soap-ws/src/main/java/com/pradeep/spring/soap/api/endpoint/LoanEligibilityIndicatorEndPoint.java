package com.pradeep.spring.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.pradeep.spring.soap.api.loaneligibility.Acknowledgement;
import com.pradeep.spring.soap.api.loaneligibility.CustomerRequest;
import com.pradeep.spring.soap.api.service.LoanEligibilityService;


@Endpoint
public class LoanEligibilityIndicatorEndPoint {
	
	private static final String NAMESPACE="http://www.pradeep.com/spring/soap/api/loanEligibility";
	
	@Autowired
	private LoanEligibilityService loanEligibilityService;
	
	@PayloadRoot(namespace = NAMESPACE,localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return loanEligibilityService.checkEligibility(request);
	}

}
