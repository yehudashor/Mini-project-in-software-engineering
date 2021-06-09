/**
 * 
 */
package renderer;

import java.util.ArrayList;
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
		for (int i = 0; i < nY; i++) {
			for (int j = 0; j < nX; ++j) {
				Ray ray = camera.constructRaysThroughPixel(nX, nY, j, i, size);
				Ray[] r = camera.verticesOfPixel(nX, nY, j, i);
				Color[][] colors = new Color[size][size];
				colors[0][0] = rayTracer.traceRay(r[0]);
			    colors[0][size] = rayTracer.traceRay(r[1]);
	     		colors[size][0] = rayTracer.traceRay(r[2]);
				colors[size][size] = rayTracer.traceRay(r[3]);
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
		
		return new Point3D[][] {{ vertices[0], up, left, center}, // up left square
			{up, vertices[1], center, right}, // up right square
			{left, center, vertices[2], down }, // down left
			{center, right,  down, vertices[3]}}; // down right;
	}
	
	private Ray[][] t(Point3D[][] points){
		Ray[][] rays = new Ray[4][4];
		Point3D point = camera.getP0();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				rays[i][j] = new Ray(point, points[i][j].subtract(point));
			}
		}
		return rays;
	}
	
	

	private Color v(Color[][] colors, int size) {
		
		
		Color color = average(rays);

		if (color != null || n == 0)
			return color;
		Point3D[][] points = centerOfPixel(p);
		Ray[][] rays1 = t(points);
		color = Color.BLACK;
		for(int i = 0; i < 4; i++) {
			List<Ray> rays2 = List.of(rays1[i]);
			
			color = color.add(v(rays2, points[i], n - 1));
		}
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
