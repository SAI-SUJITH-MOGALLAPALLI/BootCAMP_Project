package com.wipro.bank.service;

import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.BankValidationException;

public class BankService {
	public static boolean validateData(float principal, int tenure, int age, String gender) throws BankValidationException {
		try {
		if((principal<500)||(tenure!=5||tenure!=10)||(gender.equalsIgnoreCase("Male")||gender.equalsIgnoreCase("Female"))||(age<1||age>100))
			throw new BankValidationException();
		else
		return true;
		}
		catch(BankValidationException ex){
			return false;
		}
	}
	public void calculate(float principal,int tenure, int age, String gender) throws BankValidationException {
		boolean validateFlag = validateData(principal, tenure, age, gender);
		System.out.println("Validate Flag is " + validateFlag);
		System.out.println(principal);
		System.out.println(tenure);
		System.out.println(age);
		System.out.println(gender);
		if(validateFlag){
		//Create RDAccount object
		RDAccount rda = new RDAccount(tenure, principal);
		rda.setInterest(age, gender);

		float maturityInterest = rda.calculateInterest();
		float totalPrincipleDeposited= rda.calculateAmountDeposited();
		System.out.println(totalPrincipleDeposited);
		System.out.println(maturityInterest);
		System.out.println(rda.calculateMaturityAmount(totalPrincipleDeposited, maturityInterest));

		}


	}
}
