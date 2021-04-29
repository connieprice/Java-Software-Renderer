package uk.co.connieprice.javasoftwarerenderer.handlers;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uk.co.connieprice.javasoftwarerenderer.objects.Camera;

/**
 * <h1>GraphicsHandler</h1>
 * The main graphics handler. Handles the graphical representation side of things.
 * 
 * @author Connie Price
 *
 */
public class GraphicsHandler implements Runnable {
	private JFrame window;
	private JPanel panel;

	/**
	 * Create the graphics handler instance.
	 * @param title The title of the graphics window.
	 */
	public GraphicsHandler(String title) {
		this.window = new JFrame();

		this.window.setTitle(title);
		this.window.setResizable(false);

		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel = new Surface();
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
				Thread.sleep(framerateInterval - deltaTime);
			} catch (InterruptedException e) {
				System.out.print("Thread Interrupted");
			}
		}
	}
}

/**
 * <h1>Surface</h1>
 * A small custom JPanel that stores the models and camera position.
 *
 * @author Connie Price
 *
 */
@SuppressWarnings("serial") // We're not going to be serialising instances of this class, this warning is annoying.
class Surface extends JPanel {
	Camera camera;

	Surface() {
		this.setFocusable(true);
		this.setPreferredSize(new Dimension(640,480));
		this.requestFocusInWindow();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics2D = (Graphics2D) g;

		
	}
}