/**
 * 
 */
package scene;

import elements.AmbientLight;
import geometries.Geometries;
import primitives.Color;

/**
 * Class of scene 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 */
public class Scene {
	/**
	 * name of scene.
	 */
	public String name;
	
	/**
	 * background Color
	 */
	public Color background = Color.BLACK;
	
	/**
	 * Ambient Light
	 */
	public AmbientLight ambientLight = new AmbientLight(Color.BLACK, 0);
	
	/**
	 *  Geometries shape
	 */
	public Geometries geometries;

	/**
	 * constructor
	 * @param name : name of scene
	 */
	public Scene(String name) {
		this.name = name;
		this.geometries = new Geometries();
	}

	/**
	 * set for buck ground
	 * @param background the background to set
	 */
	public Scene setBackground(Color background) {
		this.background = background;
		return this;
	}

	/**
	 * set Ambient Light
	 * @param ambientLight the ambientLight to set
	 */
	public Scene setAmbientLight(AmbientLight ambientLight) {
		this.ambientLight = ambientLight;
		return this;
	}

	/**
	 * set Geometries
	 * @param geometries the geometries to set
	 */
	public Scene setGeometries(Geometries geometries) {
		this.geometries = geometries;
		return this;
	}
}
