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
 * @author Yehuda Shor and Israel Cohen
 *
 */
public class Point3DTests {

	/**
	 * Test method for {@link primitives.Point3D#subtract(primitives.Point3D)}.
	 */
	@Test
	public void testSubtract() {
		/**
		 * TC1 --- the result is subtract.
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
		 * TC1 --- the result is the zero point.
		 */
		  Point3D p1 = new Point3D(1, 2, 3);
		  assertEquals("Point + Vector does not work correctly", Point3D.ZERO, p1.add(new Vector(-1, -2, -3)));
	}
}
