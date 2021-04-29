package uk.co.connieprice.javasoftwarerenderer;

import uk.co.connieprice.javasoftwarerenderer.handlers.GraphicsHandler;
import uk.co.connieprice.javasoftwarerenderer.handlers.ObjectHandler;
import uk.co.connieprice.javasoftwarerenderer.math.Euler;
import uk.co.connieprice.javasoftwarerenderer.objects.Camera;
import uk.co.connieprice.javasoftwarerenderer.objects.Model;
import uk.co.connieprice.javasoftwarerenderer.objects.Model.Edge;
import uk.co.connieprice.javasoftwarerenderer.objects.Model.Vertex;

/**
 * <h1>Main</h1>
 * The 'Main' class is the central class to build up the front of the application.
 * 
 * @author Connie Price
 *
 */
public class Main {
	public static ObjectHandler objectHandler;
	public static GraphicsHandler graphicsHandler;

	/**
	 * The main method. The program starts here and this sets up the basics for the game.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		objectHandler = new ObjectHandler();
		Thread objectThread = new Thread(objectHandler);

		graphicsHandler = new GraphicsHandler("Java Software Renderer", objectHandler);
		Thread graphicsThread = new Thread(graphicsHandler);

		objectThread.start();
		graphicsThread.start();

		setupCube();
	}

	/**
	 * A method that simply sets up a camera and cube and adds them to the object handler.
	 */
	public static void setupCube() {
		Camera camera = new Camera(640, 480, 10, 7.5);
		objectHandler.addObject(camera);
		graphicsHandler.setActiveCamera(camera);

		// 8 corners of a cube.
		Vertex vert1 = new Vertex(-2,  2, -2);
		Vertex vert2 = new Vertex( 2,  2, -2);
		Vertex vert3 = new Vertex(-2, -2, -2);
		Vertex vert4 = new Vertex( 2, -2, -2);
		Vertex vert5 = new Vertex(-2,  2,  2);
		Vertex vert6 = new Vertex( 2,  2,  2);
		Vertex vert7 = new Vertex(-2, -2,  2);
		Vertex vert8 = new Vertex( 2, -2,  2);

		// 12 edges of a cube.
		Edge edge1  = new Edge(vert1, vert2);
		Edge edge2  = new Edge(vert1, vert3);
		Edge edge3  = new Edge(vert1, vert5);
		Edge edge4  = new Edge(vert2, vert4);
		Edge edge5  = new Edge(vert2, vert6);
		Edge edge6  = new Edge(vert3, vert4);
		Edge edge7  = new Edge(vert3, vert7);
		Edge edge8  = new Edge(vert4, vert8);
		Edge edge9  = new Edge(vert5, vert6);
		Edge edge10 = new Edge(vert5, vert7);
		Edge edge11 = new Edge(vert6, vert8);
		Edge edge12 = new Edge(vert7, vert8);

		// The Cube.
		Model cube = new Model();
		cube.addEdge(edge1);
		cube.addEdge(edge2);
		cube.addEdge(edge3);
		cube.addEdge(edge4);
		cube.addEdge(edge5);
		cube.addEdge(edge6);
		cube.addEdge(edge7);
		cube.addEdge(edge8);
		cube.addEdge(edge9);
		cube.addEdge(edge10);
		cube.addEdge(edge11);
		cube.addEdge(edge12);

		objectHandler.addObject(cube);
	}
}