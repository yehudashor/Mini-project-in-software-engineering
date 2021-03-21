package unitests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.source.tree.AssertTree;

import geometries.Tube;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * test Tube class
 * 
  @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com 
 *
 */
public class TubeTest {
	/**
	 * Test method for {@link geometries.Tube#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() {
		Ray r = new Ray(new Point3D(0, 0, 0.5), new Vector(0, 0, 1));
		Tube t = new Tube(r, 2);

		/**
		 * TC 01, normal vector to a point on the tube not paralleled to p0
		 */
		assertEquals("wrong caculation normal", new Vector(0, -1, 0), t.getNormal(new Point3D(0, -2, 2)));

		/**
		 * TC 02, normal vector to a point on the tube paralleled to p0
		 */
		assertEquals("wrong caculation normal", new Vector(0, -1, 0), t.getNormal(new Point3D(0, -2, 0.5)));

	}

}
