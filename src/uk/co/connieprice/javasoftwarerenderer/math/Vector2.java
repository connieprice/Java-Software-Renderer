package uk.co.connieprice.javasoftwarerenderer.math;

/**
 * <h1>Vector3</h1>
 * A helper class to store 2d positions.
 *
 * @author Connie Price
 *
 */
public class Vector2 {
	public final double x;
	public final double y;

	/**
	 * Create a Vector2 object, with default 0,0 coordinates.
	 */
	public Vector2() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * Create a Vector2 object.
	 * @param x X coordinate.
	 * @param y Y coordinate.
	 */
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Check if the vector is equal to another object.
	 * If the object is another vector instance it compares coordinates.
	 * @param o The comparison object.
	 * @return equals Do the objects equal eachother?
	 */
	@Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }
  
        /* Check if o is an instance of Vector2 or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Vector2)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members 
        Vector2 v2 = (Vector2) o;

        // Compare the data members and return accordingly 
        return Double.compare(this.x, v2.x) == 0 && Double.compare(this.y, v2.y) == 0;
    }

	/**
	 * Add another vector to this vector and produce a new vector from the result.
	 * @param otherVector The other vector to add.
	 * @return outputVector The output vector.
	 */
	public Vector2 add(Vector2 otherVector)
	{
		return new Vector2(
			this.x + otherVector.x,
			this.y + otherVector.y
		);
	}

	/**
	 * Subtract another vector from this vector and produce a new vector from the result.
	 * @param otherVector The other vector to subtract.
	 * @return outputVector The output vector.
	 */
	public Vector2 subtract(Vector2 otherVector)
	{
		return new Vector2(
			this.x - otherVector.x,
			this.y - otherVector.y
		);
	}
}
