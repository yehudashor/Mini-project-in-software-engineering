package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere implements Geometry {
	private Point3D center;
	private double radius;

	/**
	 * 
	 * 
	 * @param center
	 * @param radius
	 */
	public Sphere(Point3D center, double radius) {
		super();
		this.center = center;
		this.radius = radius;
	}

	@Override
	public Vector getNormal(Point3D point) {
		return null;
	}

}
