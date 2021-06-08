/**
 * 
 */
package renderer;

import java.util.LinkedList;
import java.util.List;
import java.util.MissingResourceException;

import elements.Camera;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;

/**
 * represent the Render
 *
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 *
 */
public class Render {

	/**
	 * imageWriter
	 */
	private ImageWriter imageWriter;

	/**
	 * camera
	 */
	private Camera camera;

	/**
	 * rayTracer
	 */
	private RayTracerBase rayTracer;

	/**
	 * set
	 * 
	 * @param imageWriter the imageWriter to set
	 */
	public Render setImageWriter(ImageWriter imageWriter) {
		this.imageWriter = imageWriter;
		return this;
	}

	/**
	 * set
	 * 
	 * @param camera the camera to set
	 */
	public Render setCamera(Camera camera) {
		this.camera = camera;
		return this;
	}

	/**
	 * set
	 * 
	 * @param rayTracer the rayTracer to set
	 */
	public Render setRayTracer(RayTracerBase rayTracer) {
		this.rayTracer = rayTracer;
		return this;
	}

	/**
	 * renderImage - paint the picture file.
	 * 
	 * @throws builder pattern - if one of that create the Image tougher fields is
	 *                 null throw MissingResourceException.
	 */
	public void renderImage(int size) {
		if (imageWriter == null || camera == null || rayTracer == null) {
			throw new MissingResourceException("One or more from the parmetrs are null", null, null);
		}

		int nX = imageWriter.getNx();
		int nY = imageWriter.getNy();
		Color color = Color.BLACK;
		Point3D pointP0 = camera.getP0();
		for (int i = 0; i < nY; i++) {
			for (int j = 0; j < nX; ++j) {
				Ray ray = camera.constructRaysThroughPixel(nX, nY, j, i, size);
				Point3D[] p = camera.verticesOfPixel(nX, nY, j, i);
				
//				for (Point3D point : p)
//					rays.add(new Ray(pointP0, point.subtract(pointP0)));
				imageWriter.writePixel(j, i, color);
				color = Color.BLACK;
			}
		}
	}

	/**
	 * 
	 * @param rays
	 * @param color
	 * @return
	 */
	private Color average(List<Ray> rays) {
		List<Color> c = new LinkedList<Color>();
		Color color = Color.BLACK;
		Color color1 = Color.BLACK;
		for (Ray r : rays) {
			color1 = rayTracer.traceRay(r);
			color = color.add(color1);
			c.add(color1);
		}

		color1 = color.reduce(rays.size());
		for (Color col : c) {
			if (col != color1)
				return null;
		}
		return color1;
	}

	private Point3D[][] centerOfPixel(Point3D[] vertices) {
		Point3D up = vertices[0].middlePoint(vertices[1]);
		Point3D left = vertices[0].middlePoint(vertices[2]);
		Point3D right = vertices[1].middlePoint(vertices[3]);
		Point3D down = vertices[2].middlePoint(vertices[3]);
		Point3D center = vertices[0].middlePoint(vertices[3]);
		Point3D p = camera.getP0();
		

		Point3D[][] vSquars = new Point3D[4][4];
		
		// =====================================================================
		
		return vSquars;
	}

	private Color v(List<Ray> rays, Point3D[] vertices, int n) {

		Color color = average(rays);

		if (color != null)
			return color;

		return null;
	}

	/**
	 * print grid on the picture
	 * 
	 * @param interval : size of each square in the grid.
	 * @param color    of the grid
	 */
	public void printGrid(int interval, Color color) {
		int nX = imageWriter.getNx();
		int nY = imageWriter.getNy();
		int gap = 1;
		for (int i = 0; i < nY; i++) {
			gap = i % interval == 0 ? 1 : interval;
			for (int j = 0; j < nX; j += gap) {
				imageWriter.writePixel(j, i, color);
			}
		}
	}

	/**
	 * create the picture file
	 */
	public void writeToImage() {

		if (imageWriter != null) {
			imageWriter.writeToImage();
		} else {
			throw new MissingResourceException("One or more from the parmetrs are null", null, null);
		}
	}
	
	
	
	
	
	
	
	
	
//	/**
//	 * renderImage - paint the picture file.
//	 * 
//	 * @param size - number of squares in each pixel
//	 * @throws builder pattern - if one of that create the Image tougher fields is
//	 *                 null throw MissingResourceException.
//	 */
//	public void renderImage(int size) {
//		if (imageWriter == null || camera == null || rayTracer == null) {
//			throw new MissingResourceException("One or more from the parmetrs are null", null, null);
//		}
//		
//		int nX = imageWriter.getNx();
//		int nY = imageWriter.getNy();
//		for (int i = 0; i < nY; i++) {
//			for (int j = 0; j < nX; ++j) {
//				List<Ray> rays = camera.constructRaysThroughPixel(nX, nY, j, i, size);
//				Color color = Color.BLACK;
//				for (Ray r : rays)
//					color = color.add(rayTracer.traceRay(r));
//				imageWriter.writePixel(j, i, color.reduce(rays.size()));
//			}
//		}
//	}

}
