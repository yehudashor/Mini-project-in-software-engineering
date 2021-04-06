/**
 * 
 */
package geometries;

import java.util.List;
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
	List<Point3D> findIntersections(Ray ray);
}
