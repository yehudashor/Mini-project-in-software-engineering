package geometries;

import java.util.List;
import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

/**
 * represent triangle
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */
public class Triangle extends Polygon {
	/**
	 * constructor
	 * 
	 * @param a point a
	 * @param b point b
	 * @param c point c
	 */
	public Triangle(Point3D a, Point3D b, Point3D c) {
		super(a, b, c);
	}

	@Override
	public List<Point3D> findIntersections(Ray ray) {	
		List<Point3D> intersection = plane.findIntersections(ray);
		if(intersection != null) {
			
			Vector vectros[] = new Vector[3];
			for(int i = 0; i < 3; ++i) {
				vectros[i] = vertices.get(i).subtract(ray.getP0());
			}
			
			Vector normals[] = new Vector[3];
			double[] scalars = new double[3];
			int i;
			for(i = 0; i < 2; ++i) {
				normals[i] = vectros[i].crossProduct(vectros[i + 1]);
				scalars[i] = Util.alignZero(ray.getDir().dotProduct(normals[i]));
				
				if(0 == scalars[i])
					return null;
			}
			normals[i] = vectros[i].crossProduct(vectros[0]);
			scalars[i] = Util.alignZero(ray.getDir().dotProduct(normals[i]));
			if(0 == scalars[i])
				return null;
			int count = 0;
			int	count1 = 0;
			for(int k = 0; k < scalars.length; k++)
			{
				if(scalars[k] > 0){
					count++;
				}
				if(scalars[k] < 0){
					count1++;
				}
			}
			if(count == scalars.length || count1 == scalars.length)
			{
				return intersection;
			}
			
			/*
			for (int j = 1; j < scalars.length; ++j) {
				if((scalars[j - 1] > 0 && scalars[j] < 0) || (scalars[j - 1] < 0 && scalars[j] > 0))
						return null;
			}	
			*/
			
		}
		
		return null;	
	}
}
