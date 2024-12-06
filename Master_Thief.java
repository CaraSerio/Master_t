package Diogo_Lindo;
import robocode.*;
import java.awt.Color;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;


import java.awt.*;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Nabucodonosor - a robot by (your name here)
 */
public class Nabucodonosor extends AdvancedRobot
{
   /*
	 * run: Master_Thief's default behavior
	 */
int roboDetectado = 0;
   
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		 setColors(Color.black,Color.magenta,Color.yellow); // body,gun,radar

		// Robot main loop
		// Robot main loop
		while(true) {
			if(roboDetectado == 0){
			setAhead(100);
			setTurnRight(90);
			setTurnGunRight(360);
			execute();
			}
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent  e) {
		
			double absoluteBearing = getHeading() + e.getBearing();
				double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
					if (Math.abs(bearingFromGun) <= 3){
						turnGunRight(bearingFromGun);
							if (getGunHeat() == 0) {
									setAhead(110);
									setTurnLeft(90);
									setTurnGunRight(2);
									setTurnGunLeft(2);
									setFireBullet(Math.min(3 - Math.abs(bearingFromGun), getEnergy() - .1));
									execute();
	}}
			else {
			turnGunRight(bearingFromGun);
		}
			if (bearingFromGun == 0) {
			scan();
			}
		}
	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		setBack(25);
		setTurnLeft(45);
		execute();
	}	
}
