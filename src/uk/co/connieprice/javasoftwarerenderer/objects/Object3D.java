package uk.co.connieprice.javasoftwarerenderer.objects;

import java.awt.Graphics2D;

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

	public void render(Camera camera, Graphics2D graphics2D) {}
	public void update(long time, long deltaTime) {}
}
