package uk.co.connieprice.javasoftwarerenderer.math;

public class Vector3 extends Vector2{
	public double z;

	public Vector3() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}

	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

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
        return Double.compare(this.x, v3.x) == 0 && Double.compare(this.y, v3.y) == 0 && Double.compare(this.z, v3.z) == 0;
    }

	public static Vector3 add(Vector3 v1, Vector3 v2)
	{
		return new Vector3(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
	}

	public static Vector3 subtract(Vector3 v1, Vector3 v2)
	{
		return new Vector3(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
	}
}
