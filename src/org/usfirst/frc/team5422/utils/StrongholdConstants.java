package org.usfirst.frc.team5422.utils;

/*
 *@author Suren Karavettil
 *@author Mayank
 *
 *Stormgears 2016 Robot Drive Specifications
 *
 */


public class StrongholdConstants {
	public static final String RHINO = "rhino";
	public static final String STRONGHOLD = "stronghold";
	public static final String PROP_INPUT_METHOD_OFFICIAL = "official";
	public static final String PROP_INPUT_METHOD_SIMULATOR = "simulator";
			

	public static double SHOOTER_F = 0.16238095;
	public static double SHOOTER_P = 0;
	public static double SHOOTER_I = 0;
	public static double SHOOTER_D = 0;
	public static double SHOOTER_MAX_SPEED = 6000; //per 10ms
	
	public static double WHEEL_BASE = 23.0;//inches	
	
	public static int TALON_DRIVE_LEFT_MASTER = 2;
	public static int TALON_DRIVE_RIGHT_MASTER  = 1;
	public static int TALON_DRIVE_LEFT_SLAVE = 0;
	public static int TALON_DRIVE_RIGHT_SLAVE  = 3;
	
	//PIDs
	public static double TRAP_F = 0;
	public static double TRAP_P = 0.9;
	public static double TRAP_I = 0;
	public static double TRAP_D = 0.575;

	public static double OPEN_DRIVE_F = 1.705;
	public static double OPEN_DRIVE_P = 0.000185;
	public static double OPEN_DRIVE_I = 0;
	public static double OPEN_DRIVE_D = 0;
	
	public static int TALON_LEFT_SHOOTER = 7;
	public static int TALON_RIGHT_SHOOTER = 4;
	public static int TALON_ACTUATOR = 5;

	public static double WHEEL_DIAMETER = 5 + 7.0/8.0 + 3.0/25.4;//inches
	
	public static double ANGLE_MOTOR_UP_F = 0;
	public static double ANGLE_MOTOR_UP_P = 40;
	public static double ANGLE_MOTOR_UP_I = 0.005;
	public static double ANGLE_MOTOR_UP_D = 0.2;
	public static int ANGLE_MOTOR_UP_IZONE = 0;
	public static double ANGLE_MOTOR_UP_RAMP_RATE = 1;
	public static int ANGLE_MOTOR_UP_PROFILE = 1;
	
	public static double ANGLE_MOTOR_DOWN_F = 0;
	public static double ANGLE_MOTOR_DOWN_P = 6.3;
	public static double ANGLE_MOTOR_DOWN_I = 0;
	public static double ANGLE_MOTOR_DOWN_D = 0.5;
	public static int ANGLE_MOTOR_DOWN_IZONE = 0;
	public static double ANGLE_MOTOR_DOWN_RAMP_RATE = 1;
	public static int ANGLE_MOTOR_DOWN_PROFILE = 0;
	
	public static int ANGLE_MOTOR_INTAKE_POS = 600;
	
	//Physical attributes
	public static final int ENCODER_TICKS_RESOLUTION = 8192;//ticks
	public static final int ENCODER_TICKS_CPR = ENCODER_TICKS_RESOLUTION / 4;

	//Rabbot Drive specifications
	public static final double GEAR_RATIO = 1;
	public static final double ROBOT_MIDDLE_TO_FRONT = 17;//inches
	public static double ROBOT_WIDTH = 24;
	public static double SIDE_ULTRA_SENSOR_TO_ROBOT_MIDDLE_Y = 16;
	
	public static final double DEFENSE_WIDTH = 12*(2 + 2*Math.cos(13.5*Math.PI/180));
	public static final double DEFENSE_PASSABLE_LENGTH = 4*12 + 2;
	
	public static final double DEFENSE_TOP_WIDTH = 4*12;//inches
	
	
	//Inches per tick
	public static double INCHES_PER_TICK = Math.PI * WHEEL_DIAMETER / (GEAR_RATIO * ENCODER_TICKS_RESOLUTION);
	
	public static final int JOYSTICK_CHANNEL = 0;
	public static final int BUTTONBOARD_CHANNEL = 1;
	
	//DigitalOutput 1 for the echo pulses
	public static final int ULTRASONIC_ECHO_PULSE_OUTPUT = 1;
	//DigitalInput 1 for the trigger pulse	
	public static final int ULTRASONIC_TRIGGER_PULSE_INPUT = 1;
	
	public static final int ANALOG_GYRO_INPUT_CHANNEL = 1;

	// Network Tables Constants
	public static final String f = "Front Distance";
	public static final String r = "Right Distance";
	public static final String b = "Back Distance";
	public static final String l = "Left Distance";
	
	public static final String gAngle = "Gyro Angle";
	public static final String gRotation = "Gyro Rotation Rate";
	
	public static final String aX = "X-Accel";
	public static final String aY = "Y-Accel";
	public static final String aZ = "Z-Accel";
	
	public static final String uVal = "Ultrasonic Values";
	public static final String gVal = "Gyro Values";
	public static final String aVal = "Acceleration Values";

	
	//Positions
	public static final int[] POSITION_DEFENSE_0_REACH = {25, 90-20};
	public static final int[] POSITION_DEFENSE_1_REACH = {25 + 1 * 50, 90-20};
	public static final int[] POSITION_DEFENSE_2_REACH = {25 + 2 * 50, 90-20};
	public static final int[] POSITION_DEFENSE_3_REACH = {25 + 3 * 50, 90-20};
	public static final int[] POSITION_DEFENSE_4_REACH = {25 + 4 * 50, 90-20};
	public static final int CROSS_DEFENSE_LENGTH_Y = 60+20;

	//H = high; L = low
	public static final double[] POSITION_HLEFT_GOAL = {151, 312};
	public static final double[] POSITION_HCENTER_GOAL = {171.5, 300};
	public static final double[] POSITION_HRIGHT_GOAL = {193.5, 312};
	public static final double[] POSITION_LLEFT_GOAL = {151, 312};
	public static final double[] POSITION_LRIGHT_GOAL = {193.5, 312};

	public static final int DEFENSE_POSITION_LOW_BAR = 0;
	public static final int DEFENSE_POSITION_1 = 1;
	public static final int DEFENSE_POSITION_2 = 2;
	public static final int DEFENSE_POSITION_3 = 3;
	public static final int DEFENSE_POSITION_4 = 4;

	public static final double[] POSITION_BALL_1 = {45.5, 0};
	public static final double[] POSITION_BALL_2 = {91, 0};
	public static final double[] POSITION_BALL_3 = {136.5, 0};
	public static final double[] POSITION_BALL_4 = {182, 0};
	public static final double[] POSITION_BALL_5 = {227.5, 0};
	public static final double[] POSITION_BALL_6 = {273, 0};

	public static final Double[] START_POSITION_1 = {45.5, 24.0};
	public static final Double[] START_POSITION_2 = {91.0, 24.0};
	public static final Double[] START_POSITION_3 = {136.5, 24.0};
	public static final Double[] START_POSITION_4 = {182.0, 24.0};
	public static final Double[] START_POSITION_5 = {227.5, 24.0};
	public static final Double[] START_POSITION_6 = {273.0, 24.0};

	public static final double[] FALLBACK_LEFT = {70, 260};
	public static final double[] FALLBACK_CENTER = {175, 200};

	public static final int SOLENOID_SHOOTER = 0;
	
	public static final double FULL_THROTTLE = 1;
	public static final double NO_THROTTLE = 0;
	public static final double VEL_PER_100MS = 81.92;

	public static int BIG_BLUE_BUTTON_ID = 10;
	public static int RED_BUTTON_ID = 15;
	public static int YELLOW_BUTTON_ID = 14;
	public static int GREEN_BUTTON_ID = 13;
	public static int BLUE_BUTTON_ID = 12;
	public static int BLACK_BUTTON_ID = 9;
	public static int WHITE_BUTTON_ID = 8;
	public static int GREEN_SWITCH_ID = 5;
	public static int ORANGE_SWITCH_ID = 4;
	public static int RED_SWITCH_ID = 3;
	
	public enum diagnosticPOSTOptions {
		TEST_GYRO, 
		TEST_ULTRASONIC, 
		TEST_IR,
		TEST_TALON_LEFT_MASTER,
		TEST_TALON_RIGHT_MASTER,
		TEST_CHASSIS_DRIVE,
		TEST_SHOOTER,
		TEST_GRAPPLER,
		TEST_ALIGN_TO_CASTLE,
		TEST_LIFTER,
		TEST_MOTION_PROFILE, 
		TEST_GLOBAL_POSITIONING,
		TEST_NONE
	}

	public enum shootHeightOptions {
		HIGH,
		LOW,
		NONE
	}

	public static final double SHOOT_DELAY = 1;
	public static final double SHOOT_DELAY1 = 0.5;
	public static final double SHOOT_DELAY2 = 2;
	public static final double SHOOTER_HEIGHT = 10.5;
	public static final double HEIGHT_TO_HIGH_GOAL = 97 - SHOOTER_HEIGHT;
	public static final double HEIGHT_TO_LOW_GOAL = 18 - SHOOTER_HEIGHT;
	public static final int POT_TURNS = 100;
	public static final double ACTUATOR_ANGLE_RANGE = 90;
	public static final double TUNER_MULTIPLIER = 90.91;
	
	//Used in real robot
//	public static final double ACTUATOR_ARM_UP_POT_FULLRANGE = 210;
//	public static final double ACTUATOR_ARM_DOWN_POT_FULLRANGE = 610;
//	public static final double ACTUATOR_ANGLE_MIN = -22;
//	public static final double ACTUATOR_ANGLE_MAX = 73;
	
	//Used in replica robot
	public static final double ACTUATOR_ARM_UP_POT_FULLRANGE = 570;
	public static final double ACTUATOR_ARM_DOWN_POT_FULLRANGE = 907;
	public static final double ACTUATOR_ANGLE_MIN = -20;
	public static final double ACTUATOR_ANGLE_MAX = 57;
	
	public static final double ACTUATOR_ARM_SLIDER_MIN = -1;
	public static final double ACTUATOR_ARM_SLIDER_MAX = 1;

	public static final double ACTUATOR_ARM_POT_OPT_UP = 280;
	public static final double ACTUATOR_ARM_POT_OPT_DOWN = 610; //all the way down on the floor
	public static final double ACTUATOR_ARM_SLIDER_OPT_MIN = -0.625;
	public static final double ACTUATOR_ARM_SLIDER_OPT_MAX = 1;

	public static final double ACTUATOR_ARM_SLIDER_RANGE = Math.abs(ACTUATOR_ARM_SLIDER_MAX - ACTUATOR_ARM_SLIDER_MIN);	
	public static final double ACTUATOR_ARM_POT_RANGE = Math.abs(ACTUATOR_ARM_DOWN_POT_FULLRANGE - ACTUATOR_ARM_UP_POT_FULLRANGE);
	public static final double ACTUATOR_ARM_SLIDER_TO_POT_CONVERSION_FACTOR = ACTUATOR_ARM_POT_RANGE/ACTUATOR_ARM_SLIDER_RANGE;

//	public static final double ACTUATOR_ARM_UP_ANGLE = 73;//degrees
//	public static final double ACTUATOR_ARM_DOWN_ANGLE = -22;//degrees
//	public static final double ACTUATOR_ARM_ANGLE_RANGE = Math.abs(ACTUATOR_ARM_DOWN_ANGLE - ACTUATOR_ARM_UP_ANGLE);//degrees
//	public static final double ACTUATOR_ARM_ANGLE_CONVERSION_FACTOR = ACTUATOR_ARM_SLIDER_RANGE/ACTUATOR_ARM_ANGLE_RANGE;
	
	public enum shootOptions {
		HIGH_LEFT,
		HIGH_RIGHT,
		HIGH_CENTER,
		LOW_LEFT,
		LOW_RIGHT,
		NONE
	}
	
	public enum defenseTypeOptions {
		LOW_BAR,
		PORTCULLIS,
		CHIVAL_DE_FRISE,
		MOAT,
		RAMPARTS,
		DRAWBRIDGE,
		SALLYPORT,
		ROCK_WALL,
		ROUGH_TERRAIN,
		NONE
	}
	
	public enum endOptions {
		TELEOP_STARTING_POSITION,
		NONE
	}
	
	public enum Speed {
		SLOW, MEDIUM, FAST
	}

	public enum alliance {
		RED, BLUE
	}
	
}
