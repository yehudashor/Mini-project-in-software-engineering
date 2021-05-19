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
	public PointLight(Color intensity, Point3D position) {
		super(intensity);
		this.position = position;
	}

	/**
	 * set
	 * 
	 * @param kC the kC to set
	 * @return this
	 */
	public PointLight setkC(double kC) {
		this.kC = kC;
		return this;
	}

	/**
	 * set
	 * 
	 * @param kL the kL to set
	 * @return this
	 */
	public PointLight setkL(double kL) {
		this.kL = kL;
		return this;
	}

	/**
	 * set
	 * 
	 * @param kQ the kQ to set
	 * @return this
	 */
	public PointLight setkQ(double kQ) {
		this.kQ = kQ;
		return this;
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

	@Override
	public double getDistance(Point3D point) {
		return position.distance(point);
	}
}
