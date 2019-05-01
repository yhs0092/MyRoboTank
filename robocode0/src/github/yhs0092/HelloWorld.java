package github.yhs0092;

import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;

public class HelloWorld extends Robot {

  public static final int MAX_GUN_ROTATION_DEGREE = 20;

  private double traceDegree = MAX_GUN_ROTATION_DEGREE;

  @Override
  public void run() {
    setAdjustRadarForGunTurn(false);
    setAdjustGunForRobotTurn(true);
    while (true) {
      if (traceDegree >= 0) {
        turnGunRight(MAX_GUN_ROTATION_DEGREE);
      } else {
        turnGunLeft(MAX_GUN_ROTATION_DEGREE);
      }
    }
  }

  @Override
  public void onScannedRobot(ScannedRobotEvent event) {
    traceDegree = Utils.normalRelativeAngleDegrees(event.getBearing() - getGunHeading() + getHeading());
    turnGunRight(traceDegree);
    if (getGunHeat() <= 0) {
      fire(3);
    }
    if (Utils.isNear(traceDegree, 0)) {
      scan();
    }
  }
}
