package primitives;

import java.lang.Math;

/**
 * A class describing a point in three dimensions
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 */
public class Point3D {

	/**
	 * represents the zero point
	 */
	public static Point3D ZERO = new Point3D(0, 0, 0);

	/**
	 * Coordinate x
	 */
	final Coordinate x;
	/**
	 * Coordinate y
	 */
	final Coordinate y;
	/**
	 * Coordinate z
	 */
	final Coordinate z;

	/**
	 * constructor, gets parameters of coordinate type
	 * 
	 * @param x Coordinate x
	 * @param y Coordinate y
	 * @param z Coordinate z
	 */
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * constructor, gets parameters of double type
	 * 
	 * @param x Coordinate x
	 * @param y Coordinate y
	 * @param z Coordinate z
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

	/**
	 * subtract a point from vector
	 * 
	 * @param point to subtract
	 * @return new vector
	 */
	public Vector subtract(Point3D point) {
		return new Vector(this.x.coord - point.x.coord, this.y.coord - point.y.coord, this.z.coord - point.z.coord);
	}

	/**
	 * add a vector to a point
	 * 
	 * @param vector to add
	 * @return new point
	 */
	public Point3D add(Vector vector) {
		return new Point3D(this.x.coord + vector.getHead().x.coord, this.y.coord + vector.getHead().y.coord,
				this.z.coord + vector.getHead().z.coord);
	}

	/**
	 * calculate the square distance between 2 points
	 * 
	 * @param point the other point
	 * @return the square distance
	 */
	public double distanceSquared(Point3D point) {
		return (this.x.coord - point.x.coord) * (this.x.coord - point.x.coord)
				+ (this.y.coord - point.y.coord) * (this.y.coord - point.y.coord)
				+ (this.z.coord - point.z.coord) * (this.z.coord - point.z.coord);
	}

	/**
	 * calculate the distance between 2 points
	 * 
	 * @param point the other point
	 * @return the distance
	 */
	public double distance(Point3D point) {
		return Math.sqrt(this.distanceSquared(point));
	}
}
