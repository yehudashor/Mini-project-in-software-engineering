package geometries;

import java.util.List;

import primitives.*;

/**
 * represent plane
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 */
public class Plane extends Geometry {
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
	 * @param q0     point
	 * @param normal normal to the plane
	 */
	public Plane(Point3D q0, Vector normal) {
		this.q0 = q0;
		this.normal = normal.normalized();
	}

	/**
	 * constructor, gets 3 parameters Point3D type
	 * 
	 * @param q0 first point, saved in q0 fields
	 * @param q1 second point
	 * @param q2 third point
	 * @throws IllegalArgumentException if the points are on the same line by any
	 *                                  way
	 */
	public Plane(Point3D q0, Point3D q1, Point3D q2) {
		Vector v = q1.subtract(q0);
		Vector u = q2.subtract(q0);
		normal = v.crossProduct(u).normalize();
		this.q0 = q0;
	}

	/**
	 * get q0
	 * 
	 * @return the q0
	 */
	public Point3D getQ0() {
		return q0;
	}

	/**
	 * getNormal, class method
	 * 
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

	@Override
	public List<GeoPoint> findGeoIntersections(Ray ray) {
		double numerator;
		try {
			numerator = normal.dotProduct(q0.subtract(ray.getP0()));
		} catch (IllegalArgumentException e) {
			return null;
		}
		double denumerator = normal.dotProduct(ray.getDir());
		if (Util.isZero(numerator) || Util.isZero(denumerator))
			return null;

		double dis = Util.alignZero(numerator / denumerator);

		return dis <= 0 ? null : List.of(new GeoPoint(this, ray.getPoint(dis)));
	}

}
