package uk.co.connieprice.javasoftwarerenderer.math;

public class Euler {
	public final double pitch;
	public final double yaw;
	public final double roll;

	public Euler() {
		this.pitch = 0;
		this.yaw = 0;
		this.roll = 0;
	}

	public Euler(double pitch, double yaw, double roll) {
		this.pitch = pitch;
		this.yaw = yaw;
		this.roll = roll;
	}
}
