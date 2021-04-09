/**
 * 
 */
package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;

/**
 * Class to geometry shapes
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */

public class Geometries implements Intersectable {
	List<Intersectable> intersectable;

	/**
	 * 
	 */
	public Geometries() {
		intersectable = new ArrayList<Intersectable>();
	}
	
	/**
	 * 
	 * @param geometries
	 */
	public Geometries(Intersectable... geometries){
		intersectable = List.of(geometries);
	}
	
	/**
	 * 
	 * @param geometries
	 */
	 public void add(Intersectable... geometries){
		 intersectable.addAll(List.of(geometries));
	 }
	
	@Override
	public List<Point3D> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}

}
