package uk.co.connieprice.javasoftwarerenderer.objects;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import uk.co.connieprice.javasoftwarerenderer.math.Euler;
import uk.co.connieprice.javasoftwarerenderer.math.Vector2;
import uk.co.connieprice.javasoftwarerenderer.math.Vector3;

/**
 * <h1>Model</h1>
 * An Object that can store and render model data.
 * 
 * @author Connie Price
 *
 */
public class Model extends Object3D {
	/**
	 * <h1>Vertex</h1>
	 * A vertex is essentially a point on the model, for now it only stores
	 * a position but we may want it to store more vertex unique data
	 * in the future. 
	 * 
	 * @author Connie Price
	 *
	 */
	static public class Vertex {
		public final Vector3 position;

		/**
		 * Create a vertex.
		 * @param x X coordinate.
		 * @param y Y coordinate.
		 * @param z Z coordinate.
		 */
		public Vertex(double x, double y, double z) {
			this.position = new Vector3(x, y, z);
		}
	}

	static public class Edge {
		public final Vertex vert1;
		public final Vertex vert2;

		/**
		 * Create an edge.
		 * @param vertex1 The first vertex.
		 * @param vertex2 The second vertex.
		 */
		public Edge(Vertex vertex1, Vertex vertex2) {
			this.vert1 = vertex1;
			this.vert2 = vertex2;
		}
	}

	public List<Edge> edges = new ArrayList<Edge>();

	/**
	 * Add an edge to the model.
	 * @param edge The edge to add.
	 */
	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void render(Camera camera, Graphics2D graphics2D) {
		for (int i = this.edges.size() - 1; i >= 0; i--) {
			Edge edge = this.edges.get(i);

			Vector3 point1 = edge.vert1.position.rotateAroundOrigin(this.rotation).add(this.position);
			Vector3 point2 = edge.vert2.position.rotateAroundOrigin(this.rotation).add(this.position);

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

	@Override
	public void update(long time, long deltaTime) {
		double seconds = time/1000d;
		double angle = seconds * (Math.PI/5);

		this.rotation = new Euler(
			Math.PI/4,
			0,
			angle
		);
	}
}