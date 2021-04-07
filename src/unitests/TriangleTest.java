/**
 * 
 */
package unitests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Polygon;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author josh5
 *
 */
public class TriangleTest {

	/**
	 * Test method for {@link geometries.Polygon#findIntersections(primitives.Ray)}.
	 */
	@Test
	public void testFindIntersections() {
		Triangle t = new Triangle(new Point3D(1,0,2),new Point3D(-3,-1,2), new Point3D(-2, 3 , 2));
		Point3D rayPoint = new Point3D(3,2,1);
		Ray r = new Ray(rayPoint, new Vector(-5,0,1));
		Point3D p = new Point3D(-2, 2, 2);
		
		// ============ Equivalence Partitions Tests ==============
		
		// TC01: Ray's Intersect the triangle (1 points)
		assertEquals("Ray's start before the triangle and Intersect", p, t.findIntersections(r).get(0));	
		
		// TC02: Ray's Intersect against the edge (0 points)
		 r = new Ray(rayPoint, new Vector(-3,0,1));
		 assertNull("Ray's start before the triangle and Intersect",  t.findIntersections(r));
		
		 //TC03: Ray's Intersect against the vertex (0 points)
		 assertNull("Ray's start before the triangle and Intersect",  t.findIntersections(r));
		 
	}

}
