package uk.co.connieprice.javasoftwarerenderer.objects;

import uk.co.connieprice.javasoftwarerenderer.math.Vector2;
import uk.co.connieprice.javasoftwarerenderer.math.Vector3;

public class Camera extends Object {
	Vector2 windowSize;
	Vector2 viewSize;

	public Camera(double windowWidth, double windowHeight, double width, double height) {
		this.windowSize = new Vector2(windowWidth, windowHeight);
		this.viewSize = new Vector2(width, height);
	}

	public Vector2 worldToScreen(Vector3 worldPosition) {
		Vector3 bottomLeftCorner = new Vector3(
			this.position.x - (this.viewSize.x/2),
			this.position.y - (this.viewSize.y/2),
			0
		);

		Vector3 relativePosition = Vector3.subtract(worldPosition, bottomLeftCorner);
		Vector2 output = new Vector2(
				(relativePosition.x / this.viewSize.x) * this.windowSize.x,
				(relativePosition.y / this.viewSize.y) * this.windowSize.y
		);

		return output;
	}

	// TODO: Implement
	public Vector3 screenToWorld(Vector2 screenPosition) {
		return new Vector3(0d,0d,0d);
	}
}
