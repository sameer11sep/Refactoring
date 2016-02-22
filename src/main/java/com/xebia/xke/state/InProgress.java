package com.xebia.xke.state;
//This has been added at the place where code already existed
public class InProgress extends TaskState {
  public InProgress(String in_progress) {
    super(in_progress);
  }

  @Override
  public void assigned(AgileTask task) {
    //sets the state to in progress
    //also adding another line to see if ranges work
    //another for the above check
    task.setState(TaskState.IN_PROGRESS);
  }

  @Override
  public void moveToTest(AgileTask task) {
    task.setState(TaskState.IN_TEST);
  }
}
