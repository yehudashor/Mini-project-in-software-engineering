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
import primitives.Vector;
import scene.Scene;

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
//	public void renderImage() {
//		if (imageWriter == null || camera == null || rayTracer == null) {
//			throw new MissingResourceException("One or more from the parmetrs are null", null, null);
//		}
//		int nX = imageWriter.getNx();
//		int nY = imageWriter.getNy();
//		for (int i = 0; i < nY; i++) {
//			for (int j = 0; j < nX; ++j) {
//				Ray ray = camera.constructRayThroughPixel(nX, nY, j, i);
//				imageWriter.writePixel(j, i, rayTracer.traceRay(ray));
//			}
//		}
//	}

	// ===========================================================================================================
	/**
	 * renderImage - paint the picture file.
	 * 
	 * @throws builder pattern - if one of that create the Image tougher fields is
	 *                 null throw MissingResourceException.
	 */
	public void renderImage() {
		if (imageWriter == null || camera == null || rayTracer == null) {
			throw new MissingResourceException("One or more from the parmetrs are null", null, null);
		}

		int nX = imageWriter.getNx();
		int nY = imageWriter.getNy();
		int size = 8;

		Color color = Color.BLACK;
		double h = camera.getHeight() / nY;
		double w = camera.getHeight() / nX;
		for (int i = 0; i < nY; i++) {
			for (int j = 0; j < nX; ++j) {
				List<Ray> rays = new LinkedList<Ray>();
				Ray ray = camera.constructRayThroughPixel(nX, nY, j, i);
				for (int row = 0; row < size; row++) {
					for (int colmun = 0; colmun < size; colmun++) {
						rays.add(camera.constructRayThroughPixel(size, size, colmun, row, h, w));
					}
				}
				rays.add(ray);
				for (Ray r : rays) {
					Color color1 = rayTracer.traceRay(r);
					color = color.add(color1);
				}
				imageWriter.writePixel(j, i, color.reduce(rays.size()));
				color = Color.BLACK;
			}
		}
	}

//	public List<Ray> constructBeamRaysThrowTargetarea(int nX, int nY) {
//		List<Ray> rays = new LinkedList<>();
//		int size = 8;
//		double h = height / nX / size;
//		double w = width / nY / size;
//		for (double row = 0; row < size; row++)
//			for (double colmun = 0; colmun < size; colmun++) {
//				rays.add(constructRayThroughPixel(size, size, colmun, row));
//			}
//	}
//
//	}
	// =============================================================================================================

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

	/**
	 * calculates beam rays throw target area
	 * 
	 * @param radius radius of circle-target area
	 * @param center center of pixel
	 * @return beam rays
	 */
	private List<Ray> constructBeamRaysThrowTargetarea(double radius, Point3D center) {
		List<Ray> rays = null;
		int size = 4;

		Vector vUp = camera.getvUp();
		Vector vRight = camera.getvRight();
		Point3D p0 = camera.getP0();
		Point3D start = center.add(vUp.scale(radius)).add(vRight.scale(-radius));

		for (double i = 1; i < size; i++) {
			Point3D p = start.add(vUp.scale(i));
			for (double j = 1; j < size; j++) {
				p.add(vRight.scale(j));
				double d = p.distance(center);
				if (d < radius) {
					if (rays == null) {
						rays = new LinkedList<>();
					}
					rays.add(new Ray(p0, p.subtract(p0)));
				}
			}
		}
		return rays;
	}
}

//		for(double i = jump; i < size - 1; i++) {
//			//Point3D p = start.add(vUp.scale(i));
//			for(double j = jump; j < size - 1; j++) {
//				Point3D pIJ = center;
//
//				double heighFromPc = -(i - (size - 1) * pixelHeight);
//				double widthFromPc = j - (size) * pixelWidth;
//				if (heighFromPc != 0) {
//					pIJ = pIJ.add(vUp.scale(heighFromPc));
//				}
//				if (widthFromPc != 0) {
//					pIJ = pIJ.add(vRight.scale(widthFromPc));
//				}
//				double d =  pIJ.distance(center);
//				if(d < radius)
//				{
//					if(rays == null) {
//						rays = new LinkedList<>();
//					}
//					rays.add(new Ray(p0,  pIJ.subtract(p0)));
//				}	
//			}
//		}
