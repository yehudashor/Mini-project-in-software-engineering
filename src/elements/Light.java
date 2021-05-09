/**
 * 
 */
package elements;

import primitives.Color;

/**
 * represent light
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */
 abstract class Light {
	
	/**
	 * intensity
	 */
	private Color intensity;


	/**
	 * constructor
	 * @param intensity
	 */
	protected Light(Color intensity) {
		this.intensity = intensity;
	}
	
	/**
	 * get intensity
	 * @return the intensity
	 */
	public Color getIntensity() {
		return intensity;
	}

	
	
	

}
