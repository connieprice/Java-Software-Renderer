package uk.co.connieprice.javasoftwarerenderer;

import uk.co.connieprice.javasoftwarerenderer.handlers.GraphicsHandler;

/**
 * <h1>Main</h1>
 * The 'Main' class is the central class to build up the front of the application.
 * 
 * @author Connie Price
 *
 */
public class Main {
	public static GraphicsHandler graphicsHandler;

	/**
	 * The main method. The program starts here and this sets up the basics for the game.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		graphicsHandler = new GraphicsHandler("Java Software Renderer");
		Thread graphicsThread = new Thread(graphicsHandler);
		graphicsThread.start();
		
		setupCube();
	}

	public static void setupCube() {
		
	}
}