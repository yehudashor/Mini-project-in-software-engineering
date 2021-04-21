/**
 * 
 */
package scene;

import elements.AmbientLight;
import geometries.Geometries;
import primitives.Color;

/**
 * @author josh5
 *
 */
public class Scene {
	public String name;
	public Color background = Color.BLACK;
	public AmbientLight ambientLight = new AmbientLight(Color.BLACK, 0);
	public Geometries geometries;
	/**
	 * @param name
	 * @param geometries
	 */
	public Scene(String name) {
		this.name = name;
		this.geometries = new Geometries();
	}
	/**
	 * @param background the background to set
	 */
	public Scene setBackground(Color background) {
		this.background = background;
		return this;
	}
	
	/**
	 * @param ambientLight the ambientLight to set
	 */
	public Scene setAmbientLight(AmbientLight ambientLight) {
		this.ambientLight = ambientLight;
		return this;
	}
	
	/**
	 * @param geometries the geometries to set
	 */
	public Scene setGeometries(Geometries geometries) {
		this.geometries = geometries;
		return this;
	}	
}
