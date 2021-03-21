package unitests;

import static org.junit.Assert.*;
import org.junit.Test;
import geometries.Sphere;
import primitives.Point3D;
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
		/**
		 * TC 01: test if gets a normal vector to a point on the sphere
		 */
		assertEquals("wrong normal caculation", new Vector(1.73, 0, 1).normalize(),
				sphere.getNormal(new Point3D(1.73, 0, 1)));
	}

}