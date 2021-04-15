/**
 * 
 */
package geometries;

import java.util.LinkedList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;

/**
 * Class to geometry shapes
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */

public class Geometries implements Intersectable {

	/**
	 * List of shapes
	 */
	List<Intersectable> intersectable;

	/**
	 * Default constructor
	 */
	public Geometries() {
		intersectable = new LinkedList<Intersectable>();
	}

	/**
	 * constructor
	 * 
	 * @param geometries : shapes
	 */
	public Geometries(Intersectable... geometries) {
		intersectable = List.of(geometries);
	}

	/**
	 * add shapes
	 * @param geometries : shapes to add
	 */
	public void add(Intersectable... geometries) {
		intersectable.addAll(List.of(geometries));
	}
	
	@Override
	public List<Point3D> findIntersections(Ray ray) {
		if (intersectable.size() == 0)
			return null;
		
		List<Point3D> points = null;
		
		for (Intersectable it : intersectable) {
			var points1 = it.findIntersections(ray);
			if (points1 != null) {
				if (points == null)
					points = new LinkedList<Point3D>();
				points.addAll(points1);
			}
		}

		return points;
	}

}
