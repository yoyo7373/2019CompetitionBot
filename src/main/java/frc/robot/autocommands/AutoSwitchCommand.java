/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoSwitchCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  private String autoMovement = "dummy value";
  private int startPosition = 1;

  public AutoSwitchCommand() {

    switch(autoMovement){
      case "":
      return;

      case "rightFront":
      addSequential(new FollowPathCommand(autoMovement + startPosition));
      addSequential(new DriveToTargetCommand());
      addSequential(new PlaceHatchCommand());

      return;

      case "rightClose":
      addSequential(new FollowPathCommand(autoMovement + startPosition));
      addSequential(new DriveToTargetCommand());
      addSequential(new PlaceHatchCommand());
      return;

      case "rightMid":
      addSequential(new FollowPathCommand(autoMovement + startPosition));
      addSequential(new DriveToTargetCommand());
      addSequential(new PlaceHatchCommand());
      return;

      case "rightFar":
      addSequential(new FollowPathCommand(autoMovement + startPosition));
      addSequential(new DriveToTargetCommand());
      addSequential(new PlaceHatchCommand());
      return;

      case "leftFront":
      addSequential(new FollowPathCommand(autoMovement + startPosition));
      addSequential(new DriveToTargetCommand());
      addSequential(new PlaceHatchCommand());
      return;

      case "leftClose":
      addSequential(new FollowPathCommand(autoMovement + startPosition));
      addSequential(new DriveToTargetCommand());
      addSequential(new PlaceHatchCommand());
      return;

      case "leftMid":
      addSequential(new FollowPathCommand(autoMovement + startPosition));
      addSequential(new DriveToTargetCommand());
      addSequential(new PlaceHatchCommand());
      return;

      case "leftFar":
      addSequential(new FollowPathCommand(autoMovement + startPosition));
      addSequential(new DriveToTargetCommand());
      addSequential(new PlaceHatchCommand());
      return;

    }



   
  }
}