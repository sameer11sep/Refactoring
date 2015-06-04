package com.xebia.xke.state;

/**
 * Created by sameerarora on 6/5/15.
 */
public abstract class TaskState {
    private final String name;

    public static final TaskState TO_DO = new ToDo("TODO");

    public static final TaskState IN_PROGRESS = new InProgress("IN_PROGRESS");

    public static final TaskState IN_TEST = new InTest("IN_TEST");

    public static final TaskState DONE = new Done("DONE");

    public TaskState(String todo) {
        this.name=todo;
    }

    public void assigned(AgileTask task) {
        error();
    }

    public void moveToTest(AgileTask task) {
        error();
    }

    public void reOpen(AgileTask task) {
        error();
    }

    public void done(AgileTask task) {
        error();
    }

    private void error() {
        throw new IllegalStateException("Cannot make the transition from current state");
    }

}
