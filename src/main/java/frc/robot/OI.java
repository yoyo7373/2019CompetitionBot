package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.buttons.*;

import frc.robot.subsystems.*;
import frc.robot.*;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public final Joystick driveStick;
    public final Joystick operatorStick;

    private Button autoAlignButton;
    private Button shootOutButton;
    private Button shootInButton;

    public OI() {

        this.driveStick = new Joystick(0);
        this.operatorStick = new Joystick(1);

        this.autoAlignButton = new JoystickButton(driveStick, RobotMap.AUTOALIGNBUTTON);
        this.autoAlignButton.whenPressed(new AutoAlignCommand());

        this.shootOutButton = new JoystickButton(operatorStick, RobotMap.SHOOT_IN_BUTTON);
        this.shootInButton = new JoystickButton(operatorStick, RobotMap.SHOOT_OUT_BUTTON);

      }

      // Drive Stick
    public double getDriveX() {
        return driveStick.getX();
    }

    public double getDriveY() {
        return driveStick.getY();
    }

    public double getDriveZ() {
        return driveStick.getZ();
    }
    public double getDriveThrottle() {
        return driveStick.getThrottle();
    }
    public boolean isDriveButtonDown(int buttonNumber) {
        return driveStick.getRawButton(buttonNumber);
    }
    
    public double getOperatorX() {
        return operatorStick.getX();
    }
    public double getOperatorY() {
        return operatorStick.getY();
    }
    public double getOperatorZ() {
        return operatorStick.getZ();
    }
    public double getOperatorThrottle() {
        return operatorStick.getThrottle();
    }
    public boolean isOperatorButtonDown(int buttonNumber) {
        return operatorStick.getRawButton(buttonNumber);
    }
    public int getOperatorPOV() {
        return operatorStick.getPOV();
    }
}
