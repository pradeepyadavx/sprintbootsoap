package com.pradeep.spring.soap.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pradeep.spring.soap.api.loaneligibility.Acknowledgement;
import com.pradeep.spring.soap.api.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityService {
	
	public Acknowledgement checkEligibility(CustomerRequest request) {
		Acknowledgement acknowledgement= new Acknowledgement();
		List<String> mismatchCriteriaList=acknowledgement.getCriteriaMismatch();
		
		if(!(request.getAge()>30 && request.getAge()<=60)) {
			mismatchCriteriaList.add("Person age should in between 30 to 60");
		}
		if(!(request.getYearlyIncome()>200000)) {
			mismatchCriteriaList.add("Minimum income should be more then 20000");
		}
		if(!(request.getCibilScore()>500)) {
			mismatchCriteriaList.add("Low Cibil Score please try after 6 monts");
		}
		
		if(mismatchCriteriaList.size()>0) {
			acknowledgement.setApprovedAmount(0);
			acknowledgement.setIsEligible(false);
		}else {
			acknowledgement.setApprovedAmount(500000);
			acknowledgement.setIsEligible(true);
			mismatchCriteriaList.clear();
		}
		
		return acknowledgement;
	}

}
