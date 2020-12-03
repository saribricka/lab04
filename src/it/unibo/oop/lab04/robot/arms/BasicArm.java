package it.unibo.oop.lab04.robot.arms;

public class BasicArm {
	
	private static final double ENERGY_REQUIRED_TO_GRAB = 0.1;
	private static final double ENERGY_REQUIRED_TO_MOVE = 0.2;
	private boolean grab;
	private String armName;

	public BasicArm(String armName) {
		this.armName = armName;
	}
	
	public boolean isGrabbing() {
		return this.grab;
	}
	
	public void pickUp() {
		grab = true;
	}
	
	public void dropDown() {
		grab = false;
	}
	
	public double getConsuptionForPickUp() {
		return ENERGY_REQUIRED_TO_MOVE + ENERGY_REQUIRED_TO_GRAB;
	}
	
	public double getConsuptionForDropDown() {
		return ENERGY_REQUIRED_TO_MOVE;
	}
	
	public String toString() {
		return armName;
	}
	
}
