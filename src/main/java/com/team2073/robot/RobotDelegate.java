package com.team2073.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.team2073.common.robot.AbstractRobotDelegate;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Objects;

public class RobotDelegate extends AbstractRobotDelegate {
    Subsystem subsystem;
    SimulationSubsystem simulationSubsystem;
    ApplicationContext appCTX = ApplicationContext.getInstance();
    OperatorInterface oi = new OperatorInterface();

    public RobotDelegate(double period) {
        super(period);
    }
    @Override
    public void robotInit() {
        simulationSubsystem = appCTX.getSimulationSubsystem();
        oi.init();
        appCTX.getMotor1().getEncoder().setPosition(1000);
    }

    @Override
    public void robotPeriodic() {

    }


    public enum AutoRun {
        FIVEBALL,
        FOUR_BALL_A,
        FOURBALL_B,
        CLOSE_SHOT,
        TWOBALL;
    }
}
