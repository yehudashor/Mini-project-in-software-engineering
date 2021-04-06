package geometries;

import primitives.Point3D;

/**
 * represent triangle
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */
public class Triangle extends Polygon {
	/**
	 * constructor
	 * @param a point a
	 * @param b point b
	 * @param c point c
	 */
	public Triangle(Point3D a, Point3D b, Point3D c) {
		super(a, b, c);
	}

}
