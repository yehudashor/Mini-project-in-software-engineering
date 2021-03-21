package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * represent Cylinder
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 */
public class Cylinder extends Tube /* implements Geometry */ {
	/**
	 * Height of the Cylinder
	 */
	double height;

	/**
	 * constructor
	 * 
	 * @param axisRay axis of the cylinder
	 * @param radius  radius of the cylinder
	 * @param height  height of the Cylinder
	 */
	public Cylinder(Ray axisRay, double radius, double height) {
		super(axisRay, radius);
		this.height = height;
	}

	@Override
	public Vector getNormal(Point3D point) {
		return super.getNormal(point);
	}

}
