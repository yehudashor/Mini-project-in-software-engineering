/**
 * 
 */
package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

/**
 * represent Ray Tracer Base
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 *
 */
public abstract class RayTracerBase {

	/**
	 * scene
	 */
	protected Scene scene;

	/**
	 * constructor
	 * @param scene
	 */
	public RayTracerBase(Scene scene) {
		this.scene = scene;
	}

	/**
	 * 
	 * @param ray
	 * @return
	 */
	public abstract Color traceRay(Ray ray);

}
