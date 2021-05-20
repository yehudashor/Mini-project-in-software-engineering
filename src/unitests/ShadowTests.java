package unitests;

import org.junit.Test;

import elements.*;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;

/**
 * Testing basic shadows
 * 
 * @author Dan
 */
public class ShadowTests {
	private Scene scene = new Scene("Test scene");
	private Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
			.setViewPlaneSize(200, 200).setDistance(1000);

	/**
	 * Produce a picture of a sphere and triangle with point light and shade
	 */
	@Test
	public void sphereTriangleInitial() {
		scene.geometries.add( //
				new Sphere(new Point3D(0, 0, -200), 60) //
						.setEmission(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setKd(0.5).setKs(0.5).setEnShininess(30)), //
				new Triangle(new Point3D(-70, -40, 0), new Point3D(-40, -70, 0), new Point3D(-68, -68, -4)) //
						.setEmission(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setKd(0.5).setKs(0.5).setEnShininess(30)) //
		);
		scene.lights.add( //
				new SpotLight(new Color(400, 240, 0), new Point3D(-100, -100, 200), new Vector(1, 1, -3)) //
						.setkL(1E-5).setkQ(1.5E-7));

		Render render = new Render(). //
				setImageWriter(new ImageWriter("shadowSphereTriangleInitial", 400, 400)) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();
	}

	/**
	 * Produce a picture of a two triangles lighted by a spot light with a Sphere
	 * producing a shading
	 */
	@Test
	public void trianglesSphere() {
		scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));

		scene.geometries.add( //
				new Triangle(new Point3D(-150, -150, -115), new Point3D(150, -150, -135), new Point3D(75, 75, -150)) //
						.setMaterial(new Material().setKs(0.8).setEnShininess(60)), //
				new Triangle(new Point3D(-150, -150, -115), new Point3D(-70, 70, -140), new Point3D(75, 75, -150)) //
						.setMaterial(new Material().setKs(0.8).setEnShininess(60)), //
				new Sphere(new Point3D(0, 0, -115), 30) //
						.setEmission(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setKd(0.5).setKs(0.5).setEnShininess(30)) //
		);
		scene.lights.add( //
				new SpotLight(new Color(700, 400, 400), new Point3D(40, 40, 115), new Vector(-1, -1, -4)) //
						.setkL(4E-4).setkQ(2E-5));

		Render render = new Render() //
				.setImageWriter(new ImageWriter("shadowTrianglesSphere", 600, 600)) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();
	}

}





















///*
//package unittests;
//
//import org.junit.Test;
//
//import elements.*;
//import geometries.*;
//import primitives.*;
//import renderer.*;
//import scene.Scene;
//
///**
// * Testing basic shadows
// * 
// * @author Dan
// */
//public class ShadowTests {
//
//	/**
//	 * Produce a picture of a sphere and triangle with point light and shade
//	 */
//	@Test
//	public void SphereTriangleInitial() {
//		Scene scene = new Scene("Test scene");
//		scene.setCamera(new Camera(new Point3D(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
//		scene.setDistance(1000);
//		scene.setBackground(Color.BLACK);
//		scene.setAmbientLight(new AmbientLight(Color.BLACK, 0));
//
//		scene.addGeometries(new Sphere(new Material(0.5, 0.5, 30),new Color(java.awt.Color.BLUE),  //
//				 new Point3D(0, 0, 200),60), //
//				new Triangle( new Material(0.5, 0.5, 30),new Color(java.awt.Color.BLUE), //
//						new Point3D(-70, 40, 0), new Point3D(-40, 70, 0), new Point3D(-68, 68, 4)));
//
//		scene.addLights(new SpotLight(new Color(400, 240, 0), //
//				new Point3D(-100, 100, -200), 1, 1E-5, 1.5E-7, new Vector(1, -1, 3),10));
//
//		ImageWriter imageWriter = new ImageWriter("sphereTriangleInitial", 200, 200, 400, 400);
//		Render render = new Render(imageWriter, scene);
//
//		render.renderImage(100);
//		render.writeToImage();
//	}
//
//	/**
//	 * Sphere-Triangle shading - move triangle up-right
//	 */
//	@Test
//	public void SphereTriangleMove1() {
//		Scene scene = new Scene("Test scene");
//		scene.setCamera(new Camera(new Point3D(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
//		scene.setDistance(1000);
//		scene.setBackground(Color.BLACK);
//		scene.setAmbientLight(new AmbientLight(Color.BLACK, 0));
//
//		scene.addGeometries(new Sphere(new Material(0.5, 0.5, 30), new Color(java.awt.Color.BLUE), //
//				 new Point3D(0, 0, 200),60), //
//				new Triangle(new Material(0.5, 0.5, 30),new Color(java.awt.Color.BLUE),  //
//						new Point3D(-45, 15, 0), new Point3D(-15, 45, 0), new Point3D(-53, 53, 4)));
//
//		scene.addLights(new SpotLight(new Color(400, 240, 0), //
//				new Point3D(-100, 100, -200), 1, 1E-5, 1.5E-7, new Vector(1, -1, 3)));
//
//		ImageWriter imageWriter = new ImageWriter("sphereTriangleMove1", 200, 200, 400, 400);
//		Render render = new Render(imageWriter, scene);
//
//		render.renderImage();
//		render.writeToImage();
//	}
//	
//	/**
//	 * Sphere-Triangle shading - move triangle upper-righter
//	 */
//	@Test
//	public void SphereTriangleMove2() {
//		Scene scene = new Scene("Test scene");
//		scene.setCamera(new Camera(new Point3D(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
//		scene.setDistance(1000);
//		scene.setBackground(Color.BLACK);
//		scene.setAmbientLight(new AmbientLight(Color.BLACK, 0));
//
//		scene.addGeometries(new Sphere(new Material(0.5, 0.5, 30),new Color(java.awt.Color.BLUE),  //
//				 new Point3D(0, 0, 200),60), //
//				new Triangle(new Material(0.5, 0.5, 30),new Color(java.awt.Color.BLUE),  //
//						new Point3D(-65, 45, 0), new Point3D(-45, 65, 0), new Point3D(-60, 60, 4)));
//
//		scene.addLights(new SpotLight(new Color(400, 240, 0), //
//				new Point3D(-100, 100, -200),  1, 1E-5, 1.5E-7,new Vector(1, -1, 3)));
//
//		ImageWriter imageWriter = new ImageWriter("sphereTriangleMove2", 200, 200, 400, 400);
//		Render render = new Render(imageWriter, scene);
//
//		render.renderImage();
//		render.writeToImage();
//	}
//
//	/**
//	 * Sphere-Triangle shading - move spot closer
//	 */
//	@Test
//	public void SphereTriangleSpot1() {
//		Scene scene = new Scene("Test scene");
//		scene.setCamera(new Camera(new Point3D(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
//		scene.setDistance(1000);
//		scene.setBackground(Color.BLACK);
//		scene.setAmbientLight(new AmbientLight(Color.BLACK, 0));
//
//		scene.addGeometries(new Sphere(new Material(0.5, 0.5, 30),new Color(java.awt.Color.BLUE),  //
//				 new Point3D(0, 0, 200),60), //
//				new Triangle(new Material(0.5, 0.5, 30), new Color(java.awt.Color.BLUE), //
//						new Point3D(-70, 40, 0), new Point3D(-40, 70, 0), new Point3D(-68, 68, 4)));
//
//
//		scene.addLights(new SpotLight(new Color(400, 240, 0), //
//				new Point3D(-80, 80, -110), 1, 1E-5, 1.5E-7, new Vector(1, -1, 3)));
//
//		ImageWriter imageWriter = new ImageWriter("sphereTriangleSpot1", 200, 200, 400, 400);
//		Render render = new Render(imageWriter, scene);
//
//		render.renderImage();
//		render.writeToImage();
//	}	
//	
//	/**
//	 * Sphere-Triangle shading - move spot even more close
//	 */
//	@Test
//	public void SphereTriangleSpot2() {
//		Scene scene = new Scene("Test scene");
//		scene.setCamera(new Camera(new Point3D(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
//		scene.setDistance(1000);
//		scene.setBackground(Color.BLACK);
//		scene.setAmbientLight(new AmbientLight(Color.BLACK, 0));
//
//		scene.addGeometries(new Sphere(new Material(0.5, 0.5, 30),new Color(java.awt.Color.BLUE),  //
//				 new Point3D(0, 0, 200),60), //
//				new Triangle(new Material(0.5, 0.5, 30),new Color(java.awt.Color.BLUE),  //
//						new Point3D(-70, 40, 0), new Point3D(-40, 70, 0), new Point3D(-68, 68, 4)));
//
//		scene.addLights(new SpotLight(new Color(400, 240, 0), //
//				new Point3D(-70, 70, -75), 1, 1E-5, 1.5E-7, new Vector(1, -1, 3)));
//
//		ImageWriter imageWriter = new ImageWriter("sphereTriangleSpot2", 200, 200, 400, 400);
//		Render render = new Render(imageWriter, scene);
//
//		render.renderImage();
//		render.writeToImage();
//	}	
//	
//	/**
//	 * Produce a picture of a two triangles lighted by a spot light with a Sphere producing a shading
//	 */
//	@Test
//	public void trianglesSphere() {
//		Scene scene = new Scene("Test scene");
//		scene.setCamera(new Camera(new Point3D(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
//		scene.setDistance(1000);
//		scene.setBackground(Color.BLACK);
//		scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));
//
//		scene.addGeometries( //
//				new Triangle(new Material(0, 0.8, 60),Color.BLACK,  //
//						new Point3D(-150, 150, 115), new Point3D(150, 150, 135), new Point3D(75, -75, 150)), //
//				new Triangle(new Material(0, 0.8, 60),Color.BLACK,  //
//						new Point3D(-150, 150, 115), new Point3D(-70, -70, 140), new Point3D(75, -75, 150)), //
//				new Sphere(new Material(0.5, 0.5, 30),new Color(java.awt.Color.BLUE),  // )
//						 new Point3D(0, 0, 115),30));
//
//		scene.addLights(new SpotLight(new Color(700, 400, 400), //
//				new Point3D(40, -40, -115), 1, 4E-4, 2E-5, new Vector(-1, 1, 4)));
//
//		ImageWriter imageWriter = new ImageWriter("trianglesSphere", 200, 200, 600, 600);
//		Render render = new Render(imageWriter, scene);
//
//		render.renderImage();
//		render.writeToImage();
//	}
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
