/**
 * 
 */
package unitests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import geometries.Geometries;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * Test for Class geometry shapes
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */
public class GeometriesTest {

	/**
	 * Test method for {@link geometries.Geometries#findIntersections(primitives.Ray)}.
	 */
	@Test
	public void testFindIntersections() {
		Geometries g = new Geometries();
		Plane pln = new Plane(new Point3D(1,0,2), new Vector(0,0,1));
		Sphere sphere = new Sphere(new Point3D(1, 0, 0), 1d);
		Triangle t = new Triangle(new Point3D(1, 0, 2), new Point3D(-3, -1, 2), new Point3D(-2, 3, 2));
		g.add(pln, sphere, t);
		// ============ Equivalence Partitions Tests ==============
		
		Ray r = new Ray(new Point3D(1,5,4), v);
		
		// TC02 There are no intersections with any shape(0 point)
		assertNull("There are no intersections with any shape", g.findIntersections(r));
		
		// =============== Boundary Values Tests ==================
		
		// TC01 empty list (0 point)
				assertNull("Empty list", g.findIntersections(null));
		
		
	}

}
