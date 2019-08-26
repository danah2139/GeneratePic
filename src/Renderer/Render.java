package Renderer;

import primitives.Ray;
import primitives.Vector;
import scene.Scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import elements.LightSource;
import geometries.FlatGeometry;
import geometries.Geometry;
import primitives.Point3D;



public class Render {
	protected Scene _scene; 
	protected  ImageWriter _imageWriter;
    private final int RECURSION_LEVEL = 3;

	
	// ***************** Constructors ********************** // 

	
	public Render(Scene _scene, ImageWriter _imageWriter) {
		super();
		this._scene = new Scene(_scene);
		this._imageWriter = new ImageWriter(_imageWriter);
	}

	// ***************** Getters/Setters ********************** // 


	public Scene get_scene() {
		return new Scene(_scene);
	}



	public void set_scene(Scene _scene) {
		this._scene = new Scene(_scene);
	}



	public ImageWriter get_imageWriter() {
		return new ImageWriter(_imageWriter);
	}



	public void set_imageWriter(ImageWriter _imageWriter) {
		this._imageWriter = new ImageWriter(_imageWriter);
	}
	
	// ***************** Operations ******************** // 

	
	//@Override
	//public String toString() {
		//return "Render [_scene=" + _scene + ", _imageWriter=" + _imageWriter + "]";
	//}



	public void renderImage()throws Exception{
		
		for (int i=0; i<this._imageWriter.getHeight();i++)
		{
			for(int j=0; j<this._imageWriter.getHeight();j++)
			{
				
				 ArrayList<Ray> nine_rays = this._scene.get_camera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), j, i,_scene.get_screenDistance(), _imageWriter.getWidth(),_imageWriter.getHeight());
	                Color temp_c=new Color(0,0,0);//new Color(_scene.getBackground().getRed(),_scene.getBackground().getGreen(),_scene.getBackground().getBlue());
	                Color final_color=new Color(0,0,0);
	                ArrayList<Color> colors_all_rays=new ArrayList<Color>();
	               
				for(int k=0; k<9; k++)
	                {        
				 //if (nine_rays != null)
					// System.out.println("nine  rays isnt null");
	               //int k = 0; // i added here
	                	Map<Geometry,List<Point3D>> intersectionPoints =getSceneRayIntersections(nine_rays.get(k));
	                 //if (intersectionPoints != null)
	    				//	 System.out.println("nine  rays isnt null");
	                	
	                if (intersectionPoints.isEmpty())
	                	{
	                		temp_c=_scene.get_background();
	                		colors_all_rays.add(temp_c);
	                 	}
	                	else
	                	{
	                		Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);
	                	//	 if (closestPoint != null)
		    				//	 System.out.println("nine  rays isnt null");
	                		for(Entry<Geometry,Point3D> g:closestPoint.entrySet())
	                		{
	                			
	                			// i added 
	                		//	if(g == null)
	                //				_imageWriter.writePixel(j ,i,  Color.black);
	                //			else{
	                	//			System.out.println("here");
	                			
	                		//		_imageWriter.writePixel(j,  i,  Color.white);
	                		//}
	                		//}
	                		
			//}
		//}
	                		temp_c=calcColor(g.getKey(),g.getValue(),nine_rays.get(k));
	                			colors_all_rays.add(temp_c);
	                		}
	                	}
	                	
	                	
	                }
	                
	               
	                //take the color of the center of the pixel: 
	                double red=0.5*colors_all_rays.get(0).getRed();
	                double green=0.5*colors_all_rays.get(0).getGreen();
	                double blue=0.5*colors_all_rays.get(0).getBlue();
	                //take the others:
	                for(int q=1; q<9; q++)
	                {
	                red+=0.0625*colors_all_rays.get(q).getRed();
	                green+=0.0625*colors_all_rays.get(q).getGreen();
	                blue+=0.0625*colors_all_rays.get(q).getBlue();                
	                }
	                
	                if(red>255)
	                	red=255;
	                if(green>255)
	                	green=255;
	                if(blue>255)
	                	blue=255;
	                
	                final_color=new Color((int)red,(int)green,(int)blue);
	                _imageWriter.writePixel(j, i, final_color);               
	            }
	        }
	}
		
	public void printGrid(int interval)
	{
		for (int i=0;i<_imageWriter.getHeight();i++)
			for (int j=0;j<_imageWriter.getWidth();j++)
			{
				if(i%interval==0||j%interval==0)				
					_imageWriter.writePixel(j, i, Color.white);
			    _imageWriter.writePixel(j,_imageWriter.getHeight()-1, Color.white);
		        _imageWriter.writePixel(_imageWriter.getWidth()-1,i, Color.white);      
				
			}
	}
	  private Ray constractRefractedRay(Geometry g, Point3D p, Ray inRay)throws Exception
	   {
	       Vector normal=g.getNormal(p);
	       normal.scale(-2);
	       p.add(normal);
	       return new Ray(p,inRay.get_direction());
	     
	   }
	   
	   private Ray constructReflectedRay(Vector normal, Point3D p, Ray inRay)throws Exception
	   {
	       Vector l=inRay.get_direction();
	       l.normalize();
	       normal.scale(-2*l.dotProduct(normal));
	       l.add(normal);
	       Vector R=new Vector(l);
	       R.normalize();
	       p.add(normal);
	       Ray reflectedRay=new Ray(p,R);
	       return reflectedRay;
	   }
	
    private Color calcDiffusiveComp(double Kd, Vector normal,Vector L ,Color lightIntensity)throws Exception
    {
        
        L.normalize();;
        double k=Math.abs(Kd*normal.dotProduct(L));
        int red=(int)(lightIntensity.getRed()*k);
        if(red>255)
            red=255;
        int green=(int)(lightIntensity.getGreen()*k);
        if(green>255)
            green=255;
        int blue=(int)(lightIntensity.getBlue()*k);
        if(blue>255)
        	blue=255;
        return new Color(red,green,blue);
    }
    
    
    private Color calcSpecularComp(double Ks, Vector V, Vector N,Vector L, int shininess ,Color lightIntensity) throws Exception
    {
        L.normalize();;
        N.normalize();
        Vector R=new Vector(L);
        N.scale(-2*L.dotProduct(N));
        R.add(N);
        V.normalize();
        double a=Math.abs(Ks*Math.pow(V.dotProduct(R),shininess));

  
        int blue=(int)(lightIntensity.getBlue()*a);
        int red=(int)(lightIntensity.getRed()*a);
        int green=(int)(lightIntensity.getGreen()*a);
        
        if(blue>255)
            blue=255;
        if(red>255)
            red=255;
        if(green>255)
            green=255;            
        return new Color(red,green,blue);       
    }
    
    private Color calcColor(Geometry g,Point3D p, Ray inRay) throws Exception
    {
    	return calcColor(g,p, inRay, 0);
    }
	private Color calcColor(Geometry geometry,Point3D point, Ray inRay , int level)throws Exception {
		if (level == RECURSION_LEVEL) return new Color(0, 0, 0);
		Color ambientLight= _scene.get_ambientLight().getIntensity(point);
		Color emissionLight=geometry.get_emmission();
		Iterator<LightSource>_lights=_scene.getLightIterator();
		Color diffuseLight=new Color(0,0,0);
		Color specularLight=new Color(0,0,0);
		Color diffuse=null; 
	    Color specular=null;
		while(_lights.hasNext()){
			LightSource light=_lights.next();
			if(!occluded(light,point,geometry)){
				Color lightIntensity=light.getIntensity(point);
				
			      diffuse= calcDiffusiveComp(geometry.get_material().get_Kd(), geometry.getNormal(point),
	                        light.getL(point), lightIntensity);     
	                
	                int RD=diffuseLight.getRed()+diffuse.getRed();
	                int GD=diffuseLight.getGreen()+diffuse.getGreen();
	                int BD=diffuseLight.getBlue()+diffuse.getBlue();
	                if(RD>255)
	                    RD=255;
	                if(GD>255)
	                    GD=255;
	                if(BD>255)
	                    BD=255;
	            
	                diffuseLight=new Color(RD,GD,BD);
	            
	            //
	            specular = calcSpecularComp(geometry.get_material().get_Ks(),
	                        new Vector(point, _scene.get_camera().get_P0()),
	                        geometry.getNormal(point), light.getL(point), geometry.get_material().get_nShininess(),lightIntensity);
	                int RS=specularLight.getRed()+specular.getRed();
	                int GS=specularLight.getGreen()+specular.getGreen();
	                int BS=specularLight.getBlue()+specular.getBlue();
	                if(RS>255)
	                    RS=255;
	                if(GS>255)
	                    GS=255;
	                if(BS>255)
	                    BS=255;
	            
	                specularLight=new Color(RS,GS,BS);
	                }
		}

		
	       double kr = geometry.get_material().getKr();
	       Color reflectedLight=new Color(0,0,0);
	              
	       if(kr!=0)
	       {
	    	   Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);// Recursive call for a reflected ray
	           Map<Geometry, Point3D> reflectedEntry = getClosestPoint(getSceneRayIntersections(reflectedRay));
	     for(Entry<Geometry,Point3D> b: reflectedEntry.entrySet()){
	    	   
	       Color reflectedColor = calcColor(b.getKey(), b.getValue(), reflectedRay, level + 1);//geometry, point
	       reflectedLight= new Color (reflectedLight.getRed()+(int)kr *reflectedColor.getRed(),
	    		   					reflectedLight.getGreen()+(int)kr * reflectedColor.getGreen(),
	    		   					reflectedLight.getBlue()+(int)kr * reflectedColor.getBlue());
	     }
	       }
	       else reflectedLight=new Color(0,0,0);
	       double kt = geometry.get_material().getKt();
	       Color refractedLight=new Color(0,0,0);
	       if(kt!=0)
	       {
	       Ray refractedRay = constractRefractedRay(geometry, point, inRay);// Recursive call for a refracted ray
	       Map<Geometry, Point3D> refractedEntry = getClosestPoint(getSceneRayIntersections(refractedRay));
	       for(Entry<Geometry,Point3D> b: refractedEntry.entrySet()){
	    	   
	      
	       Color refractedColor = calcColor(b.getKey(), b.getValue(), refractedRay, level + 1);
	       
	       refractedLight = new Color (refractedLight.getRed()+(int)kt * refractedColor.getRed(),
	    		   					refractedLight.getGreen()+(int)kt * refractedColor.getGreen(),
	    		   					refractedLight.getBlue()+(int)kt * refractedColor.getBlue());
	       }
	       }

		int red= ambientLight.getRed() + emissionLight.getRed()+ diffuseLight.getRed() + specularLight.getRed() + reflectedLight.getRed() + refractedLight.getRed();;
		int blue= ambientLight.getBlue() + emissionLight.getBlue() + diffuseLight.getBlue() + specularLight.getBlue() + reflectedLight.getBlue() + refractedLight.getBlue();;
		int green= ambientLight.getGreen() + emissionLight.getGreen() + diffuseLight.getGreen() + specularLight.getGreen() + reflectedLight.getRed()+ refractedLight.getBlue();
		if (red>255)
			red=255;
		if (blue>255)
			blue=255;
		if(green>255)
			green=255;
		return (new Color(red,green,blue));
			
		}
	private boolean occluded(LightSource light, Point3D point, Geometry geometry)throws Exception {
		Vector lightDirection = light.getL(point);
		lightDirection.scale(-1);
		lightDirection.normalize();
		Point3D geometryPoint = new Point3D(point);
		Vector epsVector = new Vector(geometry.getNormal(point));
		epsVector.scale(70);//2
		geometryPoint.add(epsVector);
		Ray lightRay = new Ray(geometryPoint, lightDirection);
		Map<Geometry, List<Point3D>> intersectionPoints =
		getSceneRayIntersections(lightRay);
		 //Flat geometry cannot self intersect
		if (geometry instanceof FlatGeometry){
		 intersectionPoints.remove(geometry);
		} 

		for (Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet())
			   if (entry.getKey().get_material().getKt() == 0)
			     return true;
	    return false;
			
	}
	
	private Map<Geometry,Point3D> getClosestPoint(Map<Geometry,List<Point3D>> intersectionPoints) {

		double distance = Double.MAX_VALUE;
		Point3D P0 = _scene.get_camera().get_P0();
		Map<Geometry,Point3D> minDistancePoint = new HashMap<Geometry,Point3D>();

		for (Entry<Geometry,List<Point3D>> entry: intersectionPoints.entrySet())
			for (Point3D point: entry.getValue()){
				
				double pointDistance=P0.direction(point);
				if ( pointDistance< distance)
				{
				     	minDistancePoint.clear();
			            minDistancePoint.put(entry.getKey(), new Point3D(point));
	     	            distance=pointDistance;
				}
				

				
			}
	
		
		return minDistancePoint;
     }
		


	private Map<Geometry,List<Point3D>> getSceneRayIntersections(Ray ray) {

		Iterator<Geometry> geometries = _scene.getGeometriesIterator();
		Map<Geometry,List<Point3D>> intersectionPoints = new HashMap<Geometry,List<Point3D>>();

		while (geometries.hasNext()){
			 Geometry geometry = geometries.next();	
			 List<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);
			 if(!geometryIntersectionPoints.isEmpty()){
			 intersectionPoints.put(geometry,geometryIntersectionPoints);
			 }
		   }
		return intersectionPoints;
		}
	public void writeToimage()
	{
		_imageWriter.writeToimage();
	}



}
