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

public class SpotLightTest {
	  @Test
	    public void spotLightTest2() throws Exception{
	        Scene scene = new Scene();
		scene.set_screenDistance(200);
		Sphere sphere = new Sphere( new Point3D(0.0, 0.0, -1000),500,new Color(255,255,100),new Material(1,1,10));
		sphere.get_material().set_nShininess(10);
		sphere.set_emmission(new Color(100, 0, 100));
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
										 new Point3D(-225, -125, -260),
										 new Point3D(-225, -225, -270), Color.BLUE,new Material(1,1,0));
			
		triangle.set_emmission(new Color (0, 0, 100));
		triangle.get_material().set_nShininess(200);
		scene.addGeometry(triangle);
		
		scene.addLight(new SpotLight( new Color(200, 200, 200),new Point3D(-150, -150, -150), 
					    0.1, 0.00001, 0.000005,new Vector(-2, -2, -3)));//new Color(100,100,100)
				ImageWriter imageWriter = new ImageWriter("Spot test 2", 1000, 1000, 1000, 1000);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		render.writeToimage();
	    }
		
	    
	    	
		

	    
	@Test
		public void spotLightTest3()throws Exception{
			
			Scene scene = new Scene();
			
			Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),new Point3D( -3500, -3500, -1000),new Point3D(  3500, -3500, -2000),Color.ORANGE);

			Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),new Point3D( -3500,  3500, -1000),new Point3D( -3500, -3500, -1000),Color.BLUE);
			
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);
			
			scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 0, 0.000001, 0.0000005,new Vector(-2, -2, -3)));
		
			
			ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);
			
			Render render = new Render(scene,imageWriter);
			
			render.renderImage();
			render.writeToimage();
			
		}

		@Test
		public void spotLightTest()throws Exception{
			
			Scene scene = new Scene();
			Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000),700,new Color(200,50,50),new Material(1,1,10));
			sphere.get_material().set_nShininess(100);
			sphere.set_emmission(new Color(0, 0, 20));//100
			scene.addGeometry(sphere);
			scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(300, 400, 600), 
						    0, 0.00001, 0.000005,new Vector(2, 2,-3)));//new Point3D(400, 400, 400)
		
			ImageWriter imageWriter = new ImageWriter("Spot test", 1000, 1000, 1000, 1000);
	                Render render = new Render(scene,imageWriter);
			render.renderImage();
			render.writeToimage();
			
		}
}
