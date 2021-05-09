/**
 * 
 */
package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * represent Direction Light, extends Light implements LightSource 
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */
public class DirectionalLight extends Light implements LightSource {

	/**
	 * direction Vector
	 */
	private Vector direction;
	/**
	 * constructor
	 * @param intensity
	 * @param direction 
	 */
	public DirectionalLight(Vector direction, Color intensity) {
		super(intensity);
		this.direction = direction.normalized();
	}

	@Override
	public Color getIntensity(Point3D p) {
		return getIntensity();
	}

	@Override
	public Vector getL(Point3D p) {
		return direction;
	}

}
