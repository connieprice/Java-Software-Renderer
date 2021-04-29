package uk.co.connieprice.javasoftwarerenderer.math;

public class Vector2 {
	public double x;
	public double y;

	public Vector2() {
		this.x = 0;
		this.y = 0;
	}

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

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

	public static Vector2 add(Vector2 v1, Vector2 v2)
	{
		return new Vector2(v1.x + v2.x, v1.y + v2.y);
	}

	public static Vector2 subtract(Vector2 v1, Vector2 v2)
	{
		return new Vector2(v1.x - v2.x, v1.y - v2.y);
	}
}
