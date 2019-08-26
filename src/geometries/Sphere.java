package geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Sphere extends RadialGeometry {
	
	private Point3D _center;

	// ***************** Constructors ********************** // 

	
public Sphere(Point3D _center, double _radius,Color _c)throws Exception {
	   super(_radius, _c);
       this._center = new Point3D(_center);
	  
	    }


public Sphere(Point3D _center, double _radius,Color _c,Material _m)throws Exception {
   super(_radius, _c,_m);
   this._center = new Point3D(_center);

    }



// ***************** Getters/Setters ********************** // 

	

	public Point3D get_center() {
		return new Point3D(_center);
	}

	public void set_center(Point3D _center) {
		this._center = new Point3D(_center);
	}
	
	// ***************** Operations ******************** // 


	@Override
	public String toString() {
		return "Sphere [_center=" + _center + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sphere other = (Sphere) obj;
		if (_center == null) {
			if (other._center != null)
				return false;
		} else if (!_center.equals(other._center))
			return false;
		return true;
	}
	
	@Override
    public Vector getNormal(Point3D p){
       // return (new Vector(p.subtract(_center)).normalize()); 
       p.substract(new Vector(_center));
       Vector n_V=new Vector(p);
       try{
       n_V.normalize();
       }
       catch(Exception e)
        {
            System.out.println(e.getMessage());            
        }       
       return new Vector(n_V); 
    }
	
	
	
	@Override
	public List<Point3D> findIntersections(Ray ray){
		List<Point3D> list = new ArrayList<Point3D>();
		Point3D p0=new Point3D(ray.get_P0());
		Vector v = new Vector(ray.get_direction());		
		Vector L= new Vector(p0,_center);
		double tm =L.dotProduct(v);
		double d= Math.sqrt((Math.pow(L.length(), 2.0))-Math.pow(tm, 2));
		if (d>this._radius)
			return list;
		double th= Math.sqrt(Math.pow(_radius, 2)-Math.pow(d, 2));
		double t1=tm-th;
		if (t1>=0){
			Vector vector = ray.get_direction();
			vector.scale(t1);
			Point3D p1= new Point3D(ray.get_P0());
			p1.add(vector);
			list.add(p1);
		}
		double t2=tm+th;
		if (t2>=0)
		{
			Vector vector = ray.get_direction();
			vector.scale(t2);
			Point3D p2= ray.get_P0();
			p2.add(vector);
			list.add(p2);
			
		}
		return list;
			

		
	}
	
	
	
	


}
