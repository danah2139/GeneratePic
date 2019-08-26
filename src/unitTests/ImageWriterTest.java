package unitTests;


import java.awt.Color;

import org.junit.Test;

import Renderer.ImageWriter;

public class ImageWriterTest {

	@Test
	public void test() {
		
		ImageWriter ImageWriter1= new ImageWriter("FirstTestImageWriter",500,500,50,50);
		for (int i=0;i<500;i++)
			for (int j=0;j<500;j++)
			{
				if(i<50||(i>=100 && i<150)||(i>=200 && i<250)||(i>=300 && i<350)||(i>=400 && i<450))
					ImageWriter1.writePixel(i, j, 255,0,0);
				else
					ImageWriter1.writePixel(i, j, 0,255,0);	
				
			}
		ImageWriter1.writeToimage();
		int []redArray= {255,0,0};
		int []blueArray= {0,0,255};
		
		ImageWriter ImageWriter2= new ImageWriter("SecondTestImageWriter",500,500,50,50);
		for (int i=0;i<500;i++)
			for (int j=0;j<500;j++)
			{
				if(i<50||(i>=100 && i<150)||(i>=200 && i<250)||(i>=300 && i<350)||(i>=400 && i<450))
					ImageWriter2.writePixel(i, j,redArray);
				else
					ImageWriter2.writePixel(i, j,blueArray);	
				
			}
		ImageWriter2.writeToimage();
		
		
		ImageWriter ImageWriter3= new ImageWriter("ThirdTestImageWriter",500,500,50,50);
		for (int i=0;i<500;i++)
			for (int j=0;j<500;j++)
			{
				if(i<50||(i>=100 && i<150)||(i>=200 && i<250)||(i>=300 && i<350)||(i>=400 && i<450))
					ImageWriter3.writePixel(i, j,Color.RED);
				else
					ImageWriter3.writePixel(i, j,Color.BLUE);	
				
			}
		ImageWriter3.writeToimage();
		
		
		
		

		

	}

}
