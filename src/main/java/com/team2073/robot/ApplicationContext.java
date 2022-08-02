package com.team2073.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ApplicationContext {
    public static ApplicationContext instance;
    private CANSparkMax motor1;
    private Subsystem subsystem;

    private final MotorType kMotorType = MotorType.kBrushless;

    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    public CANSparkMax getMotor1() {
        if (motor1 == null) {
            motor1 = new CANSparkMax(1, kMotorType);
        }
        return motor1;
    }


    public Subsystem getSubsystem() {
        if (subsystem == null) {
            subsystem = new Subsystem();
        }
        return subsystem;
    }
}
