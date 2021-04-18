package unitests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import geometries.Sphere;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * testing Sphere
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 */
public class SphereTest {

	/**
	 * 
	 * Test method for {@link geometries.Sphere#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() {
		Sphere sphere = new Sphere(new Point3D(0, 0, 0), 2);
		// ============ Equivalence Partitions Tests ==============

		// TC 01: test if gets a normal vector to a point on the sphere
		assertEquals("wrong normal caculation", new Vector(1.73, 0, 1).normalize(),
				sphere.getNormal(new Point3D(1.73, 0, 1)));
	}

	/**
	 * Test method for {@link geometries.Sphere#findIntersections(primitives.Ray)}.
	 */
	@Test
	public void testFindIntersections() {
		Sphere sphere = new Sphere(new Point3D(1, 0, 0), 1d);

		// ============ Equivalence Partitions Tests ==============
		Point3D r = new Point3D(-1, 0, 0);

		// TC01: Ray's line is outside the sphere (0 points)
		assertNull("Ray's line out of sphere", sphere.findIntersections(new Ray(r, new Vector(1, 1, 0))));

		// TC02: Ray starts before and crosses the sphere (2 points)
		Point3D p1 = new Point3D(0.0651530771650466, 0.355051025721682, 0);
		Point3D p2 = new Point3D(1.53484692283495, 0.844948974278318, 0);
		List<Point3D> result = sphere.findIntersections(new Ray(r, new Vector(3, 1, 0)));
		assertEquals("Wrong number of points", 2, result.size());
		if (result.get(0).getX() > result.get(1).getX())
			result = List.of(result.get(1), result.get(0));
		assertEquals("Ray crosses sphere", List.of(p1, p2), result);

		// TC03: Ray starts inside the sphere (1 point)
		result = sphere.findIntersections(new Ray(new Point3D(0.5, 0, 0), new Vector(1.08, -0.02, 0.82)));
		assertEquals("Wrong number of points", 1, result.size());
		assertEquals("Wrong point", new Point3D(1.5761664768422614, -0.01992900883041225, 0.817089362046902),
				result.get(0));

		// TC04: Ray starts after the sphere (0 points)
		assertNull("Ray's line after the sphere",
				sphere.findIntersections(new Ray(new Point3D(3, 0, 0), new Vector(1, 0, 0))));

		// =============== Boundary Values Tests ==================

		// **** Group: Ray's line crosses the sphere (but not the center)
		// TC11: Ray starts at sphere and goes inside (1 points)
		Point3D point = new Point3D(1.5, 0.87, 0);
		result = sphere.findIntersections(new Ray(point, new Vector(0, -1.73, 0)));

		// assertEquals("Wrong number of points", 1, result.size());
		assertEquals("Wrong point", new Point3D(1.5, 0.866025403784, 0), result.get(0));

		// TC12: Ray starts at sphere and goes outside (0 points)
		result = sphere.findIntersections(new Ray(point, new Vector(0, 1.73, 0)));
		assertNull("Ray's line after the sphere", result);

		// **** Group: Ray's line goes through the center
		// TC13: Ray starts before the sphere (2 points)
		Vector v = new Vector(0, -2.5, 0);
		Point3D p = new Point3D(1, -1, 0);
		result = sphere.findIntersections(new Ray(new Point3D(1, 1.5, 0), v));
		assertEquals("Wrong number of points", 2, result.size());
		assertEquals("Wrong point0", new Point3D(1, 1, 0), result.get(0));
		assertEquals("Wrong point1", p, result.get(1));

		// TC14: Ray starts at sphere and goes inside (1 points)
		result = sphere.findIntersections(new Ray(new Point3D(1, 1, 0), v));
		assertEquals("Wrong number of points", 1, result.size());
		assertEquals("Wrong point", p, result.get(0));

		// TC15: Ray starts inside (1 points)
		result = sphere.findIntersections(new Ray(new Point3D(1, 0.5, 0), v));
		assertEquals("Wrong number of points", 1, result.size());
		assertEquals("Wrong point", p, result.get(0));

		// TC16: Ray starts at the center (1 points)

		result = sphere.findIntersections(new Ray(new Point3D(1, 0, 0), v));
		assertEquals("Wrong number of points", 1, result.size());
		assertEquals("Wrong point", p, result.get(0));

		// TC17: Ray starts at sphere and goes outside (0 points)
		result = sphere.findIntersections(new Ray(p, v));
		assertNull("Ray starts at sphere and goes outside ", result);

		// TC18: Ray starts after sphere (0 points)
		result = sphere.findIntersections(new Ray(new Point3D(1, -1.1, 0), v));
		assertNull("Ray starts after sphere ", result);

		// **** Group: Ray's line is tangent to the sphere (all tests 0 points)
		// TC19: Ray starts before the tangent point
		v = new Vector(3, 0, 0);
		result = sphere.findIntersections(new Ray(new Point3D(0, -1, 0), v));
		assertNull("Ray starts before the tangent point ", result);

		// TC20: Ray starts at the tangent point
		result = sphere.findIntersections(new Ray(p, v));
		assertNull("Ray starts at the tangent point ", result);

		// TC21: Ray starts after the tangent point
		result = sphere.findIntersections(new Ray(new Point3D(1.9, -1, 0), v));
		assertNull("Ray starts after the tangent point ", result);

		// **** Group: Special cases
		// TC19: Ray's line is outside, ray is orthogonal to ray start to sphere's
		// center line
		result = sphere.findIntersections(new Ray(new Point3D(1, -2, 0), v));
		assertNull("Ray's line is outside, ray is orthogonal to ray start to sphere's center line ", result);

	}

}