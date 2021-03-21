/**
 * 
 */
package unitests;

import static java.lang.System.out;
import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Point3D;
import primitives.Vector;

/**
 * Testing point
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */
public class Point3DTests {

	/**
	 * Test method for {@link primitives.Point3D#subtract(primitives.Point3D)}.
	 */
	@Test
	public void testSubtract() {
		/**
		 * TC 01 --- the result is subtract.
		 */
		Point3D p1 = new Point3D(1, 2, 3);
		assertFalse("Point - Point does not work correctly",
				!new Vector(1, 1, 1).equals(new Point3D(2, 3, 4).subtract(p1)));
	}

	/**
	 * Test method for {@link primitives.Point3D#add(primitives.Vector)}.
	 */
	@Test
	public void testAdd() {
		/**
		 * TC 01 --- the result is the zero point.
		 */
		Point3D p1 = new Point3D(1, 2, 3);
		assertEquals("Point + Vector does not work correctly", Point3D.ZERO, p1.add(new Vector(-1, -2, -3)));
	}
}
