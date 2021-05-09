/**
 * 
 */
package elements;

import primitives.Color;

/**
 * represent Ambient Light extends from Light class
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 *
 */
public class AmbientLight extends Light {

	/**
	 * Ambient Light
	 * @param iA
	 * @param kA
	 */
	public AmbientLight(Color iA, double kA) {
		super(iA.scale(kA));
	} 
}
