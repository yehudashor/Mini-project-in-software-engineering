package geometries;

import java.util.ArrayList;
import java.util.List;
import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
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

	@Override
	public List<Point3D> findIntersections(Ray ray) {
		Vector u;
		try {
			u = center.subtract(ray.getP0());

		} catch (IllegalArgumentException e) {
			List<Point3D> intersections = new ArrayList<Point3D>();
			intersections.add(center.add(ray.getDir().scale(radius)));
			return intersections;

		}
		double dis = ray.getDir().dotProduct(u);
		double d = Math.sqrt(u.lengthSquared() - dis * dis);
		if (Util.isZero(d - radius) || d - radius >= 0)
			return null;

		double innerDis = Math.sqrt(radius * radius - d * d);
		double scal1 = dis - innerDis;
		double scal2 = dis + innerDis;
		Point3D a = null, b = null;

		if (!Util.isZero(scal1) && scal1 > 0) {
			a = ray.getP0().add(ray.getDir().scale(scal1));
		}

		if (!Util.isZero(scal2) && scal2 > 0) {
			b = ray.getP0().add(ray.getDir().scale(scal2));
		}

		if (a == null && b == null)
			return null;

		List<Point3D> intersections = new ArrayList<Point3D>();
		if (a != null && !a.equals(ray.getP0()))
			intersections.add(a);
		if (b != null && !b.equals(ray.getP0()))
			intersections.add(b);
		return intersections;

	}

}
