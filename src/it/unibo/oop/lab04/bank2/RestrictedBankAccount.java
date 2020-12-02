package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.SimpleBankAccount;

public class RestrictedBankAccount extends AbstractBankAccount{
	//same behavior of StrictBankAccount
	
	protected RestrictedBankAccount(final int usrID, final double amount) {
		super(usrID, amount);
	}
	
	protected double computeFee() {
		return SimpleBankAccount.MANAGEMENT_FEE;
	}
	
	@Override
	protected boolean isWithDrawAllowed(double amount) {
		return getBalance() > amount;
	}
}
