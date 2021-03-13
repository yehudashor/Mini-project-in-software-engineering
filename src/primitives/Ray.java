package primitives;

/**
 * 
 * @authors Yehuda Shor and Israel Cohen
 * Ray class represents a ray   
 */
public class Ray {
	private Point3D p0;  // represent start point
	private Vector dir;  // direction vector
	
	/**
	 * constructor
	 * @param p0 - point
	 * @param dir - direction vector
	 */
	public Ray(Point3D p0, Vector dir) {
		this.p0 = p0;
		this.dir = dir.normalize();
	}

	/**
	 * @return the point - p0
	 */
	public Point3D getP0() {
		return p0;
	}

	/**
	 * @return the direction vector - dir
	 */
	public Vector getDir() {
		return dir;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Ray))
			return false;
		Ray p = (Ray) obj;
		return this.dir.equals(p.dir) && this.p0.equals(p.p0);
	}

	@Override
	public String toString() {
		return "Ray [p0=" + p0 + ", dir=" + dir + "]";
	}
	
	

}
