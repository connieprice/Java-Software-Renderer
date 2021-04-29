package uk.co.connieprice.javasoftwarerenderer.objects;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import uk.co.connieprice.javasoftwarerenderer.math.Vector2;
import uk.co.connieprice.javasoftwarerenderer.math.Vector3;

public class Model extends Object3D {
	static public class Vertex {
		public final Vector3 position;

		public Vertex(double x, double y, double z) {
			this.position = new Vector3(x, y, z);
		}
	}

	static public class Edge {
		public final Vertex vert1;
		public final Vertex vert2;

		public Edge(Vertex vert1, Vertex vert2) {
			this.vert1 = vert1;
			this.vert2 = vert2;
		}
	}

	public List<Edge> edges = new ArrayList<Edge>();

	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}

	@Override
	public void render(Camera camera, Graphics2D graphics2D) {
		for (int i = this.edges.size() - 1; i >= 0; i--) {
			Edge edge = this.edges.get(i);

			Vector3 point1 = edge.vert1.position.add(this.position);
			Vector3 point2 = edge.vert2.position.add(this.position);

			Vector2 screenPoint1 = camera.worldToScreen(point1);
			Vector2 screenPoint2 = camera.worldToScreen(point2);

			graphics2D.drawLine(
				(int) Math.round(screenPoint1.x),
				(int) Math.round(screenPoint1.y),
				(int) Math.round(screenPoint2.x),
				(int) Math.round(screenPoint2.y)
			);
		}
	}
}