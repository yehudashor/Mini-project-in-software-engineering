/**
 * 
 */
package unitests;

import static primitives.Util.*;
import static java.lang.System.out;
import static org.junit.Assert.*;
import static primitives.Util.isZero;

import org.junit.Test;

import primitives.Point3D;
import primitives.Vector;

/**
 * Testing Vector
 * 
 * @author Yehuda Shor and Israel Cohen
 *
 */
public class VectorTests {

	/**
	 * Test method for {@link primitives.Vector#add(primitives.Vector)}.
	 */
	@Test
	public void testAdd() {
		/**
		 * TC 01: test the result the zero vector
		 */
		Vector v1 = new Vector(1, 2, 3);
		assertThrows("Vector + Vector does not work correctly", IllegalArgumentException.class,
				() -> v1.add(new Vector(-1, -2, -3)));
		
		/**
		 * TC 02: test addition vector to another
		 */
		assertEquals("Vector + Vector does not work correctly", new Vector(3, 3, 3),
		 v1.add(new Vector(2,1,0)));
	}

	/**
	 * Test method for {@link primitives.Vector#subtract(primitives.Vector)}.
	 */
	@Test
	public void testSubtract() {
		/**
		 * TC 01: test subtract vector from another
		 */
		Vector v1 = new Vector(1, 2, 3);
		assertEquals("Vector - Vector does not work correctly", new Vector(3, 3, 3),
				v1.subtract(new Vector(-2, -1, 0)));
		
		/**
		 * TC 02: test the result the zero vector
		 */
		assertThrows("Vector - Vector does not work correctly", IllegalArgumentException.class,
				() -> v1.subtract(v1));
	}

	/**
	 * Test method for {@link primitives.Vector#scale(double)}.
	 */
	@Test
	public void testScale() {
		/**
		 * TC 01: test vector in scalar
		 */
		Vector v = new Vector(1, 2, 3);
		assertEquals("mulitiplication vector in scalar failed", new Vector(3.5, 7, 10.5), v.scale(3.5));
	}

	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	@Test
	public void testDotProduct() {
		/**
		 * TC 01: test dot-product
		 */
		Vector v1 = new Vector(1, 2, 3);
		Vector v2 = new Vector(3, 2, 1);
		assertEquals("dot-product vector in vector failed", 10, v1.dotProduct(v2), 0.0001);

		/**
		 * dot-Product for orthogonal vectors
		 */
		Vector v3 = new Vector(0, 3, -2);
		assertEquals("dot-product between vertical vectors failed", 0, v1.dotProduct(v3), 0.0001);
	}

	/**
	 * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 */
	@Test
	public void testCrossProduct() {
		/**
		 * TC 01: test cross-product
		 */
		Vector v1 = new Vector(1, 2, 3);
		Vector v2 = new Vector(3, 2, 1);
		assertEquals("cross-product vector in vector failed", new Vector(-4, 8, -4), v1.crossProduct(v2));

		/**
		 * TC 02: test orthogonal to its operands
		 */
		assertEquals("crossProduct() result is not orthogonal to its operands\"", true,
				isZero(v1.crossProduct(v2).dotProduct(v1)) && isZero(v1.crossProduct(v2).dotProduct(v2)));
	}

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	public void testLengthSquared() {
		/**
		 * TC: 01 test length square
		 */
		assertEquals("the calculation of length squated incorrect", 16.25, new Vector(1, 2.5, 3).lengthSquared(),
				0.0001);
	}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 */
	@Test
	public void testLength() {
		/**
		 * TC: 01 test length
		 */
		assertEquals("the calculation of length incorrect", Math.sqrt(16.25), new Vector(1, 2.5, 3).length(), 0.0001);
	}

	/**
	 * Test method for {@link primitives.Vector#normalize()}.
	 */
	@Test
	public void testNormalize() {

		/**
		 * TC1 --- function don't creates a new vector.
		 */
		Vector v = new Vector(1, 2, 3);
		Vector vCopy = new Vector(v.getHead());
		Vector vCopyNormalize = vCopy.normalize();
		assertSame("normalize() function creates a new vector", vCopy, vCopyNormalize);

		/**
		 * TC2 --- the result of length is one.
		 */
		assertTrue("normalize() result is not a unit vector", isZero(vCopyNormalize.length() - 1));
	}

	/**
	 * Test method for {@link primitives.Vector#normalized()}.
	 */
	@Test
	public void testNormalized() {
		/**
		 * TC1 --- function creates a new vector
		 */
		Vector v = new Vector(1, 2, 3);
		Vector u = v.normalized();
		assertNotSame("normalizated() function does not create a new vector", u, v);
	}

}
