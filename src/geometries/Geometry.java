package geometries;

import primitives.*;

/**
 * interface to geometry shapes
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */
public interface Geometry extends Intersectable {
	/**
	 * get normal to a shape in some point
	 * 
	 * @param point on the surface of the shape, we assume that the point which
	 *              given is on surface
	 * @return the normal to shape at a point
	 */
	Vector getNormal(Point3D point);
}
