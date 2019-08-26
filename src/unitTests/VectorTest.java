package unitTests;

import org.junit.Assert;
import org.junit.Test;

import primitives.Vector;


public class VectorTest {

	@Test
	public void testAdd() {
		Vector v1 = new Vector(1,2,3);
		Vector v2 = new Vector(2,3,4);
		Vector v3 = new Vector(3,5,7);
		v2.add(v1);
		boolean b=v3.equals(v2);
		Assert.assertTrue(b);

	    
	}
	@Test
	public void testSub(){
		
		Vector v1 = new Vector(1,2,3);
		Vector v2 = new Vector(2,3,4);
		Vector v3 = new Vector(1,1,1);
		
		v2.substract(v1);
		boolean b=v3.equals(v2);
		Assert.assertTrue(b);
		
	}
	
	@Test
	public void testScaling()
	{
		Vector v1 = new Vector(1,2,3);
		Vector v2 = new Vector(3,6,9);
		
		v1.scale(3);
		Assert.assertTrue(v2.equals(v1));
	}
	
	@Test 
	public void testDotProduct()
	{
		Vector v1 = new Vector(1,2,3);
		Vector v2 = new Vector(4,5,6);
		double x = 32.0;
		double y = v1.dotProduct(v2);
		Assert.assertTrue(y == x);
		
	}
	
	@Test
	public void testLength()
	{
		Vector v = new Vector(8,6,0);
		double x = 10.0;
		
		Assert.assertTrue(v.length() == x);

	}
	
	//@Test
	//public void testNormalize()
	//{
		//Vector v1 = new Vector(8,6,0);
		//Vector v2 = new Vector(8/10,6/10,0);
		//v1.normalize();
		
		//Assert.assertTrue(v2.equals(v1));
	//}
		 
	//@Test
	//public void testCrossProduct()
//	{
	//	Vector v1 = new Vector(3,2,4);
		//Vector v2 = new Vector(4,1,2);
	//	Vector v3 = new Vector(0,2,-5);
		
      //  Vector v4 =v2.crossProduct(v1);
		
	//	Assert.assertTrue(v3.equals(v4));
	//}
	
	
	
	

}
