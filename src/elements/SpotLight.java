/**
 * 
 */
package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;
import static primitives.Util.*;

/**
 * represent Spot Light, extends PointLight
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */
public class SpotLight extends PointLight {

	/**
	 * Direction Vector
	 */
	private Vector direction;

	/**
	 * constructor
	 * 
	 * @param intensity
	 * @param position
	 * @param kC
	 * @param kL
	 * @param kQ
	 * @param diretion
	 */
	public SpotLight(Color intensity, Point3D position, double kC, double kL, double kQ, Vector diretion) {
		super(intensity, position, kC, kL, kQ);
		this.direction = diretion.normalized();
	}

	@Override
	public Color getIntensity(Point3D p) {
		double d = direction.dotProduct(getL(p));
		return alignZero(d) > 0 ? super.getIntensity().scale(d) : Color.BLACK;
	}

}
