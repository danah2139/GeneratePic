package geometries;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;


public class Triangle extends Geometry implements FlatGeometry{
	
	protected Point3D _p1; 
	protected Point3D _p2; 
	protected Point3D _p3;
	
	// ***************** Constructors ********************** // 

	
	public Triangle(Point3D _p1, Point3D _p2, Point3D _p3,Color _color) {
		super(_color);
		this._p1 = new Point3D(_p1);
		this._p2 = new Point3D(_p2);
		this._p3 = new Point3D(_p3);
	}

	public Triangle(Point3D _p1, Point3D _p2, Point3D _p3,Color _color,Material _material) {
		super(_material,_color);
		this._p1 = new Point3D(_p1);
		this._p2 = new Point3D(_p2);
		this._p3 = new Point3D(_p3);
		
	}

	// ***************** Getters/Setters ********************** // 


	public Point3D get_p1() {
		return new Point3D(_p1);
	}

	public void set_p1(Point3D _p1) {
		this._p1 = new Point3D(_p1);
	}

	public Point3D get_p2() {
		return new Point3D(_p2);
	}

	public void set_p2(Point3D _p2) {
		this._p2 = new Point3D(_p2);
	}

	public Point3D get_p3() {
		return new Point3D(_p3);
	}

	public void set_p3(Point3D _p3) {
		this._p3 = new Point3D(_p3);
	}

	
	// ***************** Operations ******************** // 

	@Override
	public String toString() {
		return "Triangle [_p1=" + _p1 + ", _p2=" + _p2 + ", _p3=" + _p3 + "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (_p1 == null) {
			if (other._p1 != null)
				return false;
		} else if (!_p1.equals(other._p1))
			return false;
		if (_p2 == null) {
			if (other._p2 != null)
				return false;
		} else if (!_p2.equals(other._p2))
			return false;
		if (_p3 == null) {
			if (other._p3 != null)
				return false;
		} else if (!_p3.equals(other._p3))
			return false;
		return true;
	} 
	@Override
	public Vector getNormal(Point3D p){
		
		Vector v1=new Vector (_p1,_p2);
		Vector v2=new Vector (_p1,_p3);
		Vector v3=new Vector (v2.crossProduct(v1));
		v3.normalize();
		v3.scale(-1);
		return v3;}

	
	@Override
	public List<Point3D> findIntersections(Ray ray){
		
		List<Point3D> list = new ArrayList<Point3D>();
		Point3D p0 = ray.get_P0();
		Vector n = getNormal(_p3);
		Plane plane = new Plane(_p3,n);
		ArrayList<Point3D> planeList= (ArrayList<Point3D>)plane.findIntersections (ray);
		if (planeList.isEmpty())
			return list;
		Point3D point = planeList.get(0);
		Vector pt= new Vector(p0,point);
		Vector firstV2 = new Vector(p0,_p1);
		Vector firstV1 = new Vector(p0,_p2);
		Vector firstN = firstV1.crossProduct(firstV2);
		firstN.normalize();
		double side1 = pt.dotProduct(firstN)*-1 ; //side 1		
		Vector secondV1 = new Vector(p0,_p2);
		Vector secondV2 = new Vector(p0,_p3);
		Vector secondN = secondV2.crossProduct(secondV1);
		secondN.normalize();
		double side2 = pt.dotProduct(secondN)*-1 ; //side 2
		
		Vector thirdV1 = new Vector(p0,_p1);
		Vector thirdV2 = new Vector(p0,_p3);
		Vector thirdN = thirdV1.crossProduct(thirdV2);
		thirdN.normalize();
		double side3 = pt.dotProduct(thirdN)*-1 ; // side 3
		
		if ((side1>0 && side2>0 && side3>0) || (side1 <0 && side2<0 && side3<0))
			list.add(point);
		return list;
	}
}




		
		
		
		
	
		
		
		
	
	
	


