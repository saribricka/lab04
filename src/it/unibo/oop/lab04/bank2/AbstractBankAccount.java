package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;
import it.unibo.oop.lab04.bank.SimpleBankAccount;

public abstract class AbstractBankAccount implements BankAccount{
	
	private double amount;
	private int nTransaction;
	private int usrID;
	
	public AbstractBankAccount(int usrID, double amount) {
		this.amount = amount;
		this.nTransaction = 0;
		this.usrID = usrID;
	}
	
	public void computeManagementFees(int usrID) {
		final double fee = computeFee();
		if (userValid(usrID) && isWithDrawAllowed(usrID)) {
			amount -= fee;
			resetTrans();
		}
	}

	protected void resetTrans() {
		this.nTransaction = 0;
	}

	public void deposit(int usrID, double amount) {
		transOperation(usrID, amount);
	}

	protected void transOperation(final int usrID, final double amount) {
		if (userValid(usrID)) {
			this.amount += amount;
			this.incTrans();
		}
	}

	private void incTrans() {
		this.nTransaction++;
	}

	private boolean userValid(int id){
		return this.usrID == id;
	}

	public void depositFromATM(int usrID, double amount) {
		this.deposit(usrID, amount - SimpleBankAccount.ATM_TRANSACTION_FEE);
	}

	public double getBalance() {
		return this.amount;
	}

	public int getNTransactions() {
		return this.nTransaction;
	}

	public void withdraw(int usrID, double amount) {
		if (isWithDrawAllowed(amount)) {
			this.transOperation(usrID, -amount);
		}
	}

	public void withdrawFromATM(int usrID, double amount) {
		this.withdraw(usrID, amount + SimpleBankAccount.ATM_TRANSACTION_FEE);
	}

	protected abstract boolean isWithDrawAllowed(double amount);
	
	protected abstract double computeFee();
	
	
}