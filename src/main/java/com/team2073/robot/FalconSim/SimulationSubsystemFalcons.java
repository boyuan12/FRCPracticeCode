package com.team2073.robot.FalconSim;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.team2073.common.controlloop.PidfControlLoop;
import com.team2073.common.periodic.AsyncPeriodicRunnable;
import com.team2073.robot.ApplicationContext;
import com.team2073.robot.FalconSim.PhysicsSim;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class SimulationSubsystemFalcons implements AsyncPeriodicRunnable {

    WPI_TalonFX testFalcon = new WPI_TalonFX(1);

    CANSparkMax testMotor = ApplicationContext.getInstance().getMotor1();
    ShuffleboardTab testingPIDTuningSimulation = Shuffleboard.getTab("Testing PID tuning");
    private NetworkTableEntry p =testingPIDTuningSimulation.add("P",0).getEntry();
    private NetworkTableEntry i =testingPIDTuningSimulation.add("I",0).getEntry();
    private NetworkTableEntry d =testingPIDTuningSimulation.add("D",0).getEntry();
    private NetworkTableEntry goal =testingPIDTuningSimulation.add("Goal",0).getEntry();
    PidfControlLoop simulationPID = new PidfControlLoop(p.getDouble(0),i.getDouble(0),d.getDouble(0),0d,1d);
    TalonFXSensorCollection testEncoder = testFalcon.getSensorCollection();

    int count = 0;
    boolean allowMovement = false;
    public double getPosition(){
        return testMotor.getEncoder().getPosition();
    }

    public SimulationSubsystemFalcons() {
        autoRegisterWithPeriodicRunner();
        simulationPID.setPositionSupplier(() -> testMotor.getEncoder().getPosition());
        testMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
        PhysicsSim.getInstance().addTalonFX(testFalcon, 0.5, 5100);
        testFalcon.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0,0);
        testFalcon.selectProfileSlot(0,0);
        testFalcon.config_kF(0,0,0);
        testFalcon.config_kP(0,0.2, 0);
        testFalcon.config_kI(0, i.getDouble(0),0);
        testFalcon.config_kD(0, d.getDouble(0), 0);
        testFalcon.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 100, 0);
        testFalcon.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 100, 0);
    }



    @Override
    public void onPeriodicAsync() {
        PhysicsSim.getInstance().run();
        count++;
        if (count > 100) {
//            System.out.println(testMotor.getEncoder().getPosition());
            count = 0;
            System.out.println(goal.getDouble(0));
        }
//        testMotor.getEncoder().setPosition(1000);
        testFalcon.set(ControlMode.MotionMagic, 2000);
//        testMotor.set(1);
        if (allowMovement) {
//            setPID();
//            testMotor.set(simulationPID.getOutput());
            testFalcon.set(ControlMode.MotionMagic, 2000);
        }
    }

    public void setPID() {
        simulationPID.updatePID();
    }

    public void updateGoal() {
//        simulationPID.updateSetPoint(goal.getDouble(0));
//        simulationPID.updateSetPoint(1000);
    }

    public void setAllowMovement(boolean allowMovement) {
        this.allowMovement = allowMovement;
    }

    public void setOutput(double output) {
        testMotor.set(output);
    }


}
