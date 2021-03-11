package primitives;

import java.lang.Math;
public class Vector {
	private Point3D head;

	/*
	 * 
	 */
	public Vector(Coordinate x, Coordinate y, Coordinate z) {
		head = new Point3D(x, y, z);
		if (head.equals(new Point3D(0, 0, 0))) {
			head = null;
			throw new IllegalArgumentException("Illegal Vector");
		}
	}

	/**
	 * @return the head
	 */
	public Point3D getHead() {
		return head;
	}


	/*
	 * 
	 */
	public Vector(double x, double y, double z) {
		head = new Point3D(x, y, z);

		if (head.equals(new Point3D(0, 0, 0))) {
			head = null;
			throw new IllegalArgumentException("Illegal Vector");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Vector))
			return false;
		Vector p = (Vector) obj;
		return this.head.equals(p.head);
	}

	/*
	 * 
	 */
	public Vector(Point3D point) {
		this.head = point;
	}

	/*
	 * 
	 */
	public Vector add(Vector other) {
        return new Vector(this.head.add(other));
	}

	/*
	 * 
	 */
	public Vector subtract(Vector other) {
		return this.head.subtract(other.head);
	}
	
	/**
	 * 
	 * @param scaler
	 * @return
	 */
	public Vector scale(double scaler){
		return new Vector(scaler * this.head.x.coord, scaler *  this.head.y.coord, scaler *  this.head.z.coord);
	}

	
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	public double dotProduct(Vector other){
		return this.head.x.coord * other.head.x.coord +
				this.head.y.coord * other.head.y.coord  + this.head.z.coord * other.head.z.coord;
	}
	
	/*
	 * 𝑢2 ∙ 𝑣3 − 𝑢3 ∙ 𝑣2 
	 * 𝑢3 ∙ 𝑣1 − 𝑢1 ∙ 𝑣3 
	 * 𝑢1 ∙ 𝑣2 − 𝑢2 ∙ 𝑣1
	 */
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	public Vector crossProduct(Vector other){
		double point1 = this.head.y.coord * other.head.z.coord - this.head.z.coord * other.head.y.coord;
		double point2 = this.head.z.coord * other.head.x.coord - this.head.x.coord * other.head.z.coord;
		double point3 = this.head.x.coord * other.head.y.coord - this.head.y.coord * other.head.x.coord;
		return new Vector(point1, point2, point3);
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	public double lengthSquared(){
		return this.dotProduct(this);
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	public double length() {
		return Math.sqrt(this.lengthSquared());
	}
	
	/**
	 * 
	 * @return
	 */
	public Vector normalize(){
	    this.head = new Point3D(this.head.x.coord / this.length(),
	    		this.head.y.coord / this.length(), this.head.z.coord / this.length()); 
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public Vector normalized(){
		return new Vector(this.head).normalize();
	}

	
	
	
}
