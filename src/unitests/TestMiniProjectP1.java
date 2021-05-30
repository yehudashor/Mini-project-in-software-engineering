package unitests;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.DirectionalLight;
import elements.PointLight;
import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.RayTracerBasic;
import renderer.Render;
import scene.Scene;

/**
 * Testing Vector
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com *
 */
public class TestMiniProjectP1 {

	private Scene scene = new Scene("Test scene");

	/**
	 * test for mini-project, build ablon model picture
	 */
	@Test
	public void projectP1Test() {		
		scene.lights.add(new SpotLight(new Color(300, 0, 0), new Point3D(0, 50, -750),//
				new Vector(0, -50, -1)) //
				.setkL(4E-5).setkQ(2E-7));
		scene.lights.add(new PointLight(new Color(0, 0, 200), new Point3D(250, 25, -600))//
				.setkL(0.00001).setkQ(0.000001));
		
		scene.lights.add(new DirectionalLight(new Vector(0, 0, -1), new Color(350, 350, 350)));
		
		Camera camera = new Camera(new Point3D(0, -700, 0), new Vector(0, 0.35, -0.35), new Vector(0, 0.35, 0.35))
				.setViewPlaneSize(150, 150).setDistance(400);

		Point3D center = new Point3D(0, 50, -800);
		Point3D p1 = new Point3D(0, 170, -800);
		Point3D p2 = new Point3D(104.4, 110, -800);
		Point3D p3 = new Point3D(104.4, -10, -800);
		Point3D p4 = new Point3D(0, -70, -800);
		Point3D p5 = new Point3D(-104.4, -10, -800);
		Point3D p6 = new Point3D(-104.4, 110, -800);
		
		Sphere overSpr = new Sphere(center, 120);
		overSpr.setEmission(new Color(0, 0, 0)).setMaterial(new Material().setkT(0.8).
				setEnShininess(1000).setKs(0.5).setKd(0.5));
		
		Color tableCol  = new Color(20, 20, 20);
		Material triangleMat = new Material().setKd(0.25).setKs(0.9).setEnShininess(500).setkT(0.2).setkR(0.8);
		Material triangleMat1 = new Material().setkR(0.7).setKd(0.3).setKs(1).setEnShininess(50);
		Triangle t1 = new Triangle(center, p1, p2); // up right		
		Triangle t2 = new Triangle(center, p2, p3); // middle right
		Triangle t3 = new Triangle(center, p3, p4); // down right
		Triangle t4 = new Triangle(center, p4, p5); // down left
		Triangle t5 = new Triangle(center, p5, p6); // middle left
		Triangle t6 = new Triangle(center, p6, p1); // up left
//		t1.setEmission(tableCol).setMaterial(triangleMat1);	
//		t2.setEmission(tableCol).setMaterial(triangleMat1);	
//		t3.setEmission(tableCol).setMaterial(triangleMat1);	
//		t4.setEmission(tableCol).setMaterial(triangleMat1);	
//		t5.setEmission(tableCol).setMaterial(triangleMat1);	
//		t6.setEmission(tableCol).setMaterial(triangleMat1);	

		Material firstMat = new Material().setkR(0.05).setKd(0.1).setKs(1).setEnShininess(100);
		double depthSp = -793;
		Sphere s1 = new Sphere(new Point3D(0, 151, depthSp), 10);
		Sphere s2 = new Sphere(new Point3D(-22, 138.5, depthSp), 10);
		Sphere s3 = new Sphere(new Point3D(-44, 126, depthSp), 10);
		Sphere s4 = new Sphere(new Point3D(-66, 113.5, depthSp), 10);
		Sphere s5 = new Sphere(new Point3D(-88, 101, depthSp), 10);
		Color firstColor = new Color(10,10,10);
		//Material firstMat = new Material().setKd(0.9).setKs(1).setEnShininess(1000);
		
//		s1.setEmission(firstColor).setMaterial(firstMat);
//		s2.setEmission(firstColor).setMaterial(firstMat);
//		s3.setEmission(firstColor).setMaterial(firstMat);
//		s4.setEmission(firstColor).setMaterial(firstMat);
//		s5.setEmission(firstColor).setMaterial(firstMat);
//		
		s1.setMaterial(firstMat);
		s2.setMaterial(firstMat);
		s3.setMaterial(firstMat);
		s4.setMaterial(firstMat);
		s5.setMaterial(firstMat);
		
		Sphere s16 = new Sphere(new Point3D(-88, 77, depthSp), 10);
		Sphere s15 = new Sphere(new Point3D(-66, 89.5, depthSp), 10);
		Sphere s14 = new Sphere(new Point3D(-44, 102, depthSp), 10);
		Sphere s13 = new Sphere(new Point3D(-22, 114.5, depthSp), 10);
		Sphere s12 = new Sphere(new Point3D(0, 127, depthSp), 10);
		Sphere s11 = new Sphere(new Point3D(22, 139.5, depthSp), 10);
		
//		s11.setEmission(firstColor).setMaterial(firstMat);
//		s12.setEmission(firstColor).setMaterial(firstMat);
//		s13.setEmission(firstColor).setMaterial(firstMat);
//		s14.setEmission(firstColor).setMaterial(firstMat);
//		s15.setEmission(firstColor).setMaterial(firstMat);
//		s16.setEmission(firstColor).setMaterial(firstMat);
//		
		s11.setMaterial(firstMat);
		s12.setMaterial(firstMat);
		s13.setMaterial(firstMat);
		s14.setMaterial(firstMat);
		s15.setMaterial(firstMat);
		s16.setMaterial(firstMat);

		Sphere s21 = new Sphere(new Point3D(0, 101, depthSp), 10);
		Sphere s22 = new Sphere(new Point3D(-22, 89.5, depthSp), 10);
		Sphere s23 = new Sphere(new Point3D(-44, 77, depthSp), 10);
		
		s21.setMaterial(firstMat);
		s22.setMaterial(firstMat);
		s23.setMaterial(firstMat);
		
		//Material matSmallSphere = new Material().setKr(0.05).setKd(0.1).setKs(1).setShininess(100);
		
		Sphere s71 = new Sphere(new Point3D(0, -1, depthSp), 10);
		Sphere s72 = new Sphere(new Point3D(22, 10.5, depthSp), 10);
		Sphere s73 = new Sphere(new Point3D(44, 23, depthSp), 10);
		Color secColor = new Color(175,175,175);
		//Material secMat = new Material().setKd(0.9).setKs(1).setEnShininess(1000);
		Material secMat = new Material().setkR(0.05).setKd(0.1).setKs(1).setEnShininess(100);
		s71.setEmission(secColor).setMaterial(secMat);
		s72.setEmission(secColor).setMaterial(secMat);
		s73.setEmission(secColor).setMaterial(secMat);

		Sphere s81 = new Sphere(new Point3D(88, 23, depthSp), 10);
		Sphere s82 = new Sphere(new Point3D(66, 10.5, depthSp), 10);
		Sphere s83 = new Sphere(new Point3D(44, -2, depthSp), 10);
		Sphere s84 = new Sphere(new Point3D(22, -14.5, depthSp), 10);
		Sphere s85 = new Sphere(new Point3D(0, -27, depthSp), 10);
		Sphere s86 = new Sphere(new Point3D(-22, -39.5, depthSp), 10);
		s81.setEmission(secColor).setMaterial(secMat);
		s82.setEmission(secColor).setMaterial(secMat);
		s83.setEmission(secColor).setMaterial(secMat);
		s84.setEmission(secColor).setMaterial(secMat);
		s85.setEmission(secColor).setMaterial(secMat);
		s86.setEmission(secColor).setMaterial(secMat);		
		
		Sphere s91 = new Sphere(new Point3D(88, -1, depthSp), 10);
		Sphere s92 = new Sphere(new Point3D(66, -13.5, depthSp), 10);
		Sphere s93 = new Sphere(new Point3D(44, -26, depthSp), 10);
		Sphere s94 = new Sphere(new Point3D(22, -38.5, depthSp), 10);
		Sphere s95 = new Sphere(new Point3D(0, -51, depthSp), 10);
		s91.setEmission(secColor).setMaterial(secMat);
		s92.setEmission(secColor).setMaterial(secMat);
		s93.setEmission(secColor).setMaterial(secMat);
		s94.setEmission(secColor).setMaterial(secMat);
		s95.setEmission(secColor).setMaterial(secMat);


		scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));
		scene.geometries.add(/*overSpr,*/ t1, t2, t3, t4, t5, t6, //
				s1, s2, s3, s4, s5, //
				s11, s12, s13, s14, s15, s16, //
				s21, s22, s23, //
				s71, s72, s73, //
				s81, s82, s83, s84, s85, s86,//
				s91, s92, s93, s94, s95);

		ImageWriter imageWriter = new ImageWriter("P1", 1000, 1000);
		Render render = new Render() //
				.setImageWriter(imageWriter) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene));

		render.renderImage(0);
		render.writeToImage();
	}

}
