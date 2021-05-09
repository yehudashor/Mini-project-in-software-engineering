package primitives;

import java.util.List;
import java.util.stream.Collectors;

import geometries.Intersectable.GeoPoint;

/**
 * Ray class represents a ray
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 */
public class Ray {
	/**
	 * represent start point
	 */
	private Point3D p0;
	/**
	 * direction vector
	 */
	private Vector dir;

	/**
	 * constructor
	 * 
	 * @param p0  - point
	 * @param dir - direction vector
	 */
	public Ray(Point3D p0, Vector dir) {
		this.p0 = p0;
		this.dir = dir.normalized();
	}

	/**
	 * get p0
	 * 
	 * @return the point - p0
	 */
	public Point3D getP0() {
		return p0;
	}

	/**
	 * get direction vector
	 * 
	 * @return the direction vector - dir
	 */
	public Vector getDir() {
		return dir;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Ray))
			return false;
		Ray p = (Ray) obj;
		return this.dir.equals(p.dir) && this.p0.equals(p.p0);
	}

	@Override
	public String toString() {
		return "Ray [p0=" + p0 + ", dir=" + dir + "]";
	}

	/**
	 * calculate
	 * 
	 * @param t
	 * @return
	 */
	public Point3D getPoint(double t) {
		return p0.add(dir.scale(t));
	}

	/**
	 * Find the Closest Point to the beginning of the ray
	 * 
	 * @param points List of points on the Ray
	 * @return the closest point to the beginning of the ray
	 */
	public Point3D findClosestPoint(List<Point3D> points) {
		if (points == null)
			return null;

		return getClosestGeoPoint(points //
				.stream() //
				.map(p -> new GeoPoint(null, p)) //
				.collect(Collectors.toList())).point;
	}

	/**
	 * Find the Closest Point to the beginning of the ray
	 * 
	 * @param points List of points on the Ray
	 * @return the closest point to the beginning of the ray
	 */
	public GeoPoint getClosestGeoPoint(List<GeoPoint> points) {
		if (points == null)
			return null;

		GeoPoint closest = null;
		double minDistance = Double.POSITIVE_INFINITY;
		for (var p : points) {
			double d = p0.distance(p.point);
			if (minDistance > d) {
				closest = p;
				minDistance = d;
			}
		}

		return closest;
	}

}
