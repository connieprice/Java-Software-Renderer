package uk.co.connieprice.javasoftwarerenderer.math;

/**
 * <h1>Euler</h1>
 * A helper class to store euler rotations.
 *
 * @author Connie Price
 *
 */
public class Euler {
	public final double pitch;
	public final double yaw;
	public final double roll;

	/**
	 * Create a Euler object, with default 0,0,0 rotations.
	 */
	public Euler() {
		this.pitch = 0;
		this.yaw = 0;
		this.roll = 0;
	}

	/**
	 * Create a Euler object.
	 * @param pitch Pitch rotation.
	 * @param yaw Yaw rotation.
	 * @param roll Roll rotation.
	 */
	public Euler(double pitch, double yaw, double roll) {
		this.pitch = pitch;
		this.yaw = yaw;
		this.roll = roll;
	}
}
