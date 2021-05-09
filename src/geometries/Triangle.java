package geometries;

import java.util.List;
import primitives.*;
import static primitives.Util.*;

/**
 * represent triangle
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */
public class Triangle extends Polygon {
	/**
	 * constructor
	 * 
	 * @param a point a
	 * @param b point b
	 * @param c point c
	 */
	public Triangle(Point3D a, Point3D b, Point3D c) {
		super(a, b, c);
	}

	@Override
	public List<GeoPoint> findGeoIntersections(Ray ray) {
		List<GeoPoint> intersection = plane.findGeoIntersections(ray);

		if (intersection != null) {
			Point3D p0 = ray.getP0();
			Vector v = ray.getDir();
			Vector v1 = vertices.get(0).subtract(p0);
			Vector v2 = vertices.get(1).subtract(p0);
			Vector v3 = vertices.get(2).subtract(p0);
			Vector n1 = v1.crossProduct(v2);
			Vector n2 = v2.crossProduct(v3);
			Vector n3 = v3.crossProduct(v1);
			double s1 = alignZero(v.dotProduct(n1));
			double s2 = alignZero(v.dotProduct(n2));
			double s3 = alignZero(v.dotProduct(n3));

			if ((s1 > 0 && s2 > 0 && s3 > 0) || (s1 < 0 && s2 < 0 && s3 < 0)) {
				intersection.get(0).geometry = this;
				return intersection;
			}
			return null;
		}

		return null;
	}
}
