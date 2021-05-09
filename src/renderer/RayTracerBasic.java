/**
 * 
 */
package renderer;

import java.util.List;

import elements.LightSource;
import geometries.Intersectable.GeoPoint;
import primitives.Color;
import primitives.Material;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;
import static primitives.Util.*;

/**
 * represent Ray Tracer Basic which extends RayTracerBase
 *
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 */

public class RayTracerBasic extends RayTracerBase {

	/**
	 * constructor
	 * 
	 * @param scene
	 */
	public RayTracerBasic(Scene scene) {
		super(scene);
	}

	@Override
	public Color traceRay(Ray ray) {
		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray);
		if (intersections == null) {
			return scene.background;
		}
		GeoPoint closestPoint = ray.getClosestGeoPoint(intersections);
		return calcColor(closestPoint, ray);
	}

	/**
	 * help function that calculate the color of the Point
	 * 
	 * @param closestPoint closest Point
	 * @param ray          ray direction of the camera
	 * @return final color in the point
	 */
	private Color calcColor(GeoPoint closestPoint, Ray ray) {
		return scene.ambientLight.getIntensity().add(closestPoint.geometry.getEmission())
				.add(calcLocalEffects(closestPoint, ray));
	}

	/**
	 * calculate the color reflect from the point by Fong's model
	 * 
	 * @param intersection the point
	 * @param ray          ray direction of the camera
	 * @return the color reflect from the point
	 */
	private Color calcLocalEffects(GeoPoint intersection, Ray ray) {
		Vector v = ray.getDir();
		Vector n = intersection.geometry.getNormal(intersection.point);
		double nv = alignZero(n.dotProduct(v));
		if (nv == 0)
			return Color.BLACK;
		Material material = intersection.geometry.getMaterial();
		int nShininess = material.enShininess;
		double kd = material.kD;
		double ks = material.kS;
		Color color = Color.BLACK;

		for (LightSource lightSource : scene.lights) {
			Vector l = lightSource.getL(intersection.point);
			double nl = alignZero(n.dotProduct(l));
			// sign(nl) == sing(nv)
			if (nl * nv > 0) {
				Color lightIntensity = lightSource.getIntensity(intersection.point);
				color = color.add(calcDiffusive(kd, l, n, lightIntensity),
						calcSpecular(ks, l, n, v, nShininess, lightIntensity));
			}
		}
		return color;
	}

	/**
	 * help function for fong's model calculate the specular of light
	 * 
	 * @param ks
	 * @param l
	 * @param n
	 * @param v
	 * @param nShininess
	 * @param lightIntensity light's intensity originally
	 * @return intensity of light with the specular
	 */
	private Color calcSpecular(double ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
		Vector r = l.add(n.scale(-2 * l.dotProduct(n)));
		double t = alignZero(-r.dotProduct(v));
		return t > 0 ? lightIntensity.scale(ks * Math.pow(t, nShininess)) : Color.BLACK;
	}

	/**
	 * help function for fong's model calculate the diffuse of light
	 * 
	 * @param kd
	 * @param l
	 * @param n
	 * @param lightIntensity light's intensity originally
	 * @return intensity of light after the diffusion
	 */
	private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {
		double s = l.dotProduct(n);
		if (s < 0)
			s = -s;
		// ensure the absolute value of l.dotProduct(n) in scalar
		return lightIntensity.scale(kd * s);
	}

}
