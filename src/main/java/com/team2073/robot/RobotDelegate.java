package com.team2073.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.team2073.common.robot.AbstractRobotDelegate;
import edu.wpi.first.wpilibj.TimedRobot;

public class RobotDelegate extends AbstractRobotDelegate {
    Subsystem subsystem;
    ApplicationContext appCTX = ApplicationContext.getInstance();

    public RobotDelegate(double period) {
        super(period);
    }
    @Override
    public void robotInit() {
        subsystem =  appCTX.getSubsystem();
    }

    @Override
    public void robotPeriodic() {

    }

}
