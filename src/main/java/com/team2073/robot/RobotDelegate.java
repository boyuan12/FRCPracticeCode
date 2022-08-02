package com.team2073.robot;

import com.team2073.common.robot.AbstractRobotDelegate;

public class RobotDelegate extends AbstractRobotDelegate {
    Subsystem subsystem;
    ApplicationContext appCTX = ApplicationContext.getInstance();
    OperatorInterface oi = new OperatorInterface();

    public RobotDelegate(double period) {
        super(period);
    }
    @Override
    public void robotInit() {
        oi.init();
    }

    @Override
    public void robotPeriodic() {

    }

}
