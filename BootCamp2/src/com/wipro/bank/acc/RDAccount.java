package com.wipro.bank.acc;

public class RDAccount extends Account{

	public RDAccount(int tenure, float principal) {
		this.tenure=tenure;
		this.principal=principal;
	}
	@Override
	public float calculateInterest() {
		// TODO Auto-generated method stub
		return (principal*tenure*12);
	}

	@Override
	public float calculateAmountDeposited() {
		// TODO Auto-generated method stub
		float p=principal;
		float r=rateOfInterest/100;
		float n=4f;
		float nt=12*tenure;
		float sum=0;
		for(int i=0;i<(nt);i++) {
			sum=sum+(p*(float)Math.pow(1+(r/n), n*(((nt)-i)/12f))-1);
		}
		return sum;
	}
	
}
