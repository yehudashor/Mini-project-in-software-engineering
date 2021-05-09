/**
 * 
 */
package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * represent Light Source
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com 
 */
public interface LightSource {
	/**
	 * Get intensity of light in a point
	 * @param p point 
	 * @return the actual color in the point
	 */
	public Color getIntensity(Point3D p);
	
	/**
	 * Get the direction of the light source
	 * @param p the point that lightning
	 * @return the direction Vector of the light source
	 */
	public Vector getL(Point3D p);

}
