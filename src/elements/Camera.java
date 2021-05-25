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
	 * @return the point p0
	 */
	public Point3D getP0() {
		return p0;
	}

	/**
	 * @return the vector to
	 */
	public Vector getvTo() {
		return vTo;
	}

	/**
	 * @return the vector Up
	 */
	public Vector getvUp() {
		return vUp;
	}

	/**
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
	public List<Ray> constructRaysThroughPixel(int nX, int nY, int j, int i, int size) {
		Point3D pCenter = p0.add(vTo.scale(distance));
		Point3D pCenterOfPixel = constructSquareCentralPoint(height / nY, width / nX, nX, nY, j, i, pCenter);
		List<Ray> rays = new LinkedList<Ray>();
		rays.add(new Ray(p0, pCenter.subtract(p0)));

		if (size != 0) {
			double squareHeight = height / nY / size;
			double squareWidth = width / nX / size;
			for (int row = 0; row < size; row++)
				for (int colmun = 0; colmun < size; colmun++) {
					Point3D result = constructSquareCentralPoint(squareHeight, squareWidth, size, size, colmun, row,
							pCenterOfPixel);
					rays.add(new Ray(p0, result.subtract(p0)));
				}
		}
		return rays;
	}

	/**
	 * calculate central point of square in target plane
	 * 
	 * @param squareHeight - The height of the square
	 * @param squareWidth  - The height of the square
	 * @param nX           : Number of columns in the target plane
	 * @param nY           : Number of rows in the target plane
	 * @param j            : The row's index of the square
	 * @param i            : The column's index of the square
	 * @param pCenter      : Central point of the square
	 * @return point of square in target plane
	 */
	private Point3D constructSquareCentralPoint(double squareHeight, double squareWidth, int nX, int nY, int j, int i,
			Point3D pCenter) {

		double heighFromPc = -((i - (nY - 1) / 2d) * squareHeight);
		double widthFromPc = (j - (nX - 1) / 2d) * squareWidth;
		Point3D pIJ = pCenter;
		if (heighFromPc != 0) {
			pIJ = pIJ.add(vUp.scale(heighFromPc));
		}
		if (widthFromPc != 0) {
			pIJ = pIJ.add(vRight.scale(widthFromPc));
		}
		return pIJ;
	}

}
