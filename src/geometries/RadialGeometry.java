package geometries;

import java.awt.Color;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;

public abstract class RadialGeometry extends Geometry {
	
	
	protected double _radius;
	
	// ***************** Constructors ********************** // 


    public RadialGeometry(double _radius, Color _c)throws Exception {
    	super(_c);
	    this.set_radius(_radius);
    }
    
    public RadialGeometry(double _radius, Color _c,Material _m)throws Exception {
    	super(_m,_c);
	    this.set_radius(_radius);

    }


	// ***************** Getters/Setters ********************** // 
	      
	    

	public double get_radius() {
		return _radius;
	}

	public void set_radius(double _radius) {
		this._radius = _radius;
	}
	
	// ***************** Operations ******************** // 


	@Override
	public String toString() {
		return "RadialGeometry [_radius=" + _radius + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RadialGeometry other = (RadialGeometry) obj;
		if (Double.doubleToLongBits(_radius) != Double.doubleToLongBits(other._radius))
			return false;
		return true;
	}
	public abstract  List<Point3D> findIntersections(Ray ray);



	
	 
	
	


}
