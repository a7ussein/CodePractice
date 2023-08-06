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

 public CANSparkMax leftFront = new CANSparkMax( 2, CANSparkMaxLowLevel.MotorType.kBrushless);
 public CANSparkMax leftBack = new CANSparkMax( 1, CANSparkMaxLowLevel.MotorType.kBrushless);
 public CANSparkMax rightFront = new CANSparkMax( 3, CANSparkMaxLowLevel.MotorType.kBrushless);
 public CANSparkMax rightBack = new CANSparkMax( 4, CANSparkMaxLowLevel.MotorType.kBrushless);

 public RelativeEncoder leftEncoder = leftFront.getEncoder();
 public RelativeEncoder rightEncoder = rightFront.getEncoder();

 MotorControllerGroup leftControllerGroup = new MotorControllerGroup(leftFront, leftBack);
 MotorControllerGroup rightControllerGroup = new MotorControllerGroup(rightFront, rightBack);

 
 public DifferentialDrive drive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);

  @Override
  public void robotInit() {
    leftFront.restoreFactoryDefaults();
    leftBack.restoreFactoryDefaults();
    rightFront.restoreFactoryDefaults();
    rightBack.restoreFactoryDefaults();

    rightControllerGroup.setInverted(true);
    leftControllerGroup.setInverted(false);

    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);
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
