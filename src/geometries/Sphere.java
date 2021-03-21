package geometries;

import primitives.Point3D;
import primitives.Vector;

/**
 * represent sphere
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 *
 */
public class Sphere implements Geometry {
	/**
	 * center point of the sphere
	 */
	private Point3D center;
	/**
	 * radius of the sphere
	 */
	private double radius;

	/**
	 * constructor
	 * 
	 * @param center point
	 * @param radius of the sphere
	 */
	public Sphere(Point3D center, double radius) {
		super();
		this.center = center;
		this.radius = radius;
	}

	@Override
	public Vector getNormal(Point3D point) {
		return point.subtract(this.center).normalize();
	}

}
