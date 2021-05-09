/**
 * 
 */
package unitests;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import elements.Camera;
import geometries.Intersectable;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * Test Camera Intersactable
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 */
public class IntegrationTests {

	/**
	 * rays from camera
	 */
	public LinkedList<Ray> rays = new LinkedList<>();

	/**
	 * constructor
	 */
	public IntegrationTests() {
		rays = new LinkedList<>();
	}

	private Vector vTo = new Vector(0, 0, -1);
	private Vector vUp = new Vector(0, 1, 0);
	private Camera camera = new Camera(Point3D.ZERO, vTo, vUp).setDistance(1).setViewPlaneSize(3, 3);
	private Point3D p = new Point3D(0, 0, 0.5);

	/**
	 * build rays from camera through the view plane
	 */
	private void initRays() {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				rays.add(camera.constructRayThroughPixel(3, 3, i, j));
			}
		}
	}

	/**
	 * calculate sum of intersections between the rays and shape
	 * 
	 * @param i    shape
	 * @param rays rays from camera through the view plane
	 * @return sum of intersections between the rays and shape
	 */
	private int sumOfIntersections(Intersectable i, LinkedList<Ray> rays) {
		int sum = 0;

		for (Ray ray : rays) {
			List<Point3D> j = i.findIntersections(ray);
			if (j != null) {
				sum += j.size();
			}
		}
		return sum;
	}

	/**
	 * test of Sphere
	 */
	@Test
	public void cameraSphereIntersections() {

		// TC01 Sphere is in front of the camera (2 points)
		initRays();
		Sphere s = new Sphere(new Point3D(0, 0, -3), 1);
		assertEquals("Sphere is in front of the camera", 2, sumOfIntersections(s, rays));
		rays.clear();

		// TC02 Sphere is in front of the camera (18 points)
		s = new Sphere(new Point3D(0, 0, -2.5), 2.5);

		camera = new Camera(p, vTo, vUp).setDistance(1).setViewPlaneSize(3, 3);
		initRays();

		assertEquals("Sphere is in front of the camera (18 points)", 18, sumOfIntersections(s, rays));

		s = new Sphere(new Point3D(0, 0, -2), 2);
		// TC03 Sphere is in front of the camera but before the view plane (10 points)
		assertEquals("Sphere is in front of the camera but before the view plane (10 points)", 10,
				sumOfIntersections(s, rays));

		s = new Sphere(new Point3D(0, 0, -2), 4);

		// TC04 Sphere is in front of the camera and the view plane (9 points)
		assertEquals("Sphere is in front of the camera and the view plane (9 points)", 9, sumOfIntersections(s, rays));

		s = new Sphere(new Point3D(0, 0, 1), 0.5);

		// TC05 Sphere is in behind of the camera and the view plane (0 points)

		assertEquals("Sphere is in behind of the camera and the view plane (0 points)", 0, sumOfIntersections(s, rays));
	}

	/**
	 * test of plane
	 */
	@Test
	public void cameraPlaneIntersections() {
		Plane plane = new Plane(new Point3D(1.5, 1.5, -3), new Point3D(1.5, -1.5, -3), new Point3D(-1.5, 1.5, -3));
		initRays();

		// TC01 The plane is in front of the camera and parallel to the view plane (9
		// points)
		assertEquals("parallel to the view plane (9 points)", 9, sumOfIntersections(plane, rays));

		plane = new Plane(new Point3D(1.5, 1.5, -2.5), new Point3D(1.5, -1.5, -3), new Point3D(-1.5, 1.5, -3));

		// TC02 The plane intersect the plane which contain the view plane (9 points)
		assertEquals(" The plane intersect the plane which contain the view plane (9 points)", 9,
				sumOfIntersections(plane, rays));

		// TC03 The plane intersect the plane which contain the view plane (6 points)
		plane = new Plane(new Point3D(1.5, 1.5, -8), new Point3D(1.5, -1.5, -8), new Point3D(-1.5, 1.5, -2.5));
		assertEquals(" The plane intersect the plane which contain the view plane (6 points)", 6,
				sumOfIntersections(plane, rays));
	}

	/**
	 * test of triangle
	 */
	@Test
	public void cameraTriangleIntersections() {
		Triangle triangle = new Triangle(new Point3D(0, 1, -2), new Point3D(1, -1, -2), new Point3D(-1, -1, -2));
		initRays();

		// TC01 The triangle parallel to the view plane (1 point)
		assertEquals("The triangle parallel to the view plane (1 point)", 1, sumOfIntersections(triangle, rays));

		triangle = new Triangle(new Point3D(0, 20, -2), new Point3D(1, -1, -2), new Point3D(-1, -1, -2));

		// TC02 The triangle parallel to the view plane (2 points)
		assertEquals("The triangle parallel to the view plane (2 points)", 2, sumOfIntersections(triangle, rays));
	}
}
