package uk.co.connieprice.javasoftwarerenderer.handlers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uk.co.connieprice.javasoftwarerenderer.math.Vector2;
import uk.co.connieprice.javasoftwarerenderer.math.Vector3;
import uk.co.connieprice.javasoftwarerenderer.objects.Camera;
import uk.co.connieprice.javasoftwarerenderer.objects.Object3D;

/**
 * <h1>GraphicsHandler</h1>
 * The main graphics handler. Handles the graphical representation side of things.
 * 
 * @author Connie Price
 *
 */
public class GraphicsHandler implements Runnable {
	private JFrame window;
	private Surface panel;

	/**
	 * Create the graphics handler instance.
	 * @param title The title of the graphics window.
	 */
	public GraphicsHandler(String title, ObjectHandler objectHandler) {
		this.window = new JFrame();

		this.window.setTitle(title);
		this.window.setResizable(false);

		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel = new Surface(objectHandler);
		this.window.add(this.panel);

		this.window.pack();
	}

	private long framerateInterval = 16; // About 60 frames per second.
	@Override
	public void run() {
		this.window.setVisible(true);
		while(true) {
			long startTime = System.currentTimeMillis();

			this.panel.repaint();

			long endTime = System.currentTimeMillis();
			long deltaTime = endTime - startTime;

			try {
				long delay = framerateInterval - deltaTime;
				if (delay > 0) { // If we are slower than the target frame rate than just don't delay, keep going.
					Thread.sleep(framerateInterval - deltaTime);
				}
			} catch (InterruptedException e) {
				System.out.print("Thread Interrupted");
			}
		}
	}

	/**
	 * Set the active camera.
	 * @param camera The camera to use as the active camera.
	 */
	public void setActiveCamera(Camera camera) {
		this.panel.activeCamera = camera;
	}

	/**
	 * Get the active camera.
	 * @return The active camera.
	 */
	public Camera getActiveCamera() {
		return this.panel.activeCamera;
	}
}

/**
 * <h1>Surface</h1>
 * A small custom JPanel that renders models and stores the current camera.
 *
 * @author Connie Price
 *
 */
@SuppressWarnings("serial") // We're not going to be serialising instances of this class, this warning is annoying.
class Surface extends JPanel {
	protected Camera activeCamera;
	private ObjectHandler objectHandler;

	Surface(ObjectHandler objectHandler) {
		this.setFocusable(true);
		this.setPreferredSize(new Dimension(640,480));
		this.requestFocusInWindow();

		this.objectHandler = objectHandler;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics2D = (Graphics2D) g;
		graphics2D.setColor(Color.BLACK);

		List<Object3D> objects = this.objectHandler.getObjects();
		// Set i to the size and go backwards as this is marginally
		// faster than constantly comparing against the size every time.
		for (int i = objects.size() - 1; i >= 0; i--) {
			Object3D object = objects.get(i);
			object.render(this.activeCamera, graphics2D);
		}
	}
}