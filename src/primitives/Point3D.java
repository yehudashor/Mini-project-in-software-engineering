package primitives;

import java.lang.Math;

public class Point3D {

	static Point3D zero = new Point3D(0, 0, 0);

	Coordinate x;
	Coordinate y;
	Coordinate z;

	/*
	 * 
	 */
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/*
	 * 
	 */
	public Point3D(double x, double y, double z) {
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
		this.z = new Coordinate(z);
	}

	@Override
	public String toString() {
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Point3D))
			return false;
		Point3D p = (Point3D) obj;
		return this.x.equals(p.x) && this.y.equals(p.y) && this.z.equals(p.z);
	}

	/*
	 * 
	 */
	public Vector subtract(Point3D point) {
		return new Vector(point.x.coord - this.x.coord, point.y.coord - this.y.coord, point.z.coord - this.z.coord);
	}

	/*
	 * 
	 */
    public Point3D add(Vector vector) {
    	return new Point3D(this.x.coord + vector.point.x.coord, this.y.coord + vector.point.y.coord,
    			this.z.coord + vector.point.z.coord);
    }
    
    /*
     * 
     */
    public double distanceSquared(Point3D point){
    	return (this.x.coord - point.x.coord) * (this.x.coord - point.x.coord) +
    			(this.y.coord - point.y.coord) * (this.y.coord - point.y.coord)
    			+ (this.z.coord - point.z.coord) * (this.z.coord - point.z.coord);
    }
    
    /*
     * 
     */
    public double distance(Point3D point) {
    	return Math.sqrt(this.distance(point));
    }
}
