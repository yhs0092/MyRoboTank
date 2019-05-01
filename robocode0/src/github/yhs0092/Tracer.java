package github.yhs0092;

import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 * Detect and trace
 */
public class Tracer extends Robot {

  public static final int MAC_RADAR_ROTATION_DEGREES = 45;

  public static final int MAX_EXPECT_DISTANCE = 200;

  @Override
  public void run() {
    while (true) {
      turnRadarLeft(MAC_RADAR_ROTATION_DEGREES);
    }
  }

  @Override
  public void onScannedRobot(ScannedRobotEvent event) {
    if (event.getDistance() > MAX_EXPECT_DISTANCE) {
      turnRight(event.getBearing());
      ahead(event.getDistance() - MAX_EXPECT_DISTANCE);
    }
  }
}
