package unitTests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Renderer.ImageWriter;
import Renderer.Render;
import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import scene.Scene;

public class LightTest {
	
	@Test 
	public void emmissionTest2()throws Exception{
		
		Scene scene = new Scene();
		scene.set_screenDistance(50);
		scene.addGeometry(new Sphere( new Point3D(0.0, 0.0, -150), 50,Color.blue));
		
		Triangle triangle = new Triangle(new Point3D( 100, 0, -149),
				 						 new Point3D(  0, 100, -149),
				 						 new Point3D( 100, 100, -149),Color.BLACK);
		
		Triangle triangle2 = new Triangle(new Point3D( 100, 0, -149),
				 			 			  new Point3D(  0, -100, -149),
				 			 			  new Point3D( 100,-100, -149),Color.WHITE);
		triangle2.set_emmission(new Color (50, 200, 50));
		
		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -149),
				 						  new Point3D(  0, 100, -149),
				 						  new Point3D(-100, 100, -149),Color.BLUE);
		triangle3.set_emmission(new Color (50, 50, 200));
		
		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -149),
				 			 			  new Point3D(  0,  -100, -149),
				 			 			  new Point3D(-100, -100, -149),Color.RED);
		triangle4.set_emmission(new Color (200, 50, 50));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
		ImageWriter imageWriter = new ImageWriter("Emmission test1", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		render.printGrid(50);
		render.writeToimage();
	}
	
     //   @Test
	//public void shadowTest2()throws Exception{//////????
		
		//Scene scene = new Scene();
	//	Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000),500,Color.blue,new Material(0.5,1,10));
		//sphere.get_material().set_nShininess(20);
		//sphere.set_emmission(new Color(0, 0, 100));
		
		
		
		//Triangle triangle = new Triangle(new Point3D( 3500, 3500, -2000),
			//	                         new Point3D(  -3500,  -3500, -1000),				 						 
				// 						 new Point3D(  3500, -3500, -2000),new Color(0,150,50),new Material(0.5,1,10));

		//Triangle triangle2 = new Triangle( new Point3D( 3500, 3500, -2000),
			//	new Point3D(  -3500,  3500, -1000),
				//new Point3D(  -3500, -3500, -1000),				 						 
				 //new Color(150,0,40),new Material(1,0.5,10));
		
		//scene.addGeometry(triangle);
		//scene.addGeometry(triangle2);
		//scene.addGeometry(sphere);
		
		//scene.addLight(new SpotLight(new Color(100, 100, 100),new Point3D(200, 200, -100), 
			//	    0.0, 0.000001, 0.0000005,new Vector(-2, -2, -3)));
	
		
		//ImageWriter imageWriter = new ImageWriter("shadow test1", 1000, 1000, 1000, 1000);
		
		//Render render = new Render(scene,imageWriter);
		
		//render.renderImage();
		//render.writeToimage();
		
	//}

	//@Test 
	//public void emmissionTest()throws Exception{
		
		//Scene scene = new Scene();
		//scene.set_screenDistance(50);
		//scene.addGeometry(new Sphere( new Point3D(0.0, 0.0, -1000), 20,Color.YELLOW));
		
		//Triangle triangle = new Triangle(new Point3D( 100, 0, -49),
			//	 						 new Point3D(  0, 100, -49),
				// 						 new Point3D( 100, 100, -49),Color.BLACK);
		
		//Triangle triangle2 = new Triangle(new Point3D( 100, 0, -49),
			//	 			 			  new Point3D(  0, -100, -49),
				// 			 			  new Point3D( 100,-100, -49),Color.WHITE);
		//triangle2.set_emmission(new Color (50, 200, 50));
		
		//Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49),
			//	 						  new Point3D(  0, 100, -49),
				// 						  new Point3D(-100, 100, -49),Color.BLUE);
		//triangle3.set_emmission(new Color (50, 50, 200));
		
		//Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49),
				 			// 			  new Point3D(  0,  -100, -49),
				 			 //			  new Point3D(-100, -100, -49),Color.RED);
		//triangle4.set_emmission(new Color (200, 50, 50));
		
		//scene.addGeometry(triangle);
		//scene.addGeometry(triangle2);
		//scene.addGeometry(triangle3);
		//scene.addGeometry(triangle4);
		
		//ImageWriter imageWriter = new ImageWriter("Emmission test", 500, 500, 500, 500);
		
		//Render render = new Render(scene,imageWriter);
		
		//render.renderImage();
		//render.printGrid(50);
		//render.writeToimage();
	//}
	
      //  @Test
	//public void shadowTest()throws Exception{//////????
		
		//Scene scene = new Scene();
		//Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000),500,Color.blue,new Material(0.5,1,10));
		//sphere.get_material().set_nShininess(20);
		//sphere.set_emmission(new Color(0, 0, 100));
		
		
		
		//Triangle triangle = new Triangle(new Point3D( 3500, 3500, -2000),
			//	                         new Point3D(  -3500,  -3500, -1000),				 						 
				// 						 new Point3D(  3500, -3500, -2000),new Color(0,150,50),new Material(0.5,1,10));

		//Triangle triangle2 = new Triangle( new Point3D( 3500, 3500, -2000),
			//	new Point3D(  -3500,  3500, -1000),
				//new Point3D(  -3500, -3500, -1000),				 						 
				 //new Color(150,0,40),new Material(1,0.5,10));
		
	//	scene.addGeometry(triangle);
	//	scene.addGeometry(triangle2);
		//scene.addGeometry(sphere);
		
		//scene.addLight(new SpotLight(new Color(100, 100, 100),new Point3D(200, 200, -100), 
			//	    0.0, 0.000001, 0.0000005,new Vector(-2, -2, -3)));
	
		
		//ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
		
		//Render render = new Render(scene,imageWriter);
		
		//render.renderImage();
		//render.writeToimage();
		
	//}
}
