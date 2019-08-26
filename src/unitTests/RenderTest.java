package unitTests;


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

public class RenderTest {

	@Test
	public void basicRendering() throws Exception{
        //    Point3D p0_camera=new Point3D(new Coordinate(20),new Coordinate(20),new Coordinate(20));
	//	Point3D p1_camera=new Point3D(new Coordinate(100),new Coordinate(100),new Coordinate(60));
          //      Point3D p2_camera=new Point3D(new Coordinate(200),new Coordinate(100),new Coordinate(100));
          //  Vector v1= new Vector(p1_camera);
          //  Vector v2=new Vector(p2_camera);
		Scene scene = new Scene();//("my_scene", Color.white, new AmbientLight(Color.LIGHT_GRAY,0.8), new ArrayList<Geometry>() , new Camera(new Point3D(p0_camera),v2,v1),100);
		
		scene.addGeometry(new Sphere(new Point3D(0.0, 0.0, -100),100.0 ,Color.BLUE));
		
                scene.addLight(new SpotLight(new Color(255,100,100),new Point3D(200,200,-150),0.0,0.00001,0.000005,new Vector(-2,-2,-3)));
		Triangle triangle = new Triangle(new Point3D( 100, 0, -149),new Point3D(  0, 100, -149),new Point3D( 100, 100, -149),Color.DARK_GRAY);
		
		Triangle triangle2 = new Triangle(new Point3D( 100, 0, -149), new Point3D(  0, -100, -149),  new Point3D( 100,-100, -149),Color.green);
		
		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -149),  new Point3D(  0, 100, -149), new Point3D(-100, 100, -149),Color.BLUE);
		
		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -149), new Point3D(  0,  -100, -149), new Point3D(-100, -100, -149),Color.RED);
		
                
		//scene.addGeometry(triangle);
		//scene.addGeometry(triangle2);
        //scene.addGeometry(triangle3);
		//scene.addGeometry(triangle4);
		
		ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		render.printGrid(10);//printGrid(50);
		render.writeToimage();		
	}

}
