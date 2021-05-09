/**
 * 
 */
package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * represent Point Light, extends Light implements LightSource
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */
public class PointLight extends Light implements LightSource {
	/**
	 * Position point
	 */
	private Point3D position;

	/**
	 * Discount coefficients
	 */
	private double kC = 1, kL = 0, kQ = 0;

	/**
	 * constructor
	 * 
	 * @param intensity
	 * @param position
	 * @param kC
	 * @param kL
	 * @param kQ
	 */
	public PointLight(Color intensity, Point3D position, double kC, double kL, double kQ) {
		super(intensity);
		this.position = position;
		this.kC = kC;
		this.kL = kL;
		this.kQ = kQ;
	}

	@Override
	public Color getIntensity(Point3D p) {
		double d = position.distance(p);
		return getIntensity().reduce(kC + kL * d + kQ * d * d);
	}

	@Override
	public Vector getL(Point3D p) {
		return p.subtract(position).normalize();
	}

}
