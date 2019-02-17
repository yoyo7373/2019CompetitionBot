/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autocommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.HatchArm;


public class LowerArmCommand extends Command {
  public LowerArmCommand() {
    requires(Robot.hatchArm);
  }

  private final double kArmLowerMax = 0.05;
	//private final double kArmLowStall = 0.00;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double angle = Robot.hatchArm.getAngle();
		double out = 0;
		if (angle > (5 + HatchArm.startingAngle)) {
			out = Math.cos(Math.toRadians(angle))* kArmLowerMax;
		}
		if (angle < Math.toRadians(-30))
			out *= 3;
		else if (angle > Math.toRadians(80))
			out -= 0.2;
		else
			out -= 0.1;
		Robot.hatchArm.set(out);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.hatchArm.getAngle() < (5 + HatchArm.startingAngle);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
