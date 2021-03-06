package org.firstinspires.ftc.teamcode.subsystems.robot;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.capstone.Capstone;
import org.firstinspires.ftc.teamcode.subsystems.gantry.Gantry;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;
import org.firstinspires.ftc.teamcode.subsystems.lift.Lift;
import org.firstinspires.ftc.teamcode.subsystems.pusher.Pusher;
import org.firstinspires.ftc.teamcode.subsystems.roadrunner.drive.CompMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.spinner.Spinner;
import org.firstinspires.ftc.teamcode.subsystems.states.States;

public class CompRobot{

	public CompMecanumDrive drive;
	public Intake intake;
	public Lift lift;
	public Gantry gantry;
	public Pusher pusher;
	public Spinner spinner;
	public Capstone capstone;

	public States states;

	Telemetry telemetry;
	TelemetryPacket packet = new TelemetryPacket();
	FtcDashboard dashboard = FtcDashboard.getInstance();

	public CompRobot(HardwareMap map, Telemetry telemetry, Boolean resetEncoders) {
		this.telemetry = telemetry;

		drive = new CompMecanumDrive(map);
		intake = new Intake(map, telemetry);
		lift = new Lift(map, telemetry);
		gantry = new Gantry(map, telemetry, resetEncoders);
		pusher = new Pusher(map, telemetry);
		spinner = new Spinner(map, telemetry);
		capstone = new Capstone(map, telemetry);

		states = new States();

		telemetry.addData("Robot", "Initialized");
		telemetry.update();

		packet.put("Robot", "Initialized");
		dashboard.sendTelemetryPacket(packet);

	}
}
