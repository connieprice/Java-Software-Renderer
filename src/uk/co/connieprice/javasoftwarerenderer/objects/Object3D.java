package uk.co.connieprice.javasoftwarerenderer.objects;

import java.awt.Graphics2D;

import uk.co.connieprice.javasoftwarerenderer.math.Euler;
import uk.co.connieprice.javasoftwarerenderer.math.Vector3;

/**
 * <h1>Object3D</h1>
 * An empty helper object to act as a basis of other types of objects.
 *
 * @author Connie Price
 *
 */
public class Object3D {
	public Vector3 position = new Vector3();
	public Euler rotation = new Euler();

	/**
	 * Render the object.
	 * @param camera The camera to render from.
	 * @param graphics2D The graphics object to render to.
	 */
	public void render(Camera camera, Graphics2D graphics2D) {}

	/**
	 * Update the object.
	 * @param time The current time. (Milliseconds)
	 * @param deltaTime The time since the last update. (Milliseconds)
	 */
	public void update(long time, long deltaTime) {}
}
