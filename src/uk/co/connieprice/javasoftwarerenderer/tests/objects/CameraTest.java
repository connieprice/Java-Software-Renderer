package uk.co.connieprice.javasoftwarerenderer.tests.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uk.co.connieprice.javasoftwarerenderer.math.Vector2;
import uk.co.connieprice.javasoftwarerenderer.math.Vector3;
import uk.co.connieprice.javasoftwarerenderer.objects.Camera;

class CameraTest {
	private Camera camera;

	@BeforeEach
	void setUp() {
		camera = new Camera(640, 480, 6.4, 4.8);
	}

	@Test
	void testWorldToScreen() {
		assertEquals(new Vector2(320, 240), camera.worldToScreen(new Vector3(0,0,0)));
		assertEquals(new Vector2(0, 240), camera.worldToScreen(new Vector3(-3.2,0,0)));
		assertEquals(new Vector2(0, 480), camera.worldToScreen(new Vector3(-3.2,-2.4,0)));
		assertEquals(new Vector2(320, 480), camera.worldToScreen(new Vector3(0,-2.4,0)));

		assertEquals(new Vector2(320, 0), camera.worldToScreen(new Vector3(0,2.4,0)));
		assertEquals(new Vector2(640, 0), camera.worldToScreen(new Vector3(3.2,2.4,0)));
		assertEquals(new Vector2(640, 240), camera.worldToScreen(new Vector3(3.2,0,0)));
	}

}
