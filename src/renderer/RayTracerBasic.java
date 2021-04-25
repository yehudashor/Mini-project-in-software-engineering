/**
 * 
 */
package renderer;

import java.util.List;

import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

/**
 * represent Ray Tracer Basic which extends RayTracerBase
 *
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 */

public class RayTracerBasic extends RayTracerBase {

	/**
	 * constructor
	 * @param scene
	 */
	public RayTracerBasic(Scene scene) {
		super(scene);
	}
	
	@Override
	public Color traceRay(Ray ray) {
		List<Point3D> intersections = scene.geometries.findIntersections(ray);
		if (intersections == null) {
			return scene.background;
		}
		Point3D closestPoint = ray.findClosestPoint(intersections);
		return calcColor(closestPoint);
	}

	/**
	 * help function that calculate the color of the Point
	 * @param closest Point
	 * @return final color in the point
	 */
	private Color calcColor(Point3D closestPoint) {
		return scene.ambientLight.getIntensity();
	}

}
