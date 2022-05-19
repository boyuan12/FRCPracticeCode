package com.team2073.robot;

import com.team2073.robot.FalconSim.SimulationCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OperatorInterface {

    public Joystick keyboard = new Joystick(0);
    public JoystickButton simulationButton = new JoystickButton(keyboard, 1);

    public void init() {
        simulationButton.toggleWhenPressed(new SimulationCommand());
    }
}
