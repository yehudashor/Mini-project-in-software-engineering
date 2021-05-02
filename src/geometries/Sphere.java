package geometries;

import java.util.List;
import primitives.*;
import static primitives.Util.*;

/**
 * represent sphere
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 *
 */
public class Sphere extends Geometry {
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
	public List<GeoPoint> findGeoIntersections(Ray ray) {
		Vector u;
		try {
			u = center.subtract(ray.getP0());
		} catch (IllegalArgumentException e) {
			return List.of(new GeoPoint(this, ray.getPoint(radius)));
		}

		double dis = ray.getDir().dotProduct(u);
		double d = Math.sqrt(u.lengthSquared() - dis * dis);
		if (alignZero(d - radius) >= 0)
			return null;

		double innerDis = Math.sqrt(radius * radius - d * d);
		double scal2 = alignZero(dis + innerDis);
		if (scal2 <= 0)
			return null;

		double scal1 = alignZero(dis - innerDis);

		return scal1 <= 0 //
				? List.of(new GeoPoint(this, ray.getPoint(scal2))) //
				: List.of(new GeoPoint(this, ray.getPoint(scal1)), //
						new GeoPoint(this, ray.getPoint(scal2)));
	}

}
