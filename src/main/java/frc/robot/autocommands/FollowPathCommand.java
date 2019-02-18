/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autocommands;

import java.io.File;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

public class FollowPathCommand extends Command {

  private String fileLocation;

  private EncoderFollower leftFollower;
  private EncoderFollower rightFollower;
  public FollowPathCommand(String location) {
    fileLocation = location;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // System.out.println("Running robot init");
    File leftFile = new File("/home/lvuser/deploy/ForwardLeftThenRight.left.pf1.csv");
    File rightFile = new File("/home/lvuser/deploy/ForwardLeftThenRight.right.pf1.csv");
    Trajectory leftTraj = Pathfinder.readFromCSV(rightFile);
    Trajectory rightTraj = Pathfinder.readFromCSV(leftFile);
    // for (int i = 0; i < leftTraj.length(); i++) {
    // System.out.println(leftTraj.get(i).velocity);
    // }
    leftFollower = new EncoderFollower(leftTraj);
    rightFollower = new EncoderFollower(rightTraj);

    // encoder position, 360 ticks/revolution, 0.1524 m = 6 in wheel diameter
    // right encoder is different: 250 ticks/revolution
    leftFollower.configureEncoder((int) leftEncoder.getPosition(), 360, 0.1524);
    rightFollower.configureEncoder((int) rightEncoder.getPosition(), 250, 0.1524);

    leftFollower.configurePIDVA(1, 0, 0.9, 1 / 2.5, 0);
    rightFollower.configurePIDVA(1, 0, 0.9, 1 / 3.2, 0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double leftOutput = leftFollower.calculate((int) leftEncoder.getPosition());
    double rightOutput = rightFollower.calculate((int) rightEncoder.getPosition());

    // double gyro_heading = gyro.getAngle() % 360;
    // double desired_heading = Pathfinder.r2d(leftFollower.getHeading());

    // double angleDifference = Pathfinder.boundHalfDegrees(desired_heading -
    // gyro_heading);
    // double turn = 0.8 * (-1.0/80.0) * angleDifference;
    double turnTraj = 0;
    Robot.driveTrain.tank(leftOutput + turnTraj, rightOutput - turnTraj);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
