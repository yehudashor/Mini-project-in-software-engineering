package geometries;

import java.util.ArrayList;
import java.util.List;

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
		this.normal = normal.normalized();
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

	@Override
	public List<Point3D> findIntersections(Ray ray) {
		double numerator;
		try {
			numerator = normal.dotProduct(q0.subtract(ray.getP0()));
		} catch (IllegalArgumentException e) {
			return null;
		}
		double denumerator = normal.dotProduct(ray.getDir());
		if( Util.isZero(numerator) || Util.alignZero(denumerator) == 0 || numerator / denumerator < 0 )
			return null;
		
		//if(normal.dotProduct(ray.getDir()) == 0)
			//return null;
		
		double dis = numerator / denumerator;
		
		List<Point3D> intersection = new ArrayList<>();
		intersection.add(ray.getP0().add(ray.getDir().scale(dis)));		
		return intersection;
		
	}

}
