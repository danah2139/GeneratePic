package geometries;

import java.awt.Color;
import java.util.List;



import primitives.*;

public abstract class Geometry {
	protected Material _material ;
	Color _emmission;
	public abstract List<Point3D> findIntersections(Ray ray);


	// ***************** Constructors ********************** // 
	public Geometry(Material _material, Color _emmission) {
		super();
		this._material =new Material(_material);
		this._emmission = _emmission;
	}
	
  
   
	public Geometry(Color color) {
		super();
		this._material =new Material();
		this._emmission = color;
	}


	public Geometry() {
		super();
		this._material =new Material();
		this._emmission =new Color(255,255,255);
	}
	
	public Geometry(Geometry other){
		   super();
			this._material =new Material(other._material);
			this._emmission = other._emmission;		
	}


	// ***************** Getters/Setters ********************** // 

public Material get_material() {
		return _material;
	}


	public void set_material(Material _material) {
		this._material = _material;
	}


	public Color get_emmission() {
		return _emmission;
	}


	public void set_emmission(Color _emmission) {
		this._emmission = _emmission;
	}
	
	
	// ***************** Operations ******************** // 


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Geometry other = (Geometry) obj;
	if (_emmission == null) {
		if (other._emmission != null)
			return false;
	} else if (!_emmission.equals(other._emmission))
		return false;
	return true;
}



public abstract Vector getNormal(Point3D p) throws Exception;
   
	

}
