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
public class CargoArm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private double gearBoxReduction = 1;

  private CANSparkMax cargoArm = new CANSparkMax(RobotMap.ARM_CARGO, MotorType.kBrushed);
  private CANSparkMax shoot = new CANSparkMax(RobotMap.SHOOT, MotorType.kBrushed);

  private Encoder cargoArmEncoder = new Encoder(RobotMap.CARGO_ENCODER_A, RobotMap.CARGO_ENCODER_B);

  public CargoArm() {
    cargoArmEncoder.setMaxPeriod(.1);
    cargoArmEncoder.setMinRate(10);
    cargoArmEncoder.setDistancePerPulse(1 / 4096 * gearBoxReduction * 360.0 );
    cargoArmEncoder.setSamplesToAverage(7);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setCargoArm(double speed) {
    cargoArm.set(speed);
  }

  public void getAngle() {
    cargoArmEncoder.getDistance();
  }

  public void shootOut() {
    shoot.set(0.7);
  }

  public void stopShoot() {
    shoot.set(0);
  }

  public void shootIn() {
    shoot.set(-0.7);
  }
}
