package uk.co.connieprice.javasoftwarerenderer.tests.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uk.co.connieprice.javasoftwarerenderer.math.Euler;
import uk.co.connieprice.javasoftwarerenderer.math.Vector3;

class Vector3Test {
	int vectorCount = 15;
	List<Vector3> vectors = new ArrayList<Vector3>();

	@BeforeEach
	void setUp() {
		for (int i = 0; i < vectorCount; i++) {
			vectors.add(new Vector3(
				ThreadLocalRandom.current().nextDouble(),
				ThreadLocalRandom.current().nextDouble(),
				ThreadLocalRandom.current().nextDouble()
			));
		}
	}

	@Test
	void testAdd() {
		for (int i = 1; i < (vectorCount - 1); i++) {
			Vector3 previousVector = vectors.get(i - 1);
			Vector3 currentVector = vectors.get(i);
			Vector3 nextVector = vectors.get(i + 1);

			Vector3 firstComboExpected = new Vector3(
					previousVector.x + currentVector.x,
					previousVector.y + currentVector.y,
					previousVector.z + currentVector.z
			);
			Vector3 firstComboActual = previousVector.add(currentVector);
			assertEquals(firstComboExpected, firstComboActual);

			Vector3 secondComboExpected = new Vector3(
					currentVector.x + nextVector.x,
					currentVector.y + nextVector.y,
					currentVector.z + nextVector.z
			);
			Vector3 secondComboActual = currentVector.add(nextVector);
			assertEquals(secondComboExpected, secondComboActual);
		}
	}

	@Test
	void testSubtract() {
		for (int i = 1; i < (vectorCount - 1); i++) {
			Vector3 previousVector = vectors.get(i - 1);
			Vector3 currentVector = vectors.get(i);
			Vector3 nextVector = vectors.get(i + 1);

			Vector3 firstComboExpected = new Vector3(
					previousVector.x - currentVector.x,
					previousVector.y - currentVector.y,
					previousVector.z - currentVector.z
			);
			Vector3 firstComboActual = previousVector.subtract(currentVector);
			assertEquals(firstComboExpected, firstComboActual);

			Vector3 secondComboExpected = new Vector3(
					currentVector.x - nextVector.x,
					currentVector.y - nextVector.y,
					currentVector.z - nextVector.z
			);
			Vector3 secondComboActual = currentVector.subtract(nextVector);
			assertEquals(secondComboExpected, secondComboActual);
		}
	}

	@Test
	void testRotateAroundOrigin() {
		Vector3 point;

		point = new Vector3(1,0,0);
		point = point.rotateAroundOrigin(new Euler(
				Math.PI/2,
				0,
				0
		));

		assertEquals(point.z, -1);

		point = new Vector3(0,1,0);
		point = point.rotateAroundOrigin(new Euler(
				0,
				Math.PI/2,
				0
		));

		assertEquals(point.x, -1);
	}

}