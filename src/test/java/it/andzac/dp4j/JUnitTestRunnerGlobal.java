package it.andzac.dp4j;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JUnitTestRunnerGlobal {
  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(JUnitTestSuiteGlobal.class);

    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }

    System.out.println("[RESULT TEST]:" + result.wasSuccessful());
  }
}
