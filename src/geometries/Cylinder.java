package geometries;
import java.awt.Color;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public abstract class Cylinder extends RadialGeometry {
	
	private Point3D _axisPoint ;
	private Vector _axisDirection;
	
	// ***************** Constructors ********************** // 

	
	 public Cylinder(Point3D _axisPoint, Vector _axisDirection, double _radius, Color _c)throws Exception {
	        super(_radius,_c);
	        this._axisPoint = _axisPoint;
	        this._axisDirection = _axisDirection;
	    }

 	// ***************** Getters/Setters ********************** // 


	public Point3D get_axisPoint() {
		return _axisPoint;
	}

	public void set_axisPoint(Point3D _axisPoint) {
		this._axisPoint = _axisPoint;
	}

	public Vector get_axisDirection() {
		return _axisDirection;
	}

	public void set_axisDirection(Vector _axisDirection) {
		this._axisDirection = _axisDirection;
	}
	
	// ***************** Operations ******************** // 


	@Override
	public String toString() {
		return "Cylinder [_axisPoint=" + _axisPoint + ", _axisDirection=" + _axisDirection + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cylinder other = (Cylinder) obj;
		if (_axisDirection == null) {
			if (other._axisDirection != null)
				return false;
		} else if (!_axisDirection.equals(other._axisDirection))
			return false;
		if (_axisPoint == null) {
			if (other._axisPoint != null)
				return false;
		} else if (!_axisPoint.equals(other._axisPoint))
			return false;
		return true;
	}
	public Vector getNormal(primitives.Point3D p) {///fix!!!!!!!!!!!!!!!!!!!!1
        return (new Vector(this._axisDirection));
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
	
	
	
	
	
	



}
