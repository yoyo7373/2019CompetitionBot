/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HatchArm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private double gearBoxReduction = 1;
  private double coefficient = (360 * gearBoxReduction / 4096);
  public static double startingAngle = 90; //is it a problem if i have two public variables with the same name java is a bad language?

  private WPI_TalonSRX hatchArm = new WPI_TalonSRX(RobotMap.ARM_HATCH); 
  
  private DoubleSolenoid hatchLimb = new DoubleSolenoid(RobotMap.LIMB_SOLENOID_CHANNEL_IN, RobotMap.LIMB_SOLENOID_CHANNEL_OUT); 
  private DoubleSolenoid hatchRelease = new DoubleSolenoid(RobotMap.HATCH_SOLENDOID_CHANNEL_IN, RobotMap.HATCH_SOLENOID_CHANNEL_OUT);



  public HatchArm() {

    hatchArm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0); 
    hatchArm.configSelectedFeedbackCoefficient(coefficient);
    hatchArm.setSensorPhase(false); //????
    hatchArm.setSelectedSensorPosition(0, 0, 0);
 
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void set(double value) { // changed this from "setHatchArm" for clarity and ease of reading
    hatchArm.set(value);
  }

  //TODO get actual angle
  public double getAngle() {
    return hatchArm.getSelectedSensorPosition() + startingAngle;
  }

  public void forwardRelease() {
    hatchRelease.set(DoubleSolenoid.Value.kForward);
  }

  public void reverseRelease() {
    hatchRelease.set(DoubleSolenoid.Value.kReverse);
  }

  public void stopRelease() {
    hatchRelease.set(DoubleSolenoid.Value.kOff);
  }

  public void forwardLimb() {
    hatchLimb.set(DoubleSolenoid.Value.kForward);
  }

  public void reverseLimb() {
    hatchLimb.set(DoubleSolenoid.Value.kReverse);
  }

  public void stopLimb() {
    hatchLimb.set(DoubleSolenoid.Value.kOff);
  }
}
