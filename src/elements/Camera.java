package elements;

import java.util.LinkedList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

/**
 * class present Camera
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 *
 */
public class Camera {
	/**
	 * Point3d
	 */
	private Point3D p0;

	/**
	 * Vector to
	 */
	private Vector vTo;

	/**
	 * Vector up
	 */
	private Vector vUp;

	/**
	 * Vector right
	 */
	private Vector vRight;

	/**
	 * The width of View Plane
	 */
	private double width;

	/**
	 * The height of View Plane
	 */
	private double height;

	/**
	 * The distance of camera from view plane
	 */
	private double distance;

	/**
	 * View Plane center point
	 */
	private Point3D pCenter;

	/**
	 * constructor
	 * 
	 * @param p0  : point 3D
	 * @param vTo : Vector to
	 * @param vUp :Vector up
	 */
	public Camera(Point3D p0, Vector vTo, Vector vUp) {

		if (!Util.isZero(vTo.dotProduct(vUp))) {
			throw new IllegalArgumentException("The vectors vTo and vUp are not orthogonals");
		}
		this.p0 = p0;
		this.vTo = vTo.normalized();
		this.vUp = vUp.normalized();
		this.vRight = vTo.crossProduct(vUp).normalize();

	}

	/**
	 * Getter p0
	 * 
	 * @return the point p0
	 */
	public Point3D getP0() {
		return p0;
	}

	/**
	 * Getter vector to
	 * 
	 * @return the vector to
	 */
	public Vector getvTo() {
		return vTo;
	}

	/**
	 * Getter vector Up
	 * 
	 * @return the vector Up
	 */
	public Vector getvUp() {
		return vUp;
	}

	/**
	 * Getter vector Right
	 * 
	 * @return the vector Right
	 */
	public Vector getvRight() {
		return vRight;
	}

	/**
	 * height getter
	 * 
	 * @return height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * width getter
	 * 
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Set of width & height of the View Plane
	 * 
	 * @param width  : width of the View plane
	 * @param height : height of the View Plane
	 * @return this camera
	 */
	public Camera setViewPlaneSize(double width, double height) {
		this.height = height;
		this.width = width;
		return this;
	}

	/**
	 * Set of The distance of camera from view plane
	 * 
	 * @param distance : the distance from the camera to the view plane
	 * @return this camera
	 */
	public Camera setDistance(double distance) {
		this.distance = distance;
		pCenter = p0.add(vTo.scale(distance));
		return this;
	}

	/**
	 * Compute beam rays that intersect the view plane at pixel include the pixel's
	 * central points Compute the ray that start in camera and intersect the view
	 * plane at the center of the pixel and after compute list of rays that
	 * 
	 * @param nX : Number of columns in the view plane
	 * @param nY : Number of rows in the view plane
	 * @param j  : The row's index of the pixel
	 * @param i  : The column's index of the pixel
	 * @return : beam rays as a list.
	 */
	public Ray constructRaysThroughPixel(int nX, int nY, int j, int i, int size) {
//		double rY = height / nY;
//		double rX = width / nX;
		Point3D pCenterOfPixel = constructSquareCentralPoint(height / nY, width / nX, nX, nY, j, i, pCenter);
//		if (size <= 1)
//			return List.of(new Ray(p0, pCenterOfPixel.subtract(p0)));
//		List<Ray> rays = new LinkedList<Ray>();
//		double squareHeight = rY / size;
//		double squareWidth = rX / size;
//		for (int row = 0; row < size; row++)
//			for (int colmun = 0; colmun < size; colmun++) {
//				Point3D result = constructSquareCentralPoint(squareHeight, squareWidth, size, size, colmun, row,
//						pCenterOfPixel);
//				rays.add(new Ray(p0, result.subtract(p0)));
//			}
		return new Ray(p0, pCenterOfPixel.subtract(p0));
	}
	
	/**
	 * calculate central point of square in target plane.
	 * 
	 * @param squareHeight - The height of the square.
	 * @param squareWidth  - The height of the square.
	 * @param nX           - Number of columns in the target plane.
	 * @param nY           - Number of rows in the target plane.
	 * @param j            - The row's index of the square.
	 * @param i            - The column's index of the square.
	 * @param pCenter      - Central point of the square.
	 * @return point of square in target plane
	 */
	private Point3D constructSquareCentralPoint(double squareHeight, double squareWidth, int nX, int nY, int j, int i,
			Point3D pCenter) {

		double heighFromPc = -((i - (nY) / 2d) * squareHeight);
		double widthFromPc = (j - (nX) / 2d) * squareWidth;
		Point3D pIJ = pCenter;
		if (heighFromPc != 0) {
			pIJ = pIJ.add(vUp.scale(heighFromPc));
		}
		if (widthFromPc != 0) {
			pIJ = pIJ.add(vRight.scale(widthFromPc));
		}
		return pIJ;
	}

	/**
	 * 
	 * @param nX
	 * @param nY
	 * @param j
	 * @param i
	 * @param size
	 * @return
	 */
	public Point3D[] verticesOfPixel(int nX, int nY, int j, int i) {
		Point3D[] vertices = new Point3D[4];
		Point3D pCenter = p0.add(vTo.scale(distance));
		Point3D pCenterOfPixel = constructSquareCentralPoint(height / nY, width / nX, nX, nY, j, i, pCenter);
		double squareHeight = height / nY / 2;
		double squareWidth = width / nX / 2;
		vertices[0] = pCenterOfPixel.add(vTo.scale(squareHeight)).add(vRight.scale(-squareWidth));
		vertices[1] = pCenterOfPixel.add(vTo.scale(squareHeight)).add(vRight.scale(squareWidth));
		vertices[2] = pCenterOfPixel.add(vTo.scale(-squareHeight)).add(vRight.scale(squareWidth));
		vertices[3] = pCenterOfPixel.add(vTo.scale(-squareHeight)).add(vRight.scale(-squareWidth));
		return vertices;
	}
}
