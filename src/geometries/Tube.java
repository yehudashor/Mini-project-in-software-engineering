package geometries;

import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;


/**
 * Tube class represent tube
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 *
 */
public class Tube implements Geometry {
	/**
	 * axis of the tube
	 */
	protected Ray axisRay;
	/**
	 * radius of the tube
	 */
	protected double radius;

	/**
	 * constructor
	 * 
	 * @param axisRay axis of the tube
	 * @param radius  radius of the tube
	 */
	public Tube(Ray axisRay, double radius) {
		super();
		this.axisRay = axisRay;
		this.radius = radius;
	}

	@Override
	public Vector getNormal(Point3D point) {
		double dif = this.axisRay.getDir().dotProduct(point.subtract(this.axisRay.getP0()));

		if (!primitives.Util.isZero(dif)) {
			Point3D p = this.axisRay.getP0().add(this.axisRay.getDir().scale(dif));
			return point.subtract(p).normalize();
		} else {
			return point.subtract(this.axisRay.getP0()).normalize();
		}
	}

	@Override
	public List<Point3D> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}

}
