package unitTests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import geometries.Triangle;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class TriangleTest {

	   
	   @Test
		public void testFindIntersections() throws Exception {
			Coordinate c1=new Coordinate(100);
			Coordinate c2=new Coordinate(-100);
			Coordinate c3=new Coordinate(-200);
			Coordinate c4=new Coordinate();
			Point3D p1=new Point3D(c1,c2,c3);
			Point3D p2=new Point3D(c2,c2,c3);
			Point3D p3=new Point3D(c4,c1,c3);
			Triangle t=new Triangle(p1,p2,p3, Color.BLUE);
			
		//===============================
	//case1:no intersection points:
			//set the ray we want to check the intersection points with:
			Coordinate c5=new Coordinate(0.5773502691896257);
			Coordinate c6=new Coordinate(-0.5773502691896257);
			Point3D p=new Point3D(c5,c6,c6);
			Vector v=new Vector(p);
			Point3D p0=new Point3D();
			Ray ray=new Ray(p0,v);
			
			List <Point3D> pointList1=t.findIntersections(ray); //empty, no intersection points
			//setting new array list, empty; like the expected answer:
			List <Point3D> pointList2=new ArrayList<Point3D>();
			assertEquals(pointList2,pointList1);
			
		//****************
	//case2:intersection point in (0,0,-200)
			Vector v1=new Vector(new Point3D(c4,c4,new Coordinate(-1)));
			Ray ray1=new Ray(p0,v1);//ray is z, (0,0,-1)
			
			List <Point3D> pointList3=t.findIntersections(ray1);
			
			//setting new array list, with (0,0,-200); like the expected answer:
			Point3D p4=new Point3D(c4,c4,c3); //expected: (0,0,-200)
			List <Point3D> pointList4=new ArrayList<Point3D>();
			pointList4.add(p4);
			//assertEquals(pointList4,pointList3);//
		}

}
