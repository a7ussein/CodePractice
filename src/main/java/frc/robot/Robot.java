package frc.robot;

import com.ctre.phoenix.motorcontrol.MotorCommutation;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Robot extends TimedRobot {

 public XboxController driverController = new XboxController(0);

 // Variable type (public / private) + type of Motor Controller + = + new motorController(device ID, type of motor);  
 public CANSparkMax leftFront = new CANSparkMax( 2, CANSparkMaxLowLevel.MotorType.kBrushless);
 public CANSparkMax leftBack = new CANSparkMax( 1, CANSparkMaxLowLevel.MotorType.kBrushless);
 MotorControllerGroup leftControllerGroup = new MotorControllerGroup(leftFront, leftBack);
 public RelativeEncoder leftEncoder = leftFront.getEncoder();

// Define the two right motors, rightFrontID = 3, rightBackID = 4 


// Define a motorControllerGroup and name it rightControllerGroup and add the two right motors to it


// Deine an encoder for the right side of the robot



 public DifferentialDrive drive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);

  @Override
  public void robotInit() {
    leftFront.restoreFactoryDefaults();
    leftBack.restoreFactoryDefaults();
    leftControllerGroup.setInverted(false);
    leftEncoder.setPosition(0);

    //restore factory defaults for the right two motors

    //set the rightMotoroControllerGroup as inverted

    //make the position of the right Encoder at 0
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    double speed = -driverController.getRawAxis(1);
    double turn = -driverController.getRawAxis(4);

    drive.arcadeDrive(speed, turn);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
