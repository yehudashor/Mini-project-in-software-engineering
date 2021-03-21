package geometries;

import primitives.*;
/**
 * represent plane
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 */
public class Plane implements Geometry {
	/**
	 * point in the plane 
	 */
	private Point3D q0;
	/**
	 * normal to the plane
	 */
	private Vector normal;

	/**
	 * constructor, gets Point3D and Vector
	 * 
	 * @param q0 point
	 * @param normal normal to the plane
	 */
	public Plane(Point3D q0, Vector normal) {
		this.q0 = q0;
		this.normal = normal;
	}

	/**
	 * constructor, gets 3 parameters Point3D type
	 * 
	 * @param q0 first point, saved in q0 fields 
	 * @param q1 second point
	 * @param q2 third point
	 */
	public Plane(Point3D q0, Point3D q1, Point3D q2) {
		Vector v = q0.subtract(q1);
		Vector u = q0.subtract(q2);
		normal = v.crossProduct(u).normalize();
		this.q0 = q0;
	}

	/**
	 * get q0
	 * @return the q0
	 */
	public Point3D getQ0() {
		return q0;
	}

	/**
	 * getNormal, class method
	 * @return the normal to the plane
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
		return normal;
	}

}
