package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import geometries.Plane;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class PlaneTest {

	   @Test
		public void test() throws Exception {

			Point3D q0=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-200));
			Vector n= new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(1)));
			Plane plane=new Plane(q0,n);
			
			Ray r1=new Ray(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0)),new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-1))));
			List<Point3D> l=plane.findIntersections(r1);
			
			Coordinate c1=new Coordinate(0);
			Coordinate c2=new Coordinate(0);
			Coordinate c3=new Coordinate(-200);

			Point3D p1=new Point3D(c1,c2,c3);
			List <Point3D>lr = new ArrayList<Point3D>();
			lr.add(p1);
			assertEquals(lr,l);
			
			
		}


}
