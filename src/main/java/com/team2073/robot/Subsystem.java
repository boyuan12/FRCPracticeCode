package com.team2073.robot;

import com.revrobotics.CANSparkMax;
import com.team2073.common.periodic.AsyncPeriodicRunnable;


public class Subsystem implements AsyncPeriodicRunnable {
    ApplicationContext appCTX = ApplicationContext.getInstance();

    public Subsystem() {
        autoRegisterWithPeriodicRunner();
    }

    @Override
    public void onPeriodicAsync() {

    }

}
