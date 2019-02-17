/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Climb extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private double gearBoxReduction = 1;

  private Encoder climbEncoder = new Encoder(RobotMap.CLIMB_ENCODER_A, RobotMap.CLIMB_ENCODER_B);


  public Climb() {
    climbEncoder.setMaxPeriod(.1);
    climbEncoder.setMinRate(10);
    climbEncoder.setDistancePerPulse(1 / 4096 * gearBoxReduction * 360.0 );
    climbEncoder.setSamplesToAverage(7);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setClimbMotor(double speed) {
    //climbMotor.set(speed);
  }

  public double getAngle() {
    return climbEncoder.getDistance();
  }
}
