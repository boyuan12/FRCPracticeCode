package com.team2073.robot;

import com.team2073.common.command.AbstractLoggingCommand;

public class SimulationCommand extends AbstractLoggingCommand {
    @Override
    protected boolean isFinishedDelegate() {
        return false;
    }

//    @Override
//    protected void executeDelegate() {
//        ApplicationContext.getInstance().getSimulationSubsystem().updateGoal();
//        ApplicationContext.getInstance().getSimulationSubsystem().setAllowMovement(true);
//        System.out.println("starting");
//    }

    @Override
    protected void initializeDelegate() {
//        ApplicationContext.getInstance().getSimulationSubsystem().updateGoal();
//        ApplicationContext.getInstance().getSimulationSubsystem().setAllowMovement(true);
        System.out.println("starting");
        ApplicationContext.getInstance().getSimulationSubsystem().setOutput(0.5);
    }


    @Override
    protected void endDelegate() {
        ApplicationContext.getInstance().getSimulationSubsystem().setAllowMovement(false);
        System.out.println("ending");
        ApplicationContext.getInstance().getSimulationSubsystem().setOutput(0);
    }
}
