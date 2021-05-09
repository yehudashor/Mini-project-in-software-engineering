/**
 * 
 */
package unitests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import geometries.Intersectable.GeoPoint;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * Testing Ray
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */
public class RayTest {

	/**
	 * Test method for {@link primitives.Ray#findClosestPoint(java.util.List)}.
	 */
	@Test
	public void testFindClosestPoint() {
		Ray ray = new Ray(Point3D.ZERO, new Vector(1, 0, 0));
		List<Point3D> l = new LinkedList<Point3D>();
		
		// =============== Boundary Values Tests ==================

		// TC01: The Points' list is empty
		assertNull("The Points' list is empty", null);

		Point3D p0 = new Point3D(2, 0, 0);
		Point3D p1 = new Point3D(2.5, 0, 0);
		Point3D p2 = new Point3D(4, 0, 0);

		l.add(p0);
		l.add(p1);
		l.add(p2);

		// TC02: The first point in the list is the closest
		assertEquals("The first point in the list is the closest", p0, ray.findClosestPoint(l));

		// TC03: The last point in the list is the closest
		l.set(0, p2);
		l.set(2, p0);

		assertEquals("The last point in the list is the closest", p0, ray.findClosestPoint(l));

		// ============ Equivalence Partitions Tests ==============

		// TC03: The middle point in the list is the closest
		l.set(2, p1);
		l.set(1, p0);

		assertEquals("The middle point in the list is the closest", p0, ray.findClosestPoint(l));
	}

	/**
	 * Test method for {@link primitives.Ray#getClosestGeoPoint(java.util.List)}.
	 */
	@Test
	public void testGetClosestGeoPoint() {
		Ray ray = new Ray(Point3D.ZERO, new Vector(1, 0, 0));
		List<GeoPoint> l = new LinkedList<GeoPoint>();
		
		// =============== Boundary Values Tests ==================

		// TC01: The Points' list is empty
		assertNull("The Points' list is empty", null);

		GeoPoint p0 = new GeoPoint(null, new Point3D(2, 0, 0));
		GeoPoint p1 = new GeoPoint(null, new Point3D(2.5, 0, 0));
		GeoPoint p2 = new GeoPoint(null, new Point3D(4, 0, 0));

		l.add(p0);
		l.add(p1);
		l.add(p2);

		// TC02: The first point in the list is the closest
		assertEquals("The first point in the list is the closest", p0, ray.getClosestGeoPoint(l));

		// TC03: The last point in the list is the closest
		l.set(0, p2);
		l.set(2, p0);

		assertEquals("The last point in the list is the closest", p0, ray.getClosestGeoPoint(l));

		// ============ Equivalence Partitions Tests ==============

		// TC03: The middle point in the list is the closest
		l.set(2, p1);
		l.set(1, p0);

		assertEquals("The middle point in the list is the closest", p0, ray.getClosestGeoPoint(l));
	}
}
