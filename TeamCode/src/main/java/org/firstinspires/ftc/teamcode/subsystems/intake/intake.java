package org.firstinspires.ftc.teamcode.subsystems.intake;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class intake{

	DcMotorEx intakeMotor;

	int COUNTS_PER_ROTATION = 1;

	Telemetry telemetry;
	TelemetryPacket packet = new TelemetryPacket();
	FtcDashboard dashboard = FtcDashboard.getInstance();

	public intake(HardwareMap map, Telemetry telemetry) {
		this.telemetry = telemetry;

		intakeMotor = map.get(DcMotorEx.class, "intakeMotor");
		intakeMotor.setDirection(DcMotorEx.Direction.FORWARD);
		intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
		intakeMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);


		telemetry.addData("Intake", "Initialized");
		telemetry.update();

		packet.put("Intake", "Initialized");
		dashboard.sendTelemetryPacket(packet);
	}

	public void runIntake(double speed) {
		intakeMotor.setPower(speed);

		return;
	}

	public void runIntake(double rotations, double speed) {
		intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

		intakeMotor.setTargetPosition((int) (intakeMotor.getCurrentPosition() + (rotations*COUNTS_PER_ROTATION)));
		intakeMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
		intakeMotor.setPower(speed);
		while (intakeMotor.isBusy())

		intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		return;
	}
}
