/**
 * 
 */
package renderer;

import static org.junit.Assert.fail;

import java.util.MissingResourceException;

import elements.Camera;
import primitives.Color;
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
	 * scene
	 */
	private Scene scene;
	
	/**
	 * camera
	 */
	private Camera camera;
	
	/**
	 *  rayTracer
	 */
	private RayTracerBase rayTracer;

	/**
	 * set
	 * @param imageWriter the imageWriter to set
	 */
	public Render setImageWriter(ImageWriter imageWriter) {
		this.imageWriter = imageWriter;
		return this;
	}

	/**
	 * set
	 * @param scene the scene to set
	 */
	public Render setScene(Scene scene) {
		this.scene = scene;
		return this;
	}

	/**
	 * set
	 * @param camera the camera to set
	 */
	public Render setCamera(Camera camera) {
		this.camera = camera;
		return this;
	}

	/**
	 * set
	 * @param rayTracer the rayTracer to set
	 */
	public Render setRayTracer(RayTracerBase rayTracer) {
		this.rayTracer = rayTracer;
		return this;
	}

	public void renderImage() {
		if (imageWriter == null || scene == null || camera == null || rayTracer == null) {
			throw new MissingResourceException("One or more from the parmetrs are null", null, null);
		}
		
	//	for ( Camera it : camera.)
		//}
		//fail("NotImplementedException");
	}

	/**
	 * 
	 * @param interval
	 * @param color
	 */
	public void printGrid(int interval, Color color) {

	}

	/**
	 * 
	 */
	public void writeToImage() {

		if (imageWriter != null) {
			renderImage();
		} else {
			throw new MissingResourceException("One or more from the parmetrs are null", null, null);
		}

	}
}
