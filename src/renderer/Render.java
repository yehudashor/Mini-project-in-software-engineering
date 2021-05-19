/**
 * 
 */
package renderer;

import java.util.MissingResourceException;

import elements.Camera;
import primitives.Color;
import primitives.Ray;
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
	public void renderImage() {
		if (imageWriter == null || camera == null || rayTracer == null) {
			throw new MissingResourceException("One or more from the parmetrs are null", null, null);
		}
		int nX = imageWriter.getNx();
		int nY = imageWriter.getNy();
		for (int i = 0; i < nY; i++) {
			for (int j = 0; j < nX; ++j) {
				Ray ray = camera.constructRayThroughPixel(nX, nY, j, i);
				imageWriter.writePixel(j, i, rayTracer.traceRay(ray));
			}
		}
	}

	/**
	 * print grid on the picture
	 * 
	 * @param interval : size of each square in the grid.
	 * @param color of the grid
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
}
