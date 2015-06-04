package com.xebia.xke.state;

/**
 * Created by sameerarora on 6/5/15.
 */
public class InProgress extends TaskState {
    public InProgress(String in_progress) {
        super(in_progress);
    }

    @Override
    public void assigned(AgileTask task) {
        task.setState(TaskState.IN_PROGRESS);
    }

    @Override
    public void moveToTest(AgileTask task) {
        task.setState(TaskState.IN_TEST);
    }

}
