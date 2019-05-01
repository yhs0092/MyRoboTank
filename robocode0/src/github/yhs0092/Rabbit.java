package github.yhs0092;

import robocode.HitWallEvent;
import robocode.Robot;
import robocode.Rules;
import robocode.ScannedRobotEvent;

/**
 * Detect and walk around
 */
public class Rabbit extends Robot {

  public final double MAX_RADIUS = 150;

  public final double MIN_RADIUS = 50;

  private boolean moveAhead = true;

  private double turnRate = 2;

  private double stepDistance = 50;

  @Override
  public void run() {
    while (true) {
      turnRadarRight(Rules.RADAR_TURN_RATE);
    }
  }

  @Override
  public void onScannedRobot(ScannedRobotEvent event) {
    stepDistance = event.getDistance() / turnRate;
    double targetRadians = Math.acos(stepDistance / 2 / event.getDistance());
    double turnRadians = event.getBearingRadians() - targetRadians;
    moveAround(Math.toDegrees(turnRadians));
    scan();
  }

  @Override
  public void onHitWall(HitWallEvent event) {
    reverseDirection();
  }

  private void reverseDirection() {
    moveAhead = !moveAhead;
  }

  private void moveAround(double turnAroundDegree) {
    if (moveAhead) {
      turnRight(turnAroundDegree);
      ahead(stepDistance);
    } else {
      turnLeft(turnAroundDegree);
      back(stepDistance);
    }
  }
}
