package com.xebia.xke.state;

/**
 * Created by sameerarora on 6/5/15.
 */
public class InTest extends TaskState {
    public InTest(String in_test) {
        super(in_test);
    }


    @Override
    public void reOpen(AgileTask task) {
        task.setState(TaskState.IN_PROGRESS);
    }

    @Override
    public void done(AgileTask task) {
        task.setState(TaskState.DONE);
    }
}
