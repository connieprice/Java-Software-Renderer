package uk.co.connieprice.javasoftwarerenderer.objects;

import uk.co.connieprice.javasoftwarerenderer.math.Vector2;
import uk.co.connieprice.javasoftwarerenderer.math.Vector3;

/**
 * <h1>Vector3</h1>
 * A camera object which will store camera relative info
 * as well as helper methods for position translation.
 *
 * @author Connie Price
 *
 */
public class Camera extends Object3D {
	Vector2 windowSize = new Vector2();
	Vector2 viewSize = new Vector2();

	/**
	 * Create a camera instance. Try and keep the width and height of
	 * the camera consistent with the window aspect ratio, otherwise
	 * things may get skewed.
	 * @param windowWidth The width of the window the camera is occupying, usually in pixels.
	 * @param windowHeight The height of the window the camera is occupying, usually in pixels.
	 * @param width The "in-world" width that the camera can see.
	 * @param height The "in-world" height that the camera can see.
	 */
	public Camera(double windowWidth, double windowHeight, double width, double height) {
		this.windowSize = new Vector2(windowWidth, windowHeight);
		this.viewSize = new Vector2(width, height);
	}

	/**
	 * Translate from world space coordinates to screen space coordinates.
	 * @param worldPosition The world space coordinates you wish to translate.
	 * @return screenPosition The screen space coordinates that have been calculated.
	 */
	public Vector2 worldToScreen(Vector3 worldPosition) {
		Vector3 topLeftCorner = new Vector3(
			this.position.x - (this.viewSize.x/2),
			this.position.y + (this.viewSize.y/2),
			this.position.z
		);

		Vector3 relativePosition = worldPosition.subtract(topLeftCorner);
		Vector2 screenPosition = new Vector2(
				(relativePosition.x / this.viewSize.x) * this.windowSize.x,
				(relativePosition.y / -this.viewSize.y) * this.windowSize.y
		);

		return screenPosition;
	}

	// TODO: Implement
	/**
	 * (Method not yet implemented.) Translate from screen space coordinates to world space coordinates.
	 * @param screenPosition The screen space coordinates you wish to translate.
	 * @return worldPosition The world space coordinates that have been calculated.
	 * @deprecated
	 */
	public Vector3 screenToWorld(Vector2 screenPosition) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
}
