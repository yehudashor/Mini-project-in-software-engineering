package primitives;

import java.lang.Math;

/**
 * Vector class represents vector
 * 
 * @authors Yehuda Shor and Israel Cohen
 */
public class Vector {
	/**
	 * the vertex of the vector
	 */
	private Point3D head;

	/**
	 * constructor, gets parameters of coordinate type
	 * 
	 * @param x Coordinate x
	 * @param y Coordinate y
	 * @param z Coordinate z
	 * @throws IllegalArgumentException exception in case the coordinates are
	 *                                  (0,0,0)
	 */
	public Vector(Coordinate x, Coordinate y, Coordinate z) {
		head = new Point3D(x, y, z);
		if (head.equals(Point3D.ZERO)) {
			throw new IllegalArgumentException("Illegal Vector");
		}
	}

	/**
	 * get head
	 * 
	 * @return the head
	 */
	public Point3D getHead() {
		return head;
	}

	/**
	 * constructor, gets 3 parameters of double type
	 * 
	 * @param x Coordinate x
	 * @param y Coordinate y
	 * @param z Coordinate z
	 * @throws IllegalArgumentException exception in case the coordinates are
	 *                                  (0,0,0)
	 */
	public Vector(double x, double y, double z) {
		head = new Point3D(x, y, z);

		if (head.equals(Point3D.ZERO)) {
			throw new IllegalArgumentException("Illegal Vector");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Vector))
			return false;
		Vector p = (Vector) obj;
		return this.head.equals(p.head);
	}

	/**
	 * constructor, a parameter of point3D type
	 * 
	 * @param point for the head point
	 * @throws IllegalArgumentException exception in case the point is (0,0,0)
	 */
	public Vector(Point3D point) {
		if (point.equals(Point3D.ZERO)) {
			throw new IllegalArgumentException("Illegal Vector");
		}
		this.head = point;
	}

	/**
	 * vector addition
	 * 
	 * @param other vector to add
	 * @return a new vector
	 */
	public Vector add(Vector other) {
		return new Vector(this.head.add(other));
	}

	/**
	 * subtract a vector from the this vector
	 * 
	 * @param other vector to subtract
	 * @return a new vector
	 */
	public Vector subtract(Vector other) {
		return this.head.subtract(other.head);
	}

	/**
	 * vector multiplication in scalar
	 * 
	 * @param scaler to multiplicate
	 * @return new vector
	 */
	public Vector scale(double scaler) {
		return new Vector(scaler * this.head.x.coord, scaler * this.head.y.coord, scaler * this.head.z.coord);
	}

	/**
	 * scalar multiplication
	 * 
	 * @param other vector to multiplicate
	 * @return scalar
	 */
	public double dotProduct(Vector other) {
		return this.head.x.coord * other.head.x.coord + this.head.y.coord * other.head.y.coord
				+ this.head.z.coord * other.head.z.coord;
	}

	/**
	 * cross product
	 * 
	 * @param other vector to product
	 * @return new vector
	 */
	public Vector crossProduct(Vector other) {
		double point1 = this.head.y.coord * other.head.z.coord - this.head.z.coord * other.head.y.coord;
		double point2 = this.head.z.coord * other.head.x.coord - this.head.x.coord * other.head.z.coord;
		double point3 = this.head.x.coord * other.head.y.coord - this.head.y.coord * other.head.x.coord;
		return new Vector(point1, point2, point3);
	}

	/**
	 * @return the square length of the vector
	 */
	public double lengthSquared() {
		// the length of vector is dot product with itself
		return this.dotProduct(this);
	}

	/**
	 * calculate the length of the vector
	 * 
	 * @return the length of the vector
	 */
	public double length() {
		return Math.sqrt(this.lengthSquared());
	}

	/**
	 * normalize the vector
	 * 
	 * @return this vector normalized
	 */
	public Vector normalize() {
		double length = this.length();
		this.head = new Point3D(this.head.x.coord / length, this.head.y.coord / length,
				this.head.z.coord / length);
		return this;
	}

	/**
	 * normalize the vector
	 * 
	 * @return new normalized vector with same direction of this vector
	 */
	public Vector normalized() {
		return new Vector(this.head).normalize();
	}

}
