package geometries;

import primitives.*;

public class Plane implements Geometry {

	private Point3D q0;
	private Vector normal;

	/**
	 * @param q0
	 * @param normal
	 */
	public Plane(Point3D q0, Vector normal) {
		this.q0 = q0;
		this.normal = normal;
	}

	/**
	 * 
	 * @param q0
	 * @param q1
	 * @param q2
	 */
	public Plane(Point3D q0, Point3D q1, Point3D q2) {
		normal = null;
		this.q0 = q0;
	}

	/**
	 * @return the q0
	 */
	public Point3D getQ0() {
		return q0;
	}

	/**
	 * @return the normal
	 */
	public Vector getNormal() {
		return normal;
	}

	@Override
	public String toString() {
		return "Plane [q0=" + q0 + ", normal=" + normal + "]";
	}

	@Override
	public Vector getNormal(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	}

}
