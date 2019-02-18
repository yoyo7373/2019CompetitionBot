/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autocommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RaiseCargoArmCommand extends Command {

  // TODO: Tune
	private final double kArmRaiseMax = 0.5;
	private final double kArmUpStall = 0.05;
  private double startTime;
  
  public RaiseCargoArmCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
		requires(Robot.cargoArm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double angle = Robot.cargoArm.getAngle();
		double out = 0;
		// if (angle < 0)
		// out = Math.cos(angle) * kArmRaiseMax;
		// else if (angle > 0 && angle < Math.toRadians(60))
		// out = 0;
		// else if (angle > Math.toRadians(80))
		// out = kArmUpStall;

		out = Math.cos(Math.toRadians(Robot.cargoArm.getAngle()));
		if (Robot.cargoArm.getAngle() > 75) {
			out *= 0.6; // 0.6
			out += 0.1;
		}
		if (Robot.cargoArm.getAngle() > 150)
			out = kArmUpStall;
	  // if (Timer.getFPGATimestamp() < startTime + 0.5)
		//  	out = 0;
		Robot.cargoArm.setCargoArm(out);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
		return Robot.cargoArm.getAngle() > 150;
  } 

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.cargoArm.setCargoArm(0);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
