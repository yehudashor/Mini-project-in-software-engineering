package geometries;

import primitives.*;

/**
 * interface to geometry shapes
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */
public abstract class Geometry implements Intersectable {
	/**
	 * emission
	 */
	protected Color emission = Color.BLACK;

	/**
	 * get normal to a shape in some point
	 * 
	 * @param point on the surface of the shape, we assume that the point which
	 *              given is on surface
	 * @return the normal to shape at a point
	 */
	public abstract Vector getNormal(Point3D point);

	/**
	 * get
	 * 
	 * @return the emission
	 */
	public Color getEmission() {
		return emission;
	}
	
	/**
	 * material
	 */
	private Material material = new Material();
	
	/**
	 * set
	 * @param emmission
	 * @return this
	 */
	public Geometry setEmission(Color emmission) {
		this.emission = emmission;
		return this;
	}

	/**
	 * get material
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * set material
	 * @param material the material to set
	 * @return this
	 */
	public Geometry setMaterial(Material material) {
		this.material = material;
		return this;
	}
	
	
}
