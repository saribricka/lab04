package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.SimpleBankAccount;

public class ClassicBankAccount extends AbstractBankAccount{
	//same behavior of SimpleBankAccount
	
	protected ClassicBankAccount(final int usrID, final double amount) {
		super(usrID, amount);
	}
	
	protected double computeFee() {
		return SimpleBankAccount.MANAGEMENT_FEE;
	}
	
	protected boolean isWithDrawAllowed(final double amount) {
		return true;
	}
}
