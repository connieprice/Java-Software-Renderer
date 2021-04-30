package uk.co.connieprice.javasoftwarerenderer.objects;

import uk.co.connieprice.javasoftwarerenderer.math.Euler;

/**
 * <h1>SpinningModel</h1>
 * An extension of a model that just spins. :D
 * 
 * @author Connie Price
 *
 */
public class SpinningModel extends Model {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(long time, long deltaTime) {
		double seconds = time/1000d;
		double angle = seconds * (Math.PI/5);

		this.rotation = new Euler(
			angle,
			Math.sin(seconds),
			0
		);
	}
}
