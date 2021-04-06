/**
 * 
 */
package unitests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Plane;
import primitives.Point3D;
import primitives.Vector;

/**
 * Testing Plane
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

}
