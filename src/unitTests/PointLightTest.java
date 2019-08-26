package unitTests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Renderer.ImageWriter;
import Renderer.Render;
import elements.PointLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import scene.Scene;

public class PointLightTest {

	@Test
	 public void PointLightIT() throws Exception{
        Scene scene = new Scene();
        Sphere sphere = new Sphere (new Point3D(0.0, 0.0, -1000),500,Color.blue);
        sphere.get_material().set_nShininess(20);
        sphere.set_emmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);
        scene.addLight(new PointLight(new Color(255,100,100),new Point3D(-200, -200, -100), 0, 0.00001, 0.000005));//0, 0.00001, 0.000005

        ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);

        Render render = new Render(scene,imageWriter);
        render.renderImage();
        render.writeToimage();

}

@Test
public void pointLightTest2()throws Exception{

Scene scene = new Scene();
Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1200),500,Color.RED,new Material(0.4,0.3,1));
sphere.get_material().set_nShininess(100);
sphere.set_emmission(new Color(50, 50, 50));

Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
		 						 new Point3D( -3500, -3500, -1000),
		 						 new Point3D(  3500, -3500, -2000),Color.green,new Material());

Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
		  						  new Point3D( -3500,  3500, -1000),
		  						  new Point3D( -3500, -3500, -1000),Color.blue,new Material());
scene.addGeometry(sphere);
scene.addGeometry(triangle);
scene.addGeometry(triangle2);

        scene.addLight(new PointLight( new Color(255, 100, 100),new Point3D(200, 200, -100), 
			   0, 0.000001, 0.0000005));


ImageWriter imageWriter = new ImageWriter("Point test 2", 500, 500, 500, 500);

Render render = new Render(scene, imageWriter);

render.renderImage();
render.writeToimage();

}

}
