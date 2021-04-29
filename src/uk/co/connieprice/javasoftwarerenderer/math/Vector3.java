package uk.co.connieprice.javasoftwarerenderer.math;

/**
 * <h1>Vector3</h1>
 * A helper class to store 3d positions.
 *
 * @author Connie Price
 *
 */
public class Vector3 extends Vector2{
	public final double z;

	/**
	 * Create a Vector3 object, with default 0,0,0 coordinates.
	 */
	public Vector3() {
		super();
		this.z = 0;
	}

	/**
	 * Create a Vector3 object.
	 * @param x X coordinate.
	 * @param y Y coordinate.
	 * @param z Z coordinate.
	 */
	public Vector3(double x, double y, double z) {
		super(x, y);
		this.z = z;
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
        if (!(o instanceof Vector3)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members 
        Vector3 v3 = (Vector3) o;

        // Compare the data members and return accordingly 
        return this.x == v3.x && this.y == v3.y && this.z == v3.z;
    }

	/**
	 * Add another vector to this vector and produce a new vector from the result.
	 * @param otherVector The other vector to add.
	 * @return outputVector The output vector.
	 */
	public Vector3 add(Vector3 otherVector)
	{
		return new Vector3(
			this.x + otherVector.x,
			this.y + otherVector.y,
			this.z + otherVector.z
		);
	}

	/**
	 * Subtract another vector from this vector and produce a new vector from the result.
	 * @param otherVector The other vector to subtract.
	 * @return outputVector The output vector.
	 */
	public Vector3 subtract(Vector3 otherVector)
	{
		return new Vector3(
			this.x - otherVector.x,
			this.y - otherVector.y,
			this.z - otherVector.z
		);
	}

	public Vector3 rotateAroundOrigin(Euler rotation) {
		double cosYaw = Math.cos(rotation.yaw);
		double sinYaw = Math.sin(rotation.yaw);

		double cosPitch = Math.cos(rotation.pitch);
		double sinPitch = Math.sin(rotation.pitch);

		double cosRoll = Math.cos(rotation.roll);
		double sinRoll = Math.sin(rotation.roll);

		double xX = cosYaw * cosPitch;
		double xY = cosYaw * sinPitch * sinRoll - sinYaw * cosRoll;
		double xZ = cosYaw * sinPitch * cosRoll + sinYaw * sinRoll;

		double yX = sinYaw * cosPitch;
		double yY = sinYaw * sinPitch * sinRoll + cosYaw * cosRoll;
		double yZ = sinYaw * sinPitch * cosRoll - cosYaw * sinRoll;

		double zX = -sinPitch;
		double zY = cosPitch * sinRoll;
		double zZ = cosPitch * cosRoll;

		return new Vector3(
				xX * this.x + xY * this.y + xZ * this.z,
				yX * this.x + yY * this.y + yZ * this.z,
				zX * this.x + zY * this.y + zZ * this.z
		);
	}
}
