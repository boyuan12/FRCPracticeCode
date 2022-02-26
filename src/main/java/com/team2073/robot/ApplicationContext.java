package com.team2073.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;

public class ApplicationContext {
    public static ApplicationContext instance;
    private CANSparkMax motor1;
    private CANSparkMax motor2;
    private Subsystem subsystem;
    private DigitalInput dI;
    private DigitalInput dI2;
    private final MotorType kMotorType = MotorType.kBrushless;



    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    public DigitalInput getdI() {
        if (dI == null) {
            dI = new DigitalInput(9);
        }
        return dI;
    }

    public DigitalInput getdI2() {
        if (dI2 == null) {
            dI2 = new DigitalInput(8);
        }
        return dI2;
    }

    public CANSparkMax getMotor1() {
        if (motor1 == null) {
            motor1 = new CANSparkMax(1, kMotorType);
        }
        return motor1;
    }

    public CANSparkMax getMotor2() {
        if (motor2 == null) {
            motor2 = new CANSparkMax(2, kMotorType);
        }
        return motor2;
    }

    public Subsystem getSubsystem() {
        if (subsystem == null) {
            subsystem = new Subsystem();
        }
        return subsystem;
    }
}
