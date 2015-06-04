package com.xebia.xke.state;

/**
 * Created by sameerarora on 6/5/15.
 */
public class Done extends TaskState {
    public Done(String done) {
        super(done);
    }

    @Override
    public void reOpen(AgileTask task) {
        task.setState(TaskState.TO_DO);
    }

}
