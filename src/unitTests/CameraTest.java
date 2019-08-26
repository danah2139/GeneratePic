package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elements.Camera;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class CameraTest {

    
    public CameraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of constructRayThroughPixel method, of class camera.
     */
    @Test
    public void testConstructRayThroughPixel() throws Exception {
        System.out.println("constructRayThroughPixel");
        int Nx = 3;
        int Ny = 3;
        int x = 3;
        int y = 3;
        double screenDist = 100.0;
        double screenWidth = 150.0;
        double screenHeight = 150.0;
        Point3D Px=new Point3D(new Coordinate(0.0),new Coordinate(0.0), new Coordinate(-1.0));
        
        Vector Vto=new Vector(Px);
        Vector Vup=new Vector(new Point3D(new Coordinate(0.0),new Coordinate(1.0), new Coordinate(0.0)));
        Vector Vright=new Vector(new Point3D(new Coordinate(1.0),new Coordinate(0.0), new Coordinate(0.0)));
        
        Point3D p0=new Point3D(new Coordinate(0.0),new Coordinate(0.0), new Coordinate(0.0));
        
        Camera instance = new Camera(p0,Vto,Vright,Vup);//creating camera
        
        Vector calc_Vto=new Vector(new Point3D(new Coordinate(8),new Coordinate(7), new Coordinate(1)));
        Point3D calc_p0=new Point3D(new Coordinate(3),new Coordinate(4), new Coordinate(8));
        Point3D pc=new Point3D(calc_p0);//pc=p0+...
        calc_Vto.scale(screenDist);//d*Vto
        pc.add(calc_Vto);//pc=p0+d*Vto     //(19,18,10)    
        
        
        //p = pc + [14*(9,-7,-23)-25*(9,5,2)]/// p= [(3,4,8)+2*(8,7,1)] + [14*(9,-7,-23)-25*(9,5,2)]= (19,18,10)+[(126,-98,-322)-(225,125,50)]=(-80,-205,-362)
       
        Ray expResult = new Ray(p0,new Vector(new Point3D(new Coordinate(0.5773502691896257),new Coordinate(-0.5773502691896257), new Coordinate(-0.5773502691896257))));
        ArrayList<Ray> result = instance.constructRayThroughPixel(Nx, Ny, x, y, screenDist, screenWidth, screenHeight);
      //  assertEquals(expResult.get_P0().get_x().get_coordinate(), result.get_P0().get_x().get_coordinate(),0.01);
       // assertEquals(expResult.get_P0().get_y().get_coordinate(), result.get_P0().get_y().get_coordinate(),0.01);
        //assertEquals(expResult.get_P0().get_z().get_coordinate(), result.get_P0().get_z().get_coordinate(),0.01);
     
    }

}
