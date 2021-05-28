package unitests;

import static org.junit.Assert.*;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import geometries.Triangle;
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.RayTracerBasic;
import renderer.Render;
import scene.Scene;

public class TestMiniProjectP1 {

	private Scene scene = new Scene("Test scene");

	@Test
	public void projectP1Test() {
		
		Camera camera = new Camera(new Point3D(0, 0, 0), new Vector(0, 0, -1), new Vector(-0.25, 0.43, 0)) //
				.setViewPlaneSize(300, 300).setDistance(400);
			
		Point3D center = new Point3D(0, 50, -800);
		Point3D p1 = new Point3D(0, 170, -800);
		Point3D p2 = new Point3D(104.4, 110, -800);
		Point3D p3 = new Point3D(104.4, -10, -800);
		Point3D p4 = new Point3D(0, -70, -800);
		Point3D p5 = new Point3D(-104.4, -10, -800);
		Point3D p6 = new Point3D(-104.4, 110, -800);
		
		Triangle t1 = new Triangle(center, p1, p2); // up right
		t1.setEmission(new Color(400, 0, 0));
		Triangle t2 = new Triangle(center, p2, p3); // middle right
		t2.setEmission(new Color(0, 400, 0));
		Triangle t3 = new Triangle(center, p3, p4); // down right
		t3.setEmission(new Color(0, 0, 400));
		Triangle t4 = new Triangle(center, p4, p5); // down left
		t4.setEmission(new Color(400, 0, 0));
		Triangle t5 = new Triangle(center, p5, p6); // middle left
		t5.setEmission(new Color(0, 400, 0));
		Triangle t6 = new Triangle(center, p6, p1); // up left
		t6.setEmission(new Color(0, 0, 400));
		
		scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));
		scene.geometries.add(t1, t2, t3, t4, t5, t6);
		//scene.setBackground(Color.GREEN);
		
		ImageWriter imageWriter = new ImageWriter("P1", 600, 600);
		Render render = new Render() //
				.setImageWriter(imageWriter) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene));

		render.renderImage();
		render.writeToImage();
	}

}

