package primitives;

public class Vector {
Point3D point;


/*
 * 
 */
public Vector(Coordinate x, Coordinate y, Coordinate z) {
	point = new Point3D(x, y, z);
    if (point.equals(new Point3D(0, 0, 0))) {
    	point = null;
    	throw new IllegalArgumentException("Illegal Vector");
    }	
}
	


/*
 * 
 */
public Vector(double x, double y, double z) {
	point = new Point3D(x, y, z);
	
    if (point.equals(new Point3D(0, 0, 0))) {
    	point = null;
		throw new IllegalArgumentException("Illegal Vector");
    }
}

/*
 * 
 */
public Vector(Point3D point) {
	this.point = point;
}



}
