package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {

	private BasicArm leftArm = new BasicArm("left");
	private BasicArm rightArm = new BasicArm("right");
	private boolean grab;
	private String robotName;
	
	public RobotWithTwoArms(String robotName) {
		super(robotName);
	}
	
	public boolean dropDown() {
		if (leftArm.isGrabbing()) {
			doRelease(leftArm);
		}else if (rightArm.isGrabbing()) {
			doRelease(rightArm);
		}
		return false;
	}
	
	private void doRelease(BasicArm arm) {
		if(isBatteryEnough(arm.getConsuptionForDropDown()) && arm.isGrabbing()) {
			this.log(arm + "is releasing");
			arm.dropDown();
			this.consumeBattery(arm.getConsuptionForDropDown());
		} else {
			log(arm + "did not release, battery level = " + this.getBatteryLevel());
		}
	}
	
	public boolean pickUp() {
		if (leftArm.isGrabbing()) {
			return false;
		}else if (rightArm.isGrabbing()) {
			return false;
		}else {
			doPick(leftArm);
			doPick(rightArm);
		}
		return true;
	}
	
	public void doPick(BasicArm arm) {
		if(isBatteryEnough(arm.getConsuptionForPickUp()) && !arm.isGrabbing()) {
			this.log(arm + "is releasing");
			arm.pickUp();
			this.consumeBattery(arm.getConsuptionForPickUp());
		} else {
			log(arm + "did not pick, battery level = " + this.getBatteryLevel());
		}
	
		
	}

	@Override
	public int getCarriedItemsCount() {
		return (leftArm.isGrabbing() ? 1 : 0) + (rightArm.isGrabbing() ? 1 : 0);
	}

}
