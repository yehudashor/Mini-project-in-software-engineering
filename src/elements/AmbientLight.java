/**
 * 
 */
package elements;

import primitives.Color;

/**
 * represent Ambient Light
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 *
 */
public class AmbientLight {
	
	/**
	 * intensity of the color from Ambient Light.
	 */
	private Color intensity;

	/**
	 * Ambient Light
	 * @param iA
	 * @param kA
	 */
	public AmbientLight(Color iA, double kA) {
		intensity = iA.scale(kA);
	}

	/**
	 * get intensity
	 * @return the intensity
	 */
	public Color getIntensity() {
		
		return intensity;
	} 
}
