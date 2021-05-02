/**
 * 
 */
package geometries;

import java.util.List;
import java.util.stream.Collectors;

import primitives.Point3D;
import primitives.Ray;

/**
 * interface for intersection between ray and geometry shapes
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 */
public interface Intersectable {
	/**
	 * Find intersection points between ray and geometry shapes
	 * @param ray which checked if it intersect
	 * @return List of intersection points, in case there is no intersections return null
	 */
	default List<Point3D> findIntersections(Ray ray) { 
		 var geoList = findGeoIntersections(ray); 
		 return geoList == null ? null 
		 : geoList.stream().map(gp -> gp.point).collect(Collectors.toList()); 
		}

	
	/*
	 * Find intersection points between ray and geometry shapes
	 * @param ray which checked if it intersect
	 * @return List of intersection points, in case there is no intersections return null
	 */
	List<GeoPoint> findGeoIntersections(Ray ray);
	
	/**
	 * Class GeoPoint
	 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
	 * @authors Israel Cohen 203250170 josh50170@gmail.com *
	 *
	 */
	public static class GeoPoint {
		/**
		 * geometry
		 */
		public Geometry geometry;

		/**
		 * point
		 */
		public Point3D point;

		/**
		 * constructor
		 * @param geometry
		 * @param point
		 */
		public GeoPoint(Geometry geometry, Point3D point) {
			this.geometry = geometry;
			this.point = point;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null || !(obj instanceof GeoPoint))
				return false;
			 GeoPoint g = (GeoPoint) obj;
			 return g.point == this.point && g.geometry == this.geometry;
		}
	}
}
