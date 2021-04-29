package uk.co.connieprice.javasoftwarerenderer.tests.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uk.co.connieprice.javasoftwarerenderer.math.Vector2;

class Vector2Test {
	int vectorCount = 15;
	List<Vector2> vectors = new ArrayList<Vector2>();

	@BeforeEach
	void setUp() {
		for (int i = 0; i < vectorCount; i++) {
			vectors.add(new Vector2(
				ThreadLocalRandom.current().nextDouble(),
				ThreadLocalRandom.current().nextDouble()
			));
		}
	}

	@Test
	void testAdd() {
		for (int i = 1; i < (vectorCount - 1); i++) {
			Vector2 previousVector = vectors.get(i - 1);
			Vector2 currentVector = vectors.get(i);
			Vector2 nextVector = vectors.get(i + 1);

			Vector2 firstComboExpected = new Vector2(
					previousVector.x + currentVector.x,
					previousVector.y + currentVector.y
			);
			Vector2 firstComboActual = previousVector.add(currentVector);
			assertEquals(firstComboExpected, firstComboActual);

			Vector2 secondComboExpected = new Vector2(
					currentVector.x + nextVector.x,
					currentVector.y + nextVector.y
			);
			Vector2 secondComboActual = currentVector.add(nextVector);
			assertEquals(secondComboExpected, secondComboActual);
		}
	}
	
	@Test
	void testSubtract() {
		for (int i = 1; i < (vectorCount - 1); i++) {
			Vector2 previousVector = vectors.get(i - 1);
			Vector2 currentVector = vectors.get(i);
			Vector2 nextVector = vectors.get(i + 1);

			Vector2 firstComboExpected = new Vector2(
					previousVector.x - currentVector.x,
					previousVector.y - currentVector.y
			);
			Vector2 firstComboActual = previousVector.subtract(currentVector);
			assertEquals(firstComboExpected, firstComboActual);

			Vector2 secondComboExpected = new Vector2(
					currentVector.x - nextVector.x,
					currentVector.y - nextVector.y
			);
			Vector2 secondComboActual = currentVector.subtract(nextVector);
			assertEquals(secondComboExpected, secondComboActual);
		}
	}
}