/**
 * 
 */
package unitests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import geometries.Plane;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * Testing Plane
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 *
 */
public class PlaneTest {

	/**
	 * Test method for
	 * {@link geometries.Plane#Plane(primitives.Point3D, primitives.Point3D, primitives.Point3D)}.
	 */
	@Test
	public void testPlanePoint3DPoint3DPoint3D() {
		// ============ Equivalence Partitions Tests ==============

		// TC 01: tests the three points which given are not on the same line
		Point3D x = new Point3D(1, 2, 3);
		Point3D y = new Point3D(2, 4, 6);
		Point3D z = new Point3D(-1.5, -3, -4.5);

		assertThrows("illgual prameters, constructor failed", IllegalArgumentException.class, () -> new Plane(x, y, z));
	}

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormalPoint3D() {
		// ============ Equivalence Partitions Tests ==============

		// TC 01: tests the calculation of the normal
		Point3D a = new Point3D(1, 2, 3);
		Point3D b = new Point3D(2, 1, 4);
		Point3D c = new Point3D(2, 1, 1);

		Plane plane = new Plane(a, b, c);
		assertEquals("wrong calculation normal", new Vector(3, 3, 0).normalize(), plane.getNormal(a));

	}

	/**
	 * Test method for {@link geometries.Plane#findIntersections(primitives.Ray)}.
	 */
	@Test
	public void testFindIntersections() {
		Plane pln = new Plane(new Point3D(1,0,2), new Vector(0,0,1));
		Vector v = new Vector(-1,1,1);
		Ray r = new Ray(new Point3D(4,2,1), v);
		Point3D p = new Point3D(3,3,2);

		// ============ Equivalence Partitions Tests ==============

		// TC01: Ray start before the Plane (1 Point)
		assertEquals("Ray start before the Plane", p, pln.findIntersections(r).get(0));
		
		// TC02: Ray start after the Plane (0 Point)
		r = new Ray(new Point3D(1,5,4), v);
		assertNull("Ray start after the Plane", pln.findIntersections(r));
		
		// =============== Boundary Values Tests ==================
		
		// TC03: Ray contained in the plane (0 point)
		v = new Vector(1,1,0);
		r = new Ray(p, v);
		assertNull("Ray contained in the plane", pln.findIntersections(r));
		
		// TC04: Ray starts at the plane in point p0 (0 point)
		p = new Point3D(1,0,2);
		r = new Ray(p, v);
		assertNull("Ray start after the Plane", pln.findIntersections(r));
		
		
		
		// TC05: Ray parallel to the plane (0 point)
		
		
		// TC06
		
		// TC07
		
		// TC08
	}

}
