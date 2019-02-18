package frc.robot;

public class ImplCamera extends BaseCamera {

    

    @Override
    protected double getLeftX() {
        return Robot.robotTables.leftTargetX();
    }

    @Override
    protected double getRightX() {
        return Robot.robotTables.rightTargetX();
    }

    @Override
    public double getD() {
        return Robot.robotTables.distanceTarget();
    }

    @Override
    protected void initDefaultCommand() {

    }

}